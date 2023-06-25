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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * mp生成器
 *
 * @author XUETAO
 */
public class CodeGenerator {
  private static String DEFAULT_OUT_PUT_DIR = System.getProperty("user.dir") + "\\src\\main\\java";
  private static String DEFAULT_PARENT_PACK = "com.example.ams.modules";
  private static String DEFAULT_MODULENAME = "";

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
    gc.setAuthor(scanner("作者名称"));
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
    dsc.setUrl("jdbc:mysql://43.154.183.115:40020/admin_dev?serverTimezone=Asia/Shanghai");
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("123456");
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
    // mkdirBaseModel(inputTableName, DEFAULT_OUT_PUT_DIR, DEFAULT_PARENT_PACK, DEFAULT_MODULENAME);
    //		JoinGenerator.jonin(DEFAULT_MODULENAME);
  }

  public static void mkdirBaseModel(
      String inputTableName[],
      String defaultOutPutDir,
      String defaultParentPack,
      String moduleName) {
    try {
      for (String tableNameItem : inputTableName) {
        String defaultParentPackPath = defaultParentPack.replace(".", "\\");
        System.out.println("defaultParentPackPath  " + defaultParentPackPath);
        String baseModeVolFilePath =
            defaultOutPutDir + "\\" + defaultParentPackPath + "\\" + moduleName + "\\" + "model\\";
        File baseModeVolFilePathDir = new File(baseModeVolFilePath);
        if (!baseModeVolFilePathDir.exists()) {
          baseModeVolFilePathDir.mkdirs();
        }
        System.out.println("baseModelFilePath  " + baseModeVolFilePath);
        String className = StrUtil.toCamelCase(tableNameItem) + "Dto";
        File baseFile = new File(baseModeVolFilePath, className + ".java");
        if (!baseFile.exists()) {
          try {
            //						baseFile.createNewFile();
            //						String baseModeVolFileWriterPath = defaultOutPutDir + "\\" +
            // defaultParentPackPath + "\\" + moduleName + "\\" + "dto\\";
            //						File baseModeVolFileWriterPathDir = new File(baseModeVolFileWriterPath);
            // //以某路径实例化一个File对象
            //						if (!baseModeVolFileWriterPathDir.exists()){ //如果不存在
            //							boolean dr = baseModeVolFileWriterPathDir.mkdirs(); //创建目录
            //						}
            //						File baseModeVolFileWriterPathDirFile = new File(baseModeVolFileWriterPath,
            // className + ".java");
            FileWriter enumFileWriter = new FileWriter(baseFile);

            //						FileWriter enumFileWriter = new FileWriter(baseModeVolFileWriterPathDirFile);
            enumFileWriter.write(
                "package " + defaultParentPack + "." + moduleName + ".model" + ";\n");
            //						enumFileWriter.write("import com.fhs.core.trans.vo.TransPojo;\n");
            enumFileWriter.write(
                "import io.swagger.annotations.ApiModel;\n"
                    + "import io.swagger.annotations.ApiModelProperty;\n"
                    + "import com.fasterxml.jackson.annotation.JsonFormat;\n"
                    + "import java.io.Serializable;\n"
                    + "import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;\n"
                    + "import lombok.*;\n");
            enumFileWriter.write("@Data\n");
            enumFileWriter.write("\n");
            enumFileWriter.write(
                "public class   "
                    + className
                    + " extends "
                    + StrUtil.toCamelCase(tableNameItem)
                    + "  implements Serializable {\n");
            enumFileWriter.write("}");
            enumFileWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        String baseAdminControllerFilePath =
            defaultOutPutDir
                + "\\"
                + defaultParentPackPath
                + "\\"
                + moduleName
                + "\\"
                + "controller\\";
        String baseAdminControllerFileName =
            StrUtil.toCamelCase(tableNameItem) + "AdminBaseController";
        File baseAdminControllerFile =
            new File(baseAdminControllerFilePath, baseAdminControllerFileName + ".java");
        if (!baseAdminControllerFile.exists()) {
          try {
            baseAdminControllerFile.createNewFile();
            FileWriter baseAdminControllerWriter = new FileWriter(baseAdminControllerFile);
            baseAdminControllerWriter.write(
                "package "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".controller;\n"
                    + "import io.swagger.annotations.Api;\n"
                    + "import org.springframework.web.bind.annotation.*;"
                    + "import lombok.extern.slf4j.Slf4j;\n"
                    + "import org.slf4j.Logger;\n"
                    + "import org.slf4j.LoggerFactory;\n"
                    + "import org.springframework.web.bind.annotation.RestController;\n"
                    + "\n"
                    + "import java.util.Date;\n"
                    + "import java.util.List;\n"
                    + "\n"
                    + "/**\n"
                    + " * "
                    + moduleName
                    + "模块复杂业务接口(pc端)\n"
                    + " */\n"
                    + "@Slf4j\n"
                    + "@RestController\n"
                    + "@Api(tags = \""
                    + ""
                    + moduleName
                    + "模块复杂业务接口(pc端)"
                    + "\")  //配合swagger使用\n"
                    + "@RequestMapping(value = \"/admin\")"
                    + "public class "
                    + baseAdminControllerFileName
                    + " {\n"
                    + "    private static final Logger LOGGER = LoggerFactory.getLogger("
                    + baseAdminControllerFileName
                    + ".class);\n"
                    + "\n"
                    + "}\n");
            baseAdminControllerWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        String baseMobileControllerFilePath =
            defaultOutPutDir
                + "\\"
                + defaultParentPackPath
                + "\\"
                + moduleName
                + "\\"
                + "controller\\";
        String baseMobileControllerFileName =
            StrUtil.toCamelCase(tableNameItem) + "MobileBaseController";
        File baseMobileControllerFile =
            new File(baseMobileControllerFilePath, baseMobileControllerFileName + ".java");
        if (!baseMobileControllerFile.exists()) {
          try {
            baseMobileControllerFile.createNewFile();
            FileWriter baseMobileControllerWriter = new FileWriter(baseMobileControllerFile);
            baseMobileControllerWriter.write(
                "package "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".controller;\n"
                    + "import io.swagger.annotations.Api;\n"
                    + "import org.springframework.web.bind.annotation.*;"
                    + "import lombok.extern.slf4j.Slf4j;\n"
                    + "import org.slf4j.Logger;\n"
                    + "import org.slf4j.LoggerFactory;\n"
                    + "import org.springframework.web.bind.annotation.RestController;\n"
                    + "\n"
                    + "import java.util.Date;\n"
                    + "import java.util.List;\n"
                    + "\n"
                    + "/**\n"
                    + " * "
                    + moduleName
                    + "模块复杂业务接口(移动端)\n"
                    + " */\n"
                    + "@Slf4j\n"
                    + "@RestController\n"
                    + "@Api(tags = \""
                    + ""
                    + moduleName
                    + "模块复杂业务接口(移动端)"
                    + "\")  //配合swagger使用\n"
                    + "@RequestMapping(value = \"/mobile\")"
                    + "public class "
                    + baseMobileControllerFileName
                    + " {\n"
                    + "    private static final Logger LOGGER = LoggerFactory.getLogger("
                    + baseMobileControllerFileName
                    + ".class);\n"
                    + "\n"
                    + "}\n");
            baseMobileControllerWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        String baseAdminServiceFilePath =
            defaultOutPutDir
                + "\\"
                + defaultParentPackPath
                + "\\"
                + moduleName
                + "\\"
                + "service\\";
        String baseAdminServiceFileName = StrUtil.toCamelCase(tableNameItem) + "AdminBaseService";
        File baseAdminServiceFile =
            new File(baseAdminServiceFilePath, baseAdminServiceFileName + ".java");
        if (!baseAdminServiceFile.exists()) {
          try {
            baseAdminServiceFile.createNewFile();
            FileWriter baseAdminServiceWriter = new FileWriter(baseAdminServiceFile);
            baseAdminServiceWriter.write(
                "package "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".service;\n"
                    + "\n"
                    + "\n"
                    + "/**\n"
                    + " * @description "
                    + moduleName
                    + "模块管理端复杂业务接口\n"
                    + " * @date 2022-11-02\n"
                    + " */\n"
                    + "public interface "
                    + baseAdminServiceFileName
                    + " {\n"
                    + "\n"
                    + "    \n"
                    + "}");
            baseAdminServiceWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        String baseAdminServiceImplFilePath =
            defaultOutPutDir
                + "\\"
                + defaultParentPackPath
                + "\\"
                + moduleName
                + "\\"
                + "service\\"
                + "impl\\";
        String baseAdminServiceImplFileName =
            StrUtil.toCamelCase(tableNameItem) + "AdminBaseServiceImpl";
        File baseAdminServiceImplFile =
            new File(baseAdminServiceImplFilePath, baseAdminServiceImplFileName + ".java");
        if (!baseAdminServiceImplFile.exists()) {
          try {
            baseAdminServiceImplFile.createNewFile();
            FileWriter baseAdminServiceImplWriter = new FileWriter(baseAdminServiceImplFile);
            baseAdminServiceImplWriter.write(
                "package "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".service.impl;\n"
                    + "\n"
                    + "import "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".service."
                    + baseAdminServiceFileName
                    + ";\n"
                    + "\n"
                    + "import org.slf4j.Logger;\n"
                    + "import org.slf4j.LoggerFactory;\n"
                    + "import org.springframework.stereotype.Service;\n"
                    + "\n"
                    + "\n"
                    + "/**\n"
                    + " * @author com.macro.mall.tiny.modules.mark\n"
                    + " * @description "
                    + moduleName
                    + "模块复杂业务(pc端)\n"
                    + " * @date 2022-11-02\n"
                    + " */\n"
                    + "@Service\n"
                    + "public class "
                    + baseAdminServiceImplFileName
                    + "  implements "
                    + baseAdminServiceFileName
                    + " {\n"
                    + "    private static final Logger LOGGER = LoggerFactory.getLogger("
                    + baseAdminServiceImplFileName
                    + ".class);\n"
                    + "}");
            baseAdminServiceImplWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        String baseMobileServiceFilePath =
            defaultOutPutDir
                + "\\"
                + defaultParentPackPath
                + "\\"
                + moduleName
                + "\\"
                + "service\\";
        String baseMobileServiceFileName = StrUtil.toCamelCase(tableNameItem) + "MobileBaseService";
        File baseMobileServiceFile =
            new File(baseMobileServiceFilePath, baseMobileServiceFileName + ".java");
        if (!baseMobileServiceFile.exists()) {
          try {
            baseMobileServiceFile.createNewFile();
            FileWriter baseMobileServiceWriter = new FileWriter(baseMobileServiceFile);
            baseMobileServiceWriter.write(
                "package "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".service;\n"
                    + "\n"
                    + "\n"
                    + "/**\n"
                    + " * @description "
                    + moduleName
                    + "移动端复杂业务接口\n"
                    + " * @date 2022-11-02\n"
                    + " */\n"
                    + "public interface "
                    + baseMobileServiceFileName
                    + " {\n"
                    + "\n"
                    + "    \n"
                    + "}");
            baseMobileServiceWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        String baseMobileServiceImplFilePath =
            defaultOutPutDir
                + "\\"
                + defaultParentPackPath
                + "\\"
                + moduleName
                + "\\"
                + "service\\"
                + "impl\\";
        String baseMobileServiceImplFileName =
            StrUtil.toCamelCase(tableNameItem) + "MobileBaseServiceImpl";
        File baseMobileServiceImplFile =
            new File(baseMobileServiceImplFilePath, baseMobileServiceImplFileName + ".java");
        if (!baseMobileServiceImplFile.exists()) {
          try {
            baseMobileServiceImplFile.createNewFile();
            FileWriter baseMobileServiceImplWriter = new FileWriter(baseMobileServiceImplFile);
            baseMobileServiceImplWriter.write(
                "package "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".service.impl;\n"
                    + "\n"
                    + "import "
                    + defaultParentPack
                    + "."
                    + moduleName
                    + ".service."
                    + baseMobileServiceFileName
                    + ";\n"
                    + "\n"
                    + "import org.slf4j.Logger;\n"
                    + "import org.slf4j.LoggerFactory;\n"
                    + "import org.springframework.stereotype.Service;\n"
                    + "\n"
                    + "\n"
                    + "/**\n"
                    + " * @author com.macro.mall.tiny.modules.mark\n"
                    + " * @description "
                    + moduleName
                    + "模块复杂业务(移动端)\n"
                    + " * @date 2022-11-02\n"
                    + " */\n"
                    + "@Service\n"
                    + "public class "
                    + baseMobileServiceImplFileName
                    + "  implements "
                    + baseMobileServiceFileName
                    + " {\n"
                    + "    private static final Logger LOGGER = LoggerFactory.getLogger("
                    + baseMobileServiceImplFileName
                    + ".class);\n"
                    + "}");
            baseMobileServiceImplWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        //                baseWriter.close();
        //                enumFileWriter.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
