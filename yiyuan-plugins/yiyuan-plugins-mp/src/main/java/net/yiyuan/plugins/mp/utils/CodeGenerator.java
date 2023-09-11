package net.yiyuan.plugins.mp.utils;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
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
  public static String DEFAULT_OUT_PUT_DIR = System.getProperty("user.dir");
  public static String DEFAULT_SRC = "\\src\\main\\java";
  public static String DEFAULT_JS_SRC = "\\src";
  public static String MOUDLE_NAME_ZH = "";

  public static String DEFAULT_PARENT_PACK = "";
  //  public static String DEFAULT_MODULENAME = "";
  public static String AUTHOR = "";
  public static String MYSQL_URL =
      "jdbc:mysql://106.54.87.159:23306/admin_dev?serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true";
  public static String MYSQL_USERNAME = "root";
  public static String MYSQL_PASSWORD = "123456";

  public static String SSH_URL = "43.154.183.115";
  public static int SSH_PORT = 60035;
  public static String SSH_USERNAME = "root";
  public static String SSH_PASSWORD = "ABC123#123CBd";
  public static String SSH_COMMAND_FY = "fy ";

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
    DEFAULT_PARENT_PACK = scanner("根包名,例如:net.yiyuan");
    MOUDLE_NAME_ZH = scanner("一级菜单名称,例如：系统管理");
    AUTHOR = scanner("作者名称");
    String inputTableName[] = scanner("表名，多个英文逗号分割").split(",");
    PackageConfig pc = new PackageConfig();
    getTableFiled(inputTableName, pc);
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
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
    mysqlToJavaTypeMap.put("geometry", "String");

    //    String tableName = "user";
    Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    // 获取 DatabaseMetaData 对象
    DatabaseMetaData metaData = conn.getMetaData();
    DatabaseMetaData metaData2 = conn.getMetaData();

    // 定义dto字段的信息
    VelocityContext routerAndI18nContext = new VelocityContext();
    List<Map<String, Object>> routerAndI18nMapList = new ArrayList<>();

    for (String tableName : inputTableName) {
      Map<String, Object> routerAndI18nMap = new HashMap<>();
      // 定义生成基本增删改查的DTO
      VelocityContext dtoContext = new VelocityContext();
      // 定义dto字段的信息
      List<Map<String, Object>> dtoTableColumns = new ArrayList<>();

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

      //      log.info("rs.size{}", rs.getRow());
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
        Map<String, Object> dtoColumnMap = new HashMap<>();
        dtoColumnMap.put(
            "columnName",
            StringUtilsPlus.uncapitalize(StringUtilsPlus.convertToCamelCase(columnName)));
        dtoColumnMap.put("column", columnName);
        dtoColumnMap.put("columnType", columnType);
        dtoColumnMap.put("columnComment", columnComment);
        if (columnComment.contains("#")) {
          String[] eumsCodeArr = columnComment.split("#")[1].split("\\|");
          List<Map<String, Object>> eumsCodeList = new ArrayList<>();
          for (String eumsCode : eumsCodeArr) {
            Map<String, Object> eumsCodeMap = new HashMap<>();

            eumsCodeMap.put("value", eumsCode.split("=")[0]);
            eumsCodeMap.put("label", eumsCode.split("=")[1]);
            eumsCodeList.add(eumsCodeMap);
          }

          // 方便vm转成数组
          dtoColumnMap.put("eumsCodeList", eumsCodeList);
        }
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
                            SSH_URL,
                            SSH_PORT,
                            SSH_USERNAME,
                            SSH_PASSWORD,
                            SSH_COMMAND_FY + kvArray[1]))
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
          //          context.put("moduleName", DEFAULT_MODULENAME);

          context.put("pm0", tableName.split("_")[0]);
          context.put("pm0_2", StringUtilsPlus.convertToCamelCase((String) dtoContext.get("pm0")));
          context.put(
              "pm1",
              StringUtilsPlus.convertToCamelCaseAndUncapitalize(
                  tableName.substring(tableName.indexOf("_") + 1)));
          context.put(
              "pm1_2",
              StringUtilsPlus.convertToCamelCase(tableName.substring(tableName.indexOf("_") + 1)));
          // 生成枚举文件
          createEnumsByVelocity(context);

          dtoColumnMap.put("propertyType", (String) context.get("className"));
        } else {
          dtoColumnMap.put(
              "propertyType", mysqlToJavaTypeMap.get(StringUtilsPlus.toLowerCase(columnType)));
        }
        dtoTableColumns.add(dtoColumnMap);
      }

      dtoContext.put("revision", "${revision}");
      dtoContext.put("author", AUTHOR);
      dtoContext.put("date", StringUtilsPlus.formatDateTime(LocalDateTime.now(), "yyyy-MM-dd"));
      dtoContext.put("dtoTableColumns", dtoTableColumns);
      dtoContext.put("parentPack", DEFAULT_PARENT_PACK);
      //      dtoContext.put("moduleName", DEFAULT_MODULENAME);
      dtoContext.put("packagePath", StringUtilsPlus.convertPackageNameToPath(pc.getParent()));
      dtoContext.put("path", DEFAULT_OUT_PUT_DIR);
      dtoContext.put("parentPck", pc.getParent());
      dtoContext.put("moudleNameZh", MOUDLE_NAME_ZH);
      dtoContext.put("pm0", tableName.split("_")[0]);
      dtoContext.put("pm0_2", StringUtilsPlus.convertToCamelCase((String) dtoContext.get("pm0")));
      dtoContext.put(
          "pm1",
          StringUtilsPlus.convertToCamelCaseAndUncapitalize(
              tableName.substring(tableName.indexOf("_") + 1)));
      dtoContext.put(
          "pm1_2",
          StringUtilsPlus.convertToCamelCase(tableName.substring(tableName.indexOf("_") + 1)));
      log.info("模板参数{}", dtoContext);

      routerAndI18nMap.put("pm0", dtoContext.get("pm0"));
      routerAndI18nMap.put("pm1", dtoContext.get("pm1"));
      routerAndI18nMap.put("pm1_2", dtoContext.get("pm1_2"));
      routerAndI18nMap.put("tableComment", dtoContext.get("tableComment"));
      routerAndI18nMapList.add(routerAndI18nMap);

      createJsRouterIndexJsByVelocity(dtoContext);
      createJsRouterJsByVelocity(dtoContext);
      createJsConfigByVelocity(dtoContext);
      createJsApiByVelocity(dtoContext);
      createJsVueByVelocity(dtoContext);

      createModelByVelocity(dtoContext);
      createAddDtoByVelocity(dtoContext);
      createListDtoByVelocity(dtoContext);
      createPageDtoByVelocity(dtoContext);
      createEditDtoByVelocity(dtoContext);
      createQueryVOByVelocity(dtoContext);
      createServiceByVelocity(dtoContext);
      createServiceImplByVelocity(dtoContext);
      createMapperByVelocity(dtoContext);
      createMapperXmlByVelocity(dtoContext);
      createControllerByVelocity(dtoContext);

      createApiPomByVelocity(dtoContext);
      createServicePomByVelocity(dtoContext);
      createParentPomByVelocity(dtoContext);
    }
    routerAndI18nContext.put("routerAndI18nMapList", routerAndI18nMapList);
    routerAndI18nContext.put("routerAndI18nRoot", routerAndI18nMapList.get(0).get("pm0"));
    routerAndI18nContext.put("moudleNameZh", MOUDLE_NAME_ZH);
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createJsRouterJsByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/yiyuan-vue"
            + DEFAULT_JS_SRC
            + "/router/modules/"
            + context.get("pm0")
            + "/modules/";

    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    //    String filePath = srcModelPath + context.get("routerAndI18nRoot") + ".js";

    String filePath = srcModelPath + context.get("pm1") + ".js";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\router.js.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createJsRouterIndexJsByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);

    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/yiyuan-vue"
            + DEFAULT_JS_SRC
            + "/router/modules/"
            + context.get("pm0")
            + "/";

    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    //    String filePath = srcModelPath + context.get("routerAndI18nRoot") + ".js";

    String filePath = srcModelPath + "index.js";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\routerIndex.js.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createJsApiByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/yiyuan-vue"
            + DEFAULT_JS_SRC
            + "/api/"
            + context.get("pm0")
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("pm1") + ".js";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\api.js.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }
  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createJsConfigByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    // String srcModelPath = DEFAULT_OUT_PUT_DIR + "/src/js" + "/";

    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/yiyuan-vue"
            + DEFAULT_JS_SRC
            + "/pages/"
            + context.get("pm0")
            + "/"
            + context.get("pm1")
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";

    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + "pageConfig.js";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\config.js.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createJsVueByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    // String srcModelPath = DEFAULT_OUT_PUT_DIR + "/src/js" + "/";

    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/yiyuan-vue"
            + DEFAULT_JS_SRC
            + "/pages/"
            + context.get("pm0")
            + "/"
            + context.get("pm1")
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";

    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + "index.vue";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\index.vue.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createControllerByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-api"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/controller"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "Controller.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\controller.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createMapperByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/mapper"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "Mapper.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\mapper.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createMapperXmlByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/mapper"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/xml/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "Mapper.xml";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\mapper.xml.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createServiceByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/service"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "Service.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\service.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createServiceImplByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/service"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/impl/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "ServiceImpl.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\service.impl.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createEnumsByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/enums"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + ".java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\enum.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createModelByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/model"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + ".java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\model.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }
  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createAddDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/dto"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "AddDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\modelAddDTO.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createListDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/dto"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "ListDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\modelListDTO.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createPageDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/dto"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "PageDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\modelPageDTO.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createEditDtoByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/dto"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "EditDTO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\modelEditDTO.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createQueryVOByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + DEFAULT_SRC
            + "/"
            + StringUtilsPlus.convertPackageNameToPath(DEFAULT_PARENT_PACK)
            + "/vo"
            //            + "/"
            //            + DEFAULT_MODULENAME
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + context.get("className") + "QueryVO.java";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\modelQueryVO.java.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createApiPomByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-api"
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + "pom.xml";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\api.pom.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createServicePomByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath =
        DEFAULT_OUT_PUT_DIR
            + "/src/"
            + "yiyuan-"
            + context.get("pm0")
            + "/"
            + "yiyuan-"
            + context.get("pm0")
            + "-service"
            + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + "pom.xml";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\service.pom.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }

  /**
   * 根据用户输入的表获取每张表所有字段信息
   *
   * @param
   * @author ${author}
   * @date 2023-07-11
   */
  public static void createParentPomByVelocity(VelocityContext context) throws Exception {
    VelocityEngine velocityEngine = new VelocityEngine();
    Properties prop = new Properties();
    prop.put(
        "file.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.init(prop);
    log.info(
        "dtoTableColumns:{}", ((List<Map<String, String>>) context.get("dtoTableColumns")).size());
    String srcModelPath = DEFAULT_OUT_PUT_DIR + "/src/" + "yiyuan-" + context.get("pm0") + "/";
    File voFolder = new File(srcModelPath);
    if (!voFolder.exists()) {
      // 如果文件夹不存在则创建它
      voFolder.mkdirs();
    }

    String filePath = srcModelPath + "pom.xml";
    File file = new File(filePath);
    if (!file.exists()) {
      // 如果文件不存在则创建它
      file.createNewFile();
    }

    Template template = velocityEngine.getTemplate("templates2\\parent.pom.vm", "UTF-8");
    FileWriter writer = new FileWriter(filePath);
    template.merge(context, writer);
    writer.flush();
    writer.close();
  }
}
