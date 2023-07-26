package net.yiyuan.plugins.mp.utils;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.plugins.ssh.utils.SshUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.*;

/**
 * mp生成器
 *
 * @author XUETAO
 */
@Slf4j
public class CodeGenerator {
  private static String DEFAULT_OUT_PUT_DIR = System.getProperty("user.dir") + "\\src\\main\\java";
  private static String DEFAULT_PARENT_PACK = "com.example.ams.modules";
  private static String DEFAULT_MODULENAME = "";
  private static String AUTHOR = "";
  private static String MYSQL_URL = "jdbc:mysql://43.154.183.115:24457/admin_dev?serverTimezone=Asia/Shanghai";
  private static String MYSQL_USERNAME ="root";
  private static String MYSQL_PASSWORD ="Av*duP#992CBd##wdL&K";

  private static String SSH_URL ="43.154.183.115";
  private static int SSH_PORT =22;
  private static String SSH_USERNAME ="root";
  private static String SSH_PASSWORD ="ABC123#123CBd";
  private static String SSH_COMMAND_FY ="fy ";





  /** 读取控制台内容 */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void main(String[] args) throws Exception {

    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();
    DEFAULT_MODULENAME = scanner("模块名");

    // 全局配置
    //    GlobalConfig gc = new GlobalConfig();
    //    String projectPath = System.getProperty("user.dir");
    //    gc.setOutputDir(projectPath + "/src/main/java");
    //    gc.setAuthor("jobob");
    //    gc.setOpen(false);
    //    // gc.setSwagger2(true); 实体属性 Swagger2 注解
    //    mpg.setGlobalConfig(gc);

    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(DEFAULT_OUT_PUT_DIR);
    gc.setFileOverride(true);

    DEFAULT_PARENT_PACK = scanner("根包名");
    // gc.setAuthor(DEFAULT_PARENT_PACK + "." + DEFAULT_MODULENAME);
    AUTHOR = scanner("作者名称");
    gc.setAuthor(AUTHOR);
    gc.setOpen(false); // 当代码生成完成之后是否打开代码所在的文件夹
    // gc.setSwagger2(true); // 默认false
    gc.setServiceName("%sService");
    gc.setMapperName("%sMapper");
    gc.setControllerName("%sController");
    // 时间类型
    gc.setDateType(DateType.ONLY_DATE);
    gc.setIdType(IdType.ASSIGN_UUID);
    mpg.setGlobalConfig(gc);
    InjectionConfig cfg =
        new InjectionConfig() {
          // 自定义属性注入:abc
          // 在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
          @Override
          public void initMap() {
            Map<String, Object> map = new HashMap<>();
            map.put("apiParent", DEFAULT_PARENT_PACK);
            map.put("apiMoudel", scanner("apiFox接口一级模块名称 * 例如系统管理"));
            //            map.put("apiFolder", scanner("apiFox接口一级/二级级模块名称* 例如 系统管理/菜单管理"));
            this.setMap(map);
          }
        };
    cfg.setFileCreate(
        (configBuilder, fileType, filePath) -> {
          // 如果是Entity则直接返回true表示写文件
          if (fileType == FileType.ENTITY) {
            return true;
          }
          // 否则先判断文件是否存在
          File file = new File(filePath);
          boolean exist = file.exists();
          if (!exist) {
            file.getParentFile().mkdirs();
          }
          // 文件不存在或者全局配置的fileOverride为true才写文件!exist ||
          // configBuilder.getGlobalConfig().isFileOverride()
          return !exist;
        });
    mpg.setCfg(cfg);
    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(MYSQL_URL);
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername(MYSQL_USERNAME);
    dsc.setPassword(MYSQL_PASSWORD);
    mpg.setDataSource(dsc);
    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName(DEFAULT_MODULENAME);
    pc.setParent(DEFAULT_PARENT_PACK); // controller entity  service  service.impl
    pc.setController("controller");
    pc.setEntity("model");
    pc.setMapper("mapper");
    pc.setService("service");
    pc.setServiceImpl("service.impl");
    pc.setXml("mapper.xml");
    mpg.setPackageInfo(pc);
    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();
    // 配置自定义输出模板
    // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    templateConfig.setService("templates/service.vm");
    templateConfig.setServiceImpl("templates/service.impl.vm");
    templateConfig.setController("templates/controller.java.vm");
    templateConfig.setEntity("templates/model.java.vm");
    templateConfig.setMapper("templates/mapper.java.vm");
    //        templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);
    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    // 设置字段和表名的是否把下划线完成驼峰命名规则
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(true); // 是否启动lombok
    strategy.setRestControllerStyle(true); // 是否生成resetController
    String inputTableName[] = scanner("表名，多个英文逗号分割").split(",");
    strategy.setInclude(inputTableName);
    // 不开启Controller层的驼峰转连字符
    strategy.setControllerMappingHyphenStyle(true);
    mpg.setStrategy(strategy);
    mpg.execute();
    getTableFiled(inputTableName, pc);
    // mkdirBaseModel(inputTableName, DEFAULT_OUT_PUT_DIR, DEFAULT_PARENT_PACK, DEFAULT_MODULENAME);
    //		JoinGenerator.jonin(DEFAULT_MODULENAME);
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  public static void getTableFiled(String inputTableName[], PackageConfig pc) throws Exception {
    Map<String, String> mysqlToJavaTypeMap = new HashMap<>();
    mysqlToJavaTypeMap.put("tinyint", "Byte");
    mysqlToJavaTypeMap.put("smallint", "Short");
    mysqlToJavaTypeMap.put("mediumint", "Integer");
    mysqlToJavaTypeMap.put("int", "Integer");
    mysqlToJavaTypeMap.put("integer", "Integer");
    mysqlToJavaTypeMap.put("bigint", "Long");
    mysqlToJavaTypeMap.put("float", "Float");
    mysqlToJavaTypeMap.put("double", "Double");
    mysqlToJavaTypeMap.put("decimal", "BigDecimal");
    mysqlToJavaTypeMap.put("date", "Date");
    mysqlToJavaTypeMap.put("datetime", "Date");
    mysqlToJavaTypeMap.put("timestamp", "Timestamp");
    mysqlToJavaTypeMap.put("time", "Time");
    mysqlToJavaTypeMap.put("year", "Date");
    mysqlToJavaTypeMap.put("char", "String");
    mysqlToJavaTypeMap.put("varchar", "String");
    mysqlToJavaTypeMap.put("tinytext", "String");
    mysqlToJavaTypeMap.put("text", "String");
    mysqlToJavaTypeMap.put("mediumtext", "String");
    mysqlToJavaTypeMap.put("longtext", "String");
    mysqlToJavaTypeMap.put("binary", "byte[]");
    mysqlToJavaTypeMap.put("varbinary", "byte[]");
    mysqlToJavaTypeMap.put("tinyblob", "byte[]");
    mysqlToJavaTypeMap.put("blob", "byte[]");
    mysqlToJavaTypeMap.put("mediumblob", "byte[]");
    mysqlToJavaTypeMap.put("longblob", "byte[]");


    //    String tableName = "user";
    Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    // 获取 DatabaseMetaData 对象
    DatabaseMetaData metaData = conn.getMetaData();

    for (String tableName : inputTableName) {
      // 定义生成基本增删改查的DTO
      VelocityContext dtoContext = new VelocityContext();
      // 定义dto字段的信息
      List<Map<String, String>> dtoTableColumns = new ArrayList<>();

      ResultSet tables = metaData.getTables(null, null, tableName, new String[] {"TABLE"});
      String tableComment = "";
      while (tables.next()) {
        //        String tableName = tables.getString("TABLE_NAME");
        if (tables.getString("TABLE_NAME").equals(tableName)) {
          tableComment = tables.getString("REMARKS");
          System.out.println("表名注释：" + tableComment);
        }

        // 获取表注释信息的 SQL
        String commentSql =
            String.format(
                "SELECT TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s'",
                "admin_dev", tableName);
        // 执行 SQL 并获取结果集
        ResultSet comments = metaData.getConnection().createStatement().executeQuery(commentSql);
        // 输出表名及注释信息
        if (comments.next()) {
          tableComment = comments.getString(1);
          System.out.println("表名注释：" + tableComment);
        }

        dtoContext.put("className", StringUtilsPlus.convertToCamelCase(tableName));
        dtoContext.put("tableComment", tableComment);
        // 处理表名及其注释信息
      }
      // 获取表主键
      ResultSet rsPrimary = metaData.getPrimaryKeys(null, null, tableName);
      String columnNamePrimary = "";
      while (rsPrimary.next()) {
        columnNamePrimary = rsPrimary.getString("COLUMN_NAME");
        System.out.println("Primary key column name: " + columnNamePrimary);
      }

      ResultSet rs = metaData.getColumns(null, null, tableName, null);
      // 批量翻译
      //      while (rs.next()) {
      //        String columnName = rs.getString("COLUMN_NAME");
      //        String columnType = rs.getString("TYPE_NAME");
      //        String columnComment = rs.getString("REMARKS");
      //        boolean isNullable = rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
      //        String defaultValue = rs.getString("COLUMN_DEF");
      //        // 生成枚举类
      //        if (StrUtil.contains(columnComment, "#") && !StrUtil.contains(columnComment, "##"))
      // {}
      //      }

      // rs = metaData.getColumns(null, null, tableName, null);
      while (rs.next()) {

        List<Map<String, String>> tableColumns = new ArrayList<>();
        String columnName = rs.getString("COLUMN_NAME");
        String columnType = rs.getString("TYPE_NAME");
        String columnComment = rs.getString("REMARKS");
        boolean isNullable = rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
        String defaultValue = rs.getString("COLUMN_DEF");

        System.out.println("字段名：" + columnName);
        System.out.println("字段注释：" + columnComment);
        System.out.println("字段类型：" + columnType);
        System.out.println("字段类型columnName：" + StrUtil.toCamelCase(columnName).toUpperCase());
        // 将所有字段全部封装到
        Map<String, String> dtoColumnMap = new HashMap<>();
        dtoColumnMap.put(
            "columnName",
            StringUtilsPlus.uncapitalize(StringUtilsPlus.convertToCamelCase(columnName)));
        dtoColumnMap.put("columnType", columnType);
        dtoColumnMap.put("columnComment", columnComment);
        if (StringUtilsPlus.isEmpty(defaultValue)) {
          dtoColumnMap.put("defaultValue", "NULL");
        } else {
          dtoColumnMap.put("defaultValue", defaultValue);
        }

        log.info("字段{}默认值{}", columnName, defaultValue);
        if (isNullable) {
          // 列允许为空
          dtoColumnMap.put("isNullable", "0");
        } else {
          // 列不允许为空
          dtoColumnMap.put("isNullable", "1");
        }
        // 设置主键
        if (columnName.equals(columnNamePrimary)) {
          dtoColumnMap.put("keyFlag", "true");
        } else {
          dtoColumnMap.put("keyFlag", "false");
        }
        // 生成枚举类
        if (StrUtil.contains(columnComment, "#") && !StrUtil.contains(columnComment, "##")) {
          String[] columnCommentArray = columnComment.split("#");
          log.info("columnCommentArray{}", columnCommentArray);
          log.info("columnCommentArray{}", columnCommentArray[1]);
          String[] itemArray = columnCommentArray[1].split("\\|");
          log.info("itemArray{},{}", itemArray[0], itemArray[1]);
          for (String item : itemArray) {
            // 以字段为单位创建生成一个枚举类
            String[] kvArray = item.split("=");
            System.out.println("kvArray：" + kvArray[0]);
            System.out.println("kvArray" + kvArray[1]);
            Map<String, String> columnMap = new HashMap<>();
            columnMap.put("code", kvArray[0]);
            columnMap.put("desc", kvArray[1]);
            // String filed=TransUtils.toEn2(kvArray[1]).toUpperCase().replaceAll("\\s+", "_");
            String filed =
                StringUtilsPlus.trimAndFormatString(
                        SshUtil.executeScript(
                            SSH_URL, SSH_PORT, SSH_USERNAME, SSH_PASSWORD, SSH_COMMAND_FY + kvArray[1]))
                    .toUpperCase();

            columnMap.put("filed", filed);
            // columnMap.put("columnFiled", (columnName + "_" + filed).toUpperCase());
            columnMap.put("columnComment", columnComment);
            log.info("itemArray.filed{}", filed);
            tableColumns.add(columnMap);
          }
          VelocityContext context = new VelocityContext();
          context.put("author", AUTHOR);
          context.put("date", StringUtilsPlus.formatDateTime(LocalDateTime.now(), "yyyy-MM-dd"));
          context.put("tableComment", tableComment);
          context.put("columnComment", columnComment.split("#")[0]);
          context.put("path", DEFAULT_OUT_PUT_DIR);
          context.put("packagePath", StringUtilsPlus.convertPackageNameToPath(pc.getParent()));
          context.put("packageName", pc);
          context.put(
              "className",
              StringUtilsPlus.convertToCamelCase(tableName)
                  + StringUtilsPlus.convertToCamelCase(columnName)
                  + "Enum");

          context.put("tableColumns", tableColumns);
          context.put("parentPck", pc.getParent());
          context.put("moduleName", DEFAULT_MODULENAME);
          // 生成枚举文件
          createByVelocity(context);

          dtoColumnMap.put("propertyType", (String) context.get("className"));
        } else {
          dtoColumnMap.put(
              "propertyType", mysqlToJavaTypeMap.get(StringUtilsPlus.toLowerCase(columnType)));
        }
        dtoTableColumns.add(dtoColumnMap);
      }
      dtoContext.put("author", AUTHOR);
      dtoContext.put("date", StringUtilsPlus.formatDateTime(LocalDateTime.now(), "yyyy-MM-dd"));
      dtoContext.put("dtoTableColumns", dtoTableColumns);
      dtoContext.put("parentPack", DEFAULT_PARENT_PACK);
      dtoContext.put("moduleName", DEFAULT_MODULENAME);
      dtoContext.put("packagePath", StringUtilsPlus.convertPackageNameToPath(pc.getParent()));
      dtoContext.put("path", DEFAULT_OUT_PUT_DIR);
      dtoContext.put("parentPck", pc.getParent());
      log.info("模板参数{}", dtoContext);
      createAddDtoByVelocity(dtoContext);
      createListDtoByVelocity(dtoContext);
      createPageDtoByVelocity(dtoContext);
      createEditDtoByVelocity(dtoContext);
      createQueryVOByVelocity(dtoContext);
    }
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  public static void createByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcVoPath = context.get("path") + "/" + context.get("packagePath") + "/vo/";
    String srcDtoPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    File voFolder = new File(srcVoPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }
    File dtoFolder = new File(srcDtoPath);
    if (!dtoFolder.exists()) {
      // 如果文件夹不存在则创建它
      dtoFolder.mkdirs();
    }

    Template template = velocityEngine.getTemplate("templates\\enum.java.vm", "UTF-8");
    String srcEnumsPath = context.get("path") + "/" + context.get("packagePath") + "/enums/";
    log.info("srcEnumsPath{}", srcEnumsPath);
    File folder = new File(srcEnumsPath);
    if (!folder.exists()) {
      // 如果文件夹不存在则创建它
      folder.mkdirs();
    }
    String filePath = srcEnumsPath + context.get("className") + ".java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  public static void createAddDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcVoPath = context.get("path") + "/" + context.get("packagePath") + "/vo/";
    String srcDtoPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    File voFolder = new File(srcVoPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }
    File dtoFolder = new File(srcDtoPath);
    if (!dtoFolder.exists()) {
      // 如果文件夹不存在则创建它
      dtoFolder.mkdirs();
    }

    Template template = velocityEngine.getTemplate("templates\\modelAddDTO.java.vm", "UTF-8");
    String srcEnumsPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    log.info("srcEnumsPath{}", srcEnumsPath);
    File folder = new File(srcEnumsPath);
    if (!folder.exists()) {
      // 如果文件夹不存在则创建它
      folder.mkdirs();
    }
    String filePath = srcEnumsPath + context.get("className") + "AddDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }
  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  public static void createListDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcVoPath = context.get("path") + "/" + context.get("packagePath") + "/vo/";
    String srcDtoPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    File voFolder = new File(srcVoPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }
    File dtoFolder = new File(srcDtoPath);
    if (!dtoFolder.exists()) {
      // 如果文件夹不存在则创建它
      dtoFolder.mkdirs();
    }

    Template template = velocityEngine.getTemplate("templates\\modelListDTO.java.vm", "UTF-8");
    String srcEnumsPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    log.info("srcEnumsPath{}", srcEnumsPath);
    File folder = new File(srcEnumsPath);
    if (!folder.exists()) {
      // 如果文件夹不存在则创建它
      folder.mkdirs();
    }
    String filePath = srcEnumsPath + context.get("className") + "ListDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  public static void createPageDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcVoPath = context.get("path") + "/" + context.get("packagePath") + "/vo/";
    String srcDtoPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    File voFolder = new File(srcVoPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }
    File dtoFolder = new File(srcDtoPath);
    if (!dtoFolder.exists()) {
      // 如果文件夹不存在则创建它
      dtoFolder.mkdirs();
    }

    Template template = velocityEngine.getTemplate("templates\\modelPageDTO.java.vm", "UTF-8");
    String srcEnumsPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    log.info("srcEnumsPath{}", srcEnumsPath);
    File folder = new File(srcEnumsPath);
    if (!folder.exists()) {
      // 如果文件夹不存在则创建它
      folder.mkdirs();
    }
    String filePath = srcEnumsPath + context.get("className") + "PageDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  public static void createEditDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcVoPath = context.get("path") + "/" + context.get("packagePath") + "/vo/";
    String srcDtoPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    File voFolder = new File(srcVoPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }
    File dtoFolder = new File(srcDtoPath);
    if (!dtoFolder.exists()) {
      // 如果文件夹不存在则创建它
      dtoFolder.mkdirs();
    }

    Template template = velocityEngine.getTemplate("templates\\modelEditDTO.java.vm", "UTF-8");
    String srcEnumsPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    log.info("srcEnumsPath{}", srcEnumsPath);
    File folder = new File(srcEnumsPath);
    if (!folder.exists()) {
      // 如果文件夹不存在则创建它
      folder.mkdirs();
    }
    String filePath = srcEnumsPath + context.get("className") + "EditDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author 一源团队--花和尚
   * @date 2023-07-11
   */
  public static void createQueryVOByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcVoPath = context.get("path") + "/" + context.get("packagePath") + "/vo/";
    String srcDtoPath = context.get("path") + "/" + context.get("packagePath") + "/dto/";
    File voFolder = new File(srcVoPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }
    File dtoFolder = new File(srcDtoPath);
    if (!dtoFolder.exists()) {
      // 如果文件夹不存在则创建它
      dtoFolder.mkdirs();
    }

    Template template = velocityEngine.getTemplate("templates\\modelQueryVO.java.vm", "UTF-8");
    String srcEnumsPath = context.get("path") + "/" + context.get("packagePath") + "/vo/";
    log.info("srcEnumsPath{}", srcEnumsPath);
    File folder = new File(srcEnumsPath);
    if (!folder.exists()) {
      // 如果文件夹不存在则创建它
      folder.mkdirs();
    }
    String filePath = srcEnumsPath + context.get("className") + "QueryVO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }
}
