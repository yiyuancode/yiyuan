package net.yiyuan.core.file.filecontext;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.file.config.FileOperatorConfigInter;
import net.yiyuan.core.file.enums.FileOperatorTypeEnum;
import net.yiyuan.core.file.exception.FileOperatorException;
import net.yiyuan.core.file.operator.FileOperatorInter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/** 文件操作上下文 */
@Slf4j
@Component
public class FileOperatorContext {

  /** 需要再次初始化的集合 */
  private final Set<FileOperatorTypeEnum> needInitAgain = new HashSet<>();
  /** 文件操作器集合 */
  private final Map<FileOperatorTypeEnum, FileOperatorInter> operatorMap =
      new ConcurrentHashMap<>(2);
  /** 当前指定的文件操作器名 */
  @Value("${file.server.common.activeTypeName}")
  private String activeTypeName;

  @Resource private ApplicationContext applicationContext;
  /** 是否首次初始化 */
  private boolean firstInit = true;

  @PostConstruct
  private void init() {
    // 必要参数检查
    Arrays.stream(FileOperatorTypeEnum.values())
        .filter(type -> type.name().equals(activeTypeName))
        .findFirst()
        .orElseThrow(
            () ->
                new FileOperatorException(
                    String.format("文件服务 | 当前指定的激活文件操作器名[%s]参数错误", activeTypeName)));
    // 实例化已支持的文件操作器
    try {
      for (FileOperatorTypeEnum typeEnum : FileOperatorTypeEnum.values()) {
        Map<String, ? extends FileOperatorConfigInter> operatorConfigs =
            applicationContext.getBeansOfType(typeEnum.getConfigCls());
        Optional<? extends FileOperatorConfigInter> optionalConfigInter =
            operatorConfigs.values().stream().findFirst();
        if (!optionalConfigInter.isPresent()) {
          continue;
        }
        FileOperatorConfigInter operatorConfig = optionalConfigInter.get();

        // 若启用的，根据情况更新
        if (firstInit || needInitAgain.contains(typeEnum)) {
          FileOperatorInter operator = typeEnum.getOperatorCls().getConstructor().newInstance();
          Map<String, String> configParam = new HashMap<>();
          BeanMap beanMap = BeanMap.create(operatorConfig);
          for (Object key : beanMap.keySet()) {
            configParam.put(key.toString(), beanMap.get(key).toString());
          }
          operator.init(configParam);
          FileOperatorInter sourceOperator = operatorMap.put(typeEnum, operator);
          if (sourceOperator != null) {
            sourceOperator.destroy();
          }
        }
      }
    } catch (Exception e) {
      log.error("文件服务-初始化 | 非预期异常", e);
      throw new FileOperatorException("文件服务-初始化 | 非预期异常", e);
    }
    firstInit = false;
  }

  /**
   * 获取当前激活的文件操作器
   *
   * @return 文件操作器
   */
  public FileOperatorInter active() {
    return this.getOperatorByTypeName(activeTypeName);
  }

  /**
   * 获取本地文件操作器
   *
   * @return 文件操作器
   */
  public FileOperatorInter local() {
    return this.getOperatorByType(FileOperatorTypeEnum.Local);
  }

  /**
   * 获取指定的文件操作器
   *
   * @param operatorType 文件操作器类型
   * @return 文件操作器
   * @see FileOperatorTypeEnum operatorType参考枚举的 name()
   */
  public FileOperatorInter getOperatorByTypeName(String operatorType) {
    return this.getOperatorByType(FileOperatorTypeEnum.getIgnoreCaseByName(operatorType));
  }

  /**
   * 获取指定的文件操作器
   *
   * @param operatorType 文件操作器类型
   * @return 文件操作器
   */
  public FileOperatorInter getOperatorByType(FileOperatorTypeEnum operatorType) {
    FileOperatorInter operator = operatorMap.get(operatorType);
    if (operator == null) {
      throw new FileOperatorException(String.format("指定类型[%s]文件操作器不存在", operatorType));
    }
    return operator;
  }
  //
  //  /**
  //   * 监听配置变化并实时更新Bean
  //   *
  //   * @param changeEvent 变更事件
  //   */
  //  @ApolloConfigChangeListener(interestedKeyPrefixes = {"file.server"})
  //  private void fileConfigChanged(ConfigChangeEvent changeEvent) {
  //    for (String changedKey : changeEvent.changedKeys()) {
  //      String typeName = changedKey.split("\\.")[2];
  //      String newValue = changeEvent.getChange(changedKey).getNewValue();
  //      //统一配置变化
  //      if ("common".equals(typeName)) {
  //        log.info("文件统一配置变化内容:key[{}],value[{}]", changedKey, newValue);
  //      } else {
  //        //其他类型文件服务配置变化
  //        for (FileOperatorTypeEnum typeEnum : FileOperatorTypeEnum.values()) {
  //          if (typeEnum.name().equalsIgnoreCase(typeName)) {
  //            needInitAgain.add(typeEnum);
  //            log.info("文件服务-配置变化内容:key[{}],value[{}]", changedKey, newValue);
  //          }
  //        }
  //      }
  //    }
  //    this.init();
  //  }
}
