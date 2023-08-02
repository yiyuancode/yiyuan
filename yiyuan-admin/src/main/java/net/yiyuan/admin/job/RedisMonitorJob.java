package net.yiyuan.admin.job;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.core.sys.config.BaseJob;
import net.yiyuan.core.sys.dto.SysRedisEditDTO;
import net.yiyuan.core.sys.dto.SysRedisListDTO;
import net.yiyuan.core.sys.dto.SysRedisMonitorAddDTO;
import net.yiyuan.core.sys.enums.SysRedisIsMonitorEnabledEnum;
import net.yiyuan.core.sys.service.SysRedisMonitorService;
import net.yiyuan.core.sys.service.SysRedisService;
import net.yiyuan.core.sys.vo.SysRedisQueryVO;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 主机监控任务
 *
 * @author 一源团队-花和尚
 * @date 2023/07/16
 */
@Component
@Slf4j
public class RedisMonitorJob implements BaseJob {

  private static DecimalFormat decimalFormat = new DecimalFormat("#.##");
  @Resource SysRedisService sysRedisService;
  @Resource SysRedisMonitorService sysRedisMonitorService;

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.warn("Redis监控任务 执行时间: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    try {
      // 查询开启监控redis服务
      SysRedisListDTO sysRedisListDTO = new SysRedisListDTO();
      sysRedisListDTO.setIsMonitorEnabled(SysRedisIsMonitorEnabledEnum.OPEN);
      List<SysRedisQueryVO> redisQueryVOList = sysRedisService.list(sysRedisListDTO);
      for (SysRedisQueryVO item : redisQueryVOList) {
        // "106.54.87.159", 50006
        // 创建 Jedis 实例并连接到 Redis
        Jedis jedis = new Jedis(item.getHost(), item.getPort());
        if (StringUtilsPlus.isNotEmpty(item.getPassword())) {
          jedis.auth(item.getPassword());
        }
        // 执行 info 命令获取 Redis 指标信息
        String info = jedis.info();
        SysRedisEditDTO modelDto = getModelDto(info);
        SysRedisEditDTO keyCount = getKeyCount(info);
        BeanUtilsPlus.copy(keyCount, modelDto);
        modelDto.setId(item.getId());
        // 更新redis最新数据
        sysRedisService.edit(modelDto);

        // 拆入reidis监控记录表
        SysRedisMonitorAddDTO sysRedisMonitorAddDTO = new SysRedisMonitorAddDTO();
        BeanUtilsPlus.copy(modelDto, sysRedisMonitorAddDTO);
        sysRedisMonitorAddDTO.setRedisId(modelDto.getId());
        sysRedisMonitorService.add(sysRedisMonitorAddDTO);
        // 关闭 Jedis 连接
        jedis.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 解析reids的info信息获取所有key总和以及过期key总和,因为key的格式和前面的信息数据格式不一致所以单独解析
   *
   * @param info redis的info字符串
   * @return {@link SysRedisEditDTO}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private static SysRedisEditDTO getKeyCount(String info) {
    Map<Integer, Integer> dbKeyCountMap = new LinkedHashMap<>();
    long totalKeyCount = 0;
    long totalExpiredKeyCount = 0;
    String[] lines = info.split("\\r?\\n");
    for (String line : lines) {
      if (line.startsWith("db")) {
        String[] parts = line.split(":");
        int dbIndex = Integer.parseInt(parts[0].substring(2));
        String[] stats = parts[1].split(",");
        int dbKeyCount = Integer.parseInt(stats[0].substring(5));
        int dbExpiredCount = Integer.parseInt(stats[1].substring(8));

        dbKeyCountMap.put(dbIndex, dbKeyCount);
        totalKeyCount += dbKeyCount;
        totalExpiredKeyCount += dbExpiredCount;
      }
    }
    SysRedisEditDTO sysRedisEditDTO = new SysRedisEditDTO();
    sysRedisEditDTO.setTotalKeyCount(totalKeyCount);
    sysRedisEditDTO.setTotalExpiredKeyCount(totalExpiredKeyCount);
    return sysRedisEditDTO;
  }

  /**
   * 解析reids的info信息转化获取数据库实体dto
   *
   * @param info redis的info字符串
   * @return {@link Map<String, Integer>}
   * @author 一源团队--花和尚
   * @date 2023-07-27
   */
  private static SysRedisEditDTO getModelDto(String info) {
    // 定义正则表达式
    Pattern p = Pattern.compile("^# (.+)$|^([\\w_]+):(.+)$", Pattern.MULTILINE);
    Matcher m = p.matcher(info);

    // 解析 Redis 指标信息字符串
    Map<String, Map<String, String>> sections = new HashMap<>();
    Map<String, String> section = null;
    while (m.find()) {
      String key = toCamelCase(m.group(2));
      String value = m.group(3);
      if (key == null) {
        section = new HashMap<>();
        sections.put(m.group(1), section);
      } else {
        if (section == null) {
          section = new HashMap<>();
          sections.put("", section);
        }
        section.put(key, value.trim());
      }
    }
    Map<String, String> oneRedisMap = new HashMap<>();
    // 输出解析结果
    for (Map.Entry<String, Map<String, String>> entry : sections.entrySet()) {
      String sectionName = entry.getKey();
      Map<String, String> sectionMap = entry.getValue();
      oneRedisMap.putAll(sectionMap);
      System.out.println("[" + sectionName + "]");
      for (Map.Entry<String, String> sectionEntry : sectionMap.entrySet()) {
        String sectionKey = sectionEntry.getKey();
        String sectionValue = sectionEntry.getValue();
        System.out.println(sectionKey + " = " + sectionValue);
      }
      System.out.println();
    }
    //        // 将 map 转换为 bean
    SysRedisEditDTO sysRedisEditDTO = BeanUtil.mapToBean(oneRedisMap, SysRedisEditDTO.class, true);
    return sysRedisEditDTO;
  }

  // Convert a string to camel case
  private static String toCamelCase(String str) {
    if (StringUtilsPlus.isEmpty(str)) {
      return null;
    }

    String[] parts = str.split("_");
    StringBuilder camelCase = new StringBuilder();
    for (int i = 0; i < parts.length; i++) {
      if (i == 0) {
        camelCase.append(parts[i]);
      } else {
        camelCase.append(Character.toUpperCase(parts[i].charAt(0)));
        camelCase.append(parts[i].substring(1));
      }
    }
    return camelCase.toString();
  }

  // Parse a string value into the appropriate type
  private static Object parseValue(String str) {
    try {
      return Long.parseLong(str);
    } catch (NumberFormatException e) {
    }

    try {
      return Double.parseDouble(str);
    } catch (NumberFormatException e) {
    }

    if (str.equals("true") || str.equals("false")) {
      return Boolean.parseBoolean(str);
    }

    return str;
  }

  private static String formatNumber(Number number) {
    return decimalFormat.format(number);
  }

  private static String formatMemory(Number memory) {
    float memoryInMb = (float) memory / (1024 * 1024 * 1024);
    return formatNumber(memoryInMb);
  }
}
