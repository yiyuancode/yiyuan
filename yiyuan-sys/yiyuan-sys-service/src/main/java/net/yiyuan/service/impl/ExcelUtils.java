package net.yiyuan.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/** Excel导入导出工具类 */
public class ExcelUtils {

  /** 允许导出的最大条数 */
  private static final Integer EXPORT_EXCEL_MAX_NUM = 10000;

  /**
   * excel 导出 (本地)
   *
   * @param list 数据列表
   * @param excelType HSSF, XSSF
   */
  public static <T> void exportExcel(File file, List<T> list, ExcelType excelType)
      throws IOException {
    FileOutputStream fos = new FileOutputStream(file);
    //    Workbook workbook =
    //        ExcelExportUtil.exportExcel(
    //            new ExportParams(null, file.getName(), excelType), UserEntity.class, list);
    //
    //    workbook.write(fos);
    //    workbook.close();
  }
  /**
   * excel 导出
   *
   * @param list 数据列表
   * @param fileName 导出时的excel名称
   * @param response
   */
  public static void exportExcel(
      List<Map<String, Object>> list,
      String fileName,
      ExcelType excelType,
      HttpServletResponse response)
      throws IOException {
    defaultExport(list, fileName, excelType, response);
  }

  /**
   * 默认的 excel 导出
   *
   * @param list 数据列表
   * @param fileName 导出时的excel名称
   * @param response
   */
  private static void defaultExport(
      List<Map<String, Object>> list,
      String fileName,
      ExcelType excelType,
      HttpServletResponse response)
      throws IOException {

    // 把数据添加到excel表格中
    Workbook workbook = ExcelExportUtil.exportExcel(list, excelType);
    downLoadExcel(fileName, response, workbook);
  }

  /**
   * excel 导出
   *
   * @param list 数据列表
   * @param pojoClass pojo类型
   * @param fileName 导出时的excel名称
   * @param response
   * @param exportParams 导出参数（标题、sheet名称、是否创建表头，表格类型）
   */
  private static void defaultExport(
      List<?> list,
      Class<?> pojoClass,
      String fileName,
      HttpServletResponse response,
      ExportParams exportParams)
      throws IOException {
    // 把数据添加到excel表格中
    Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
    downLoadExcel(fileName, response, workbook);
  }

  /**
   * excel 导出
   *
   * @param list 数据列表
   * @param pojoClass pojo类型
   * @param fileName 导出时的excel名称
   * @param exportParams 导出参数（标题、sheet名称、是否创建表头，表格类型）
   * @param response
   */
  public static void exportExcel(
      List<?> list,
      Class<?> pojoClass,
      String fileName,
      ExportParams exportParams,
      HttpServletResponse response)
      throws IOException {
    defaultExport(list, pojoClass, fileName, response, exportParams);
  }

  /**
   * excel 导出
   *
   * @param list 数据列表
   * @param title 表格内数据标题
   * @param sheetName sheet名称
   * @param pojoClass pojo类型
   * @param fileName 导出时的excel名称
   * @param response
   */
  public static void exportExcel(
      List<?> list,
      String title,
      String sheetName,
      Class<?> pojoClass,
      String fileName,
      HttpServletResponse response)
      throws IOException {
    // 给文件名拼接上日期
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(new Date());
    fileName = fileName + dateString;
    // 判断导出数据是否为空
    if (list == null) {
      list = new ArrayList<>();
    }
    // 判断导出数据数量是否超过限定值
    if (list.size() > EXPORT_EXCEL_MAX_NUM) {
      title = "导出数据行数超过:" + EXPORT_EXCEL_MAX_NUM + "条,无法导出、请添加导出条件!";
      list = new ArrayList<>();
    }
    // 获取导出参数
    ExportParams exportParams = new ExportParams(title, sheetName, ExcelType.XSSF);
    // 设置导出样式
    //        exportParams.setStyle(ExcelStyleUtil.class);
    // 设置行高
    exportParams.setHeight((short) 6);

    defaultExport(list, pojoClass, fileName, response, exportParams);
  }

  /**
   * 根据模板生成excel后导出
   *
   * @param templatePath 模板路径
   * @param map 数据集合
   * @param fileName 文件名
   * @param response
   * @throws IOException
   */
  public static void exportExcel(
      TemplateExportParams templatePath,
      Map<String, Object> map,
      String fileName,
      HttpServletResponse response)
      throws IOException {
    Workbook workbook = ExcelExportUtil.exportExcel(templatePath, map);
    downLoadExcel(fileName, response, workbook);
  }

  /**
   * excel下载
   *
   * @param fileName 下载时的文件名称
   * @param response
   * @param workbook excel数据
   */
  private static void downLoadExcel(
      String fileName, HttpServletResponse response, Workbook workbook) throws IOException {
    try {
      response.setCharacterEncoding("UTF-8");
      response.setHeader("content-Type", "application/vnd.ms-excel");
      response.setHeader(
          "Content-Disposition",
          "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
      workbook.setForceFormulaRecalculation(true); // 强制开启excel公式计算
      workbook.write(response.getOutputStream());
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }

  /**
   * excel 导入
   *
   * @param file excel文件
   * @param pojoClass pojo类型
   * @param <T>
   * @return
   */
  public static <T> List<T> importExcel(MultipartFile file, Class<T> pojoClass) throws IOException {
    return importExcel(file, 1, 1, pojoClass);
  }

  /**
   * excel 导入
   *
   * @param filePath excel文件路径
   * @param titleRows 表格内数据标题行
   * @param headerRows 表头行
   * @param pojoClass pojo类型
   * @param <T>
   * @return
   */
  public static <T> List<T> importExcel(
      String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass)
      throws IOException {
    if (StringUtils.isBlank(filePath)) {
      return null;
    }
    ImportParams params = new ImportParams();
    params.setTitleRows(titleRows);
    params.setHeadRows(headerRows);
    params.setNeedSave(true);
    params.setSaveUrl("/excel/");
    try {
      return ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
    } catch (NoSuchElementException e) {
      throw new IOException("模板不能为空");
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }

  /**
   * excel 导入
   *
   * @param file 上传的文件
   * @param titleRows 表格内数据标题行
   * @param headerRows 表头行
   * @param pojoClass pojo类型
   * @param <T>
   * @return
   */
  public static <T> List<T> importExcel(
      MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)
      throws IOException {
    if (file == null) {
      return null;
    }
    try {
      return importExcel(file.getInputStream(), titleRows, headerRows, pojoClass);
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }

  /**
   * excel 导入
   *
   * @param inputStream 文件输入流
   * @param titleRows 表格内数据标题行
   * @param headerRows 表头行
   * @param pojoClass pojo类型
   * @param <T>
   * @return
   */
  public static <T> List<T> importExcel(
      InputStream inputStream, Integer titleRows, Integer headerRows, Class<T> pojoClass)
      throws IOException {
    if (inputStream == null) {
      return null;
    }
    ImportParams params = new ImportParams();
    params.setTitleRows(titleRows);
    params.setHeadRows(headerRows);
    params.setSaveUrl("/excel/");
    params.setNeedSave(true);
    try {
      return ExcelImportUtil.importExcel(inputStream, pojoClass, params);
    } catch (NoSuchElementException e) {
      throw new IOException("excel文件不能为空");
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }
}
