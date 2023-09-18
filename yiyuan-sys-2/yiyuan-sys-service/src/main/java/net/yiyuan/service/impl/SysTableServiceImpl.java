package net.yiyuan.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.config.LocalConfigProperties;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.common.utils.ZipFileUtils;
import net.yiyuan.dto.*;
import net.yiyuan.mapper.SysTableMapper;
import net.yiyuan.model.SysTable;
import net.yiyuan.plugins.mp.utils.CodeGenerator;
import net.yiyuan.service.SysTableService;
import net.yiyuan.vo.SysTableQueryVO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Arrays;
import java.util.List;
/**
 * 数据库Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-25
 */
@Slf4j
@Service
public class SysTableServiceImpl extends JoinServiceImpl<SysTableMapper, SysTable>
    implements SysTableService {
  @Resource private SysTableMapper sysTableMapper;
  @Resource private JdbcTemplate jdbcTemplate;
  @Resource private LocalConfigProperties localConfigProperties;

  /**
   * 数据库列表(全部)
   *
   * @param request 数据库实体
   * @return {@link List< SysTableQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public List<SysTableQueryVO> list(SysTableListDTO request) throws Exception {

    SysTable po = new SysTable();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTable> wrapper = new JoinLambdaWrapper<>(po);
    List<SysTableQueryVO> voList = joinList(wrapper, SysTableQueryVO.class);

    return voList;
  }

  /**
   * 数据库列表(分页)
   *
   * @param request 数据库实体
   * @return {@link Page< SysTableQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public Page<SysTableQueryVO> page(SysTablePageDTO request) throws Exception {
    SysTable po = new SysTable();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTable> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysTableQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysTableQueryVO.class);
    return voPage;
  }

  /**
   * 数据库详情
   *
   * @param id 数据库id
   * @return {@link SysTableQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public SysTableQueryVO details(String id) throws Exception {
    SysTable po = new SysTable();
    po.setId(id);
    JoinLambdaWrapper<SysTable> wrapper = new JoinLambdaWrapper<>(po);
    SysTableQueryVO voBean = joinGetOne(wrapper, SysTableQueryVO.class);
    return voBean;
  }

  /**
   * 数据库详情
   *
   * @param request 数据库实体
   * @return {@link SysTable}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public SysTableQueryVO details(SysTable request) throws Exception {

    JoinLambdaWrapper<SysTable> wrapper = new JoinLambdaWrapper<>(request);
    SysTableQueryVO voBean = joinGetOne(wrapper, SysTableQueryVO.class);
    return voBean;
  }

  /**
   * 删除数据库(支持批量)
   *
   * @param ids 数据库id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑数据库
   *
   * @param request 数据库实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public boolean edit(SysTableEditDTO request) throws Exception {
    SysTable po = new SysTable();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTable> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增数据库
   *
   * @param request 数据库实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public boolean add(SysTableAddDTO request) throws Exception {
    SysTable po = new SysTable();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  /**
   * 刷新数据库
   *
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public boolean refresh() throws Exception {
    // 假设已经正确配置并初始化了 JdbcTemplate 对象 jdbcTemplate

    String sql =
        "SELECT table_name, table_comment FROM information_schema.tables WHERE table_schema = ?";
    // 替换为实际的数据库名称
    String databaseName = "admin_dev";

    jdbcTemplate.query(
        sql,
        (rs) -> {
          String tableName = rs.getString("table_name");
          String tableComment = rs.getString("table_comment");
          SysTable po = new SysTable();
          JoinLambdaWrapper<SysTable> wrapper = new JoinLambdaWrapper<>(po);
          wrapper.eq(SysTable::getName, tableName);
          SysTable sysTableQuery = joinGetOne(wrapper, SysTable.class);
          if (StringUtilsPlus.isNull(sysTableQuery)) {
            po.setName(tableName);
            po.setRemark(tableComment);
            save(po);
          }
        },
        databaseName);
    return true;
  }

  /**
   * 生成代码
   *
   * @param request 生成代码实体
   * @author 一源团队-花和尚
   * @date 2023-08-25
   */
  @Override
  public void generateCode(HttpServletResponse servletResponse, SysTableGenerateCodeDTO request)
      throws Exception {
    List<SysTable> sysTableList = listByIds(Arrays.asList(request.getIds().split(",")));
    CodeGenerator.DEFAULT_PARENT_PACK = request.getParentPackageName();
    CodeGenerator.MOUDLE_NAME_ZH = request.getFirstLevelMenuZh();
    CodeGenerator.AUTHOR = request.getAuthor();
    CodeGenerator.DEFAULT_OUT_PUT_DIR = localConfigProperties.getRootPath();
    String[] tableNameList = sysTableList.stream().map(SysTable::getName).toArray(String[]::new);
    PackageConfig pc = new PackageConfig();
    CodeGenerator.getTableFiled(tableNameList, pc);
    File zip = ZipUtil.zip(CodeGenerator.DEFAULT_OUT_PUT_DIR + "/src");
    ZipFileUtils.downloadZipFiles(servletResponse, zip);
    FileUtil.del(zip);
    FileUtil.del(CodeGenerator.DEFAULT_OUT_PUT_DIR + "/src");
  }
}
