package net.yiyuan.core.file.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.file.enums.*;
import net.yiyuan.core.file.exception.CustomUnifiedException;
import net.yiyuan.core.file.filecontext.FileOperatorContext;
import net.yiyuan.core.file.mapper.FileInfoMapper;
import net.yiyuan.core.file.model.FileInfo;
import net.yiyuan.core.file.operator.FileOperatorInter;
import net.yiyuan.core.file.pojo.dto.ObjectResponse;
import net.yiyuan.core.file.pojo.dto.UploadRequestParam;
import net.yiyuan.core.file.service.FileInfoService;
import net.yiyuan.core.file.utils.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Service层接口实现
 *
 * @author 一源团队--小林同学
 * @date 2023-07-15
 */
@Slf4j
@Service
public class FileInfoServiceImpl extends JoinServiceImpl<FileInfoMapper, FileInfo>
    implements FileInfoService {

  @Autowired private FileOperatorContext fileOperatorContext;
  /**
   * 列表(全部)
   *
   * @param request 实体
   * @return {@link List}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public List<FileInfo> list(FileInfo request) throws Exception {
    JoinLambdaWrapper<FileInfo> wrapper = new JoinLambdaWrapper<>(request);
    return joinList(wrapper, FileInfo.class);
  }

  /**
   * 列表(分页)
   *
   * @param request 实体
   * @return {@link Page}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public Page<FileInfo> pages(FileInfo request, Integer pageSize, Integer pageNum)
      throws Exception {
    JoinLambdaWrapper<FileInfo> wrapper = new JoinLambdaWrapper<>(request);
    Page<FileInfo> page = joinPage(new Page<>(pageNum, pageSize), wrapper, FileInfo.class);
    return page;
  }

  /**
   * 详情
   *
   * @param id id
   * @return {@link FileInfo}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public FileInfo details(String id) throws Exception {
    FileInfo query = new FileInfo();
    query.setId(id);
    JoinLambdaWrapper<FileInfo> wrapper = new JoinLambdaWrapper<>(query);
    return joinGetOne(wrapper, FileInfo.class);
  }

  /**
   * 详情
   *
   * @param request 实体
   * @return {@link FileInfo}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public FileInfo details(FileInfo request) throws Exception {
    JoinLambdaWrapper<FileInfo> wrapper = new JoinLambdaWrapper<>(request);
    return joinGetOne(wrapper, FileInfo.class);
  }

  /**
   * 删除(支持批量)
   *
   * @param ids id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 批量删除(根据同一属性,针对中间表)
   *
   * @param request 实体
   * @return {@link boolean}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public boolean delete(FileInfo request) throws Exception {
    JoinLambdaWrapper<FileInfo> wrapper = new JoinLambdaWrapper<>(request);
    return remove(wrapper);
  }

  /**
   * 编辑
   *
   * @param request 实体
   * @return {@link boolean}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public boolean edit(FileInfo request) throws Exception {
    return updateById(request);
  }

  /**
   * 新增
   *
   * @param request 实体
   * @return {@link boolean}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public boolean add(FileInfo request) throws Exception {
    return save(request);
  }

  /**
   * 文件上传
   *
   * @param file 实体
   * @return {@link boolean}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Override
  public String uploadAsTemp(MultipartFile file) {
    String name = file.getOriginalFilename();
    if (StringUtils.isBlank(name)) {
      throw CustomUnifiedException.aom("文件上传-获取文件名称为空");
    }

    // 剔除文件分隔符 windows
    if (name.contains("\\")) {
      name = name.substring(name.lastIndexOf('\\') + 1);
    }
    // linux
    if (name.contains("/")) {
      name = name.substring(name.lastIndexOf('/') + 1);
    }
    if (name.length() > 128) {
      throw CustomUnifiedException.aom("文件名超过限制长度128位");
    }

    String mimeType = "";
    try (InputStream is = file.getInputStream()) {
      // 文件有效的类型检测
      mimeType = FileUtils.detectMimeType(is, name);
      if (!checkMimeType(mimeType)) {
        throw CustomUnifiedException.msg("文件上传-非法文件格式");
      }
    } catch (Exception e) {
      throw CustomUnifiedException.msg("上传文件流读取异常", e);
    }

    String suffix = FilenameUtils.getExtension(name);
    String key = UUID.randomUUID().toString();
    // 获取激活当前的文件操作器
    FileOperatorInter operatorInter = fileOperatorContext.active();
    FileOperatorTypeEnum typeEnum =
        FileOperatorTypeEnum.getIgnoreCaseByName(operatorInter.getClass());

    FileInfoTypeEnum fileInfoTypeEnum = FileInfoTypeEnum.getTypeEnum(typeEnum.name());
    // 获取到所有参数 封装到UploadRequestParam
    UploadRequestParam requestParam =
        UploadRequestParam.builder()
            .key(key)
            .contentType(mimeType)
            .size(file.getSize())
            .extName(suffix)
            .build();
    ObjectResponse objectResponse;
    try {
      objectResponse = operatorInter.uploadFile(requestParam, file.getInputStream());
    } catch (IOException e) {
      throw CustomUnifiedException.aom("文件上传-获取文件流异常", e);
    }

    FileInfo fileinfo = new FileInfo();
    fileinfo.setId(key);
    fileinfo.setFileName(name);
    fileinfo.setFileName(name);
    if ("".equals(suffix) || suffix == null) {
      fileinfo.setSuffix(suffix);
    } else {
      fileinfo.setSuffix('.' + suffix);
    }
    fileinfo.setStoreplace(objectResponse.getStorePath());
    // 这个地方不能写死
    fileinfo.setType(fileInfoTypeEnum);

    fileinfo.setState(FileInfoStateEnum.TEMPORARY);
    fileinfo.setTime(Timestamp.valueOf(LocalDateTime.now()));
    save(fileinfo);
    return key;
  }
  /**
   * 流式下载文件
   *
   * @param fileinfo 文件信息
   * @param consumer 消费者
   */
  public void downloadAsStream(FileInfo fileinfo, Consumer<InputStream> consumer) {

    Objects.requireNonNull(fileinfo, "文件下载-必要参数[Fileinfo]不可为空");
    Objects.requireNonNull(consumer, "文件下载-必要参数[Consumer]不可为空");
    FileOperatorInter operatorInter = getOperatorByType(fileinfo);

    operatorInter.getFileAsStream(fileinfo.getStoreplace(), consumer);
  }

  @Override
  public void downloadToResponse(
      String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    FileInfo fileInfo = details(id);
    downloadAsStream(
        fileInfo,
        (InputStream is) -> {
          // 设置相应类型application/octet-stream （注：application/octet-stream 为通用，一些其它的类型苹果浏览器下载内容可能为空）
          response.reset();
          response.addHeader("Access-Control-Allow-Origin", "*");
          response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
          response.addHeader("Access-Control-Allow-Headers", "Content-Type");
          String userAgent = request.getHeader("user-agent").toLowerCase();
          String fileName = fileInfo.getFileName();
          if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
            // win10 ie edge 浏览器 和其他系统的ie
            try {
              fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
              throw CustomUnifiedException.aom("URLEncoder编码文件名称异常", e);
            }
          } else {
            fileName =
                new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
          }
          response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + '"');
          response.setContentType("application/octet-stream");

          try (ServletOutputStream os = response.getOutputStream()) {
            IOUtils.copy(is, os);
          } catch (IOException e) {
            throw CustomUnifiedException.aom("文件下载-获取servlet响应流异常", e);
          }
        });
  }

  /**
   * 下载文件并输出到响应流
   *
   * @param fname 文件名称
   * @param request 请求
   * @param response 响应
   */
  public void downloadToResponse(
      String fname,
      HttpServletRequest request,
      HttpServletResponse response,
      Supplier<InputStream> inputStreamSupplier) {
    // 设置相应类型application/octet-stream （注：application/octet-stream 为通用，一些其它的类型苹果浏览器下载内容可能为空）
    String fileName = fname;
    response.reset();
    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
    response.addHeader("Access-Control-Allow-Headers", "Content-Type");
    String userAgent = request.getHeader("user-agent").toLowerCase();
    if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
      // win10 ie edge 浏览器 和其他系统的ie
      try {
        fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name());
      } catch (UnsupportedEncodingException e) {
        throw CustomUnifiedException.aom("URLEncoder编码文件名称异常", e);
      }
    } else {
      fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + '"');
    response.setContentType("application/octet-stream");

    try (ServletOutputStream os = response.getOutputStream();
        InputStream is = inputStreamSupplier.get()) {
      IOUtils.copy(is, os);
    } catch (IOException e) {
      throw CustomUnifiedException.aom("文件下载-获取servlet响应流异常", e);
    }
  }

  /**
   * 根据文件信息获取对应文件操作器
   *
   * @param fileinfo 文件信息
   * @return 文件操作器
   */
  private FileOperatorInter getOperatorByType(FileInfo fileinfo) {
    String id = fileinfo.getId();
    // 确认目标文件存储类型
    FileEnum.Type type =
        Enums.getOptionalByValue(FileEnum.Type.class, fileinfo.getType())
            .orElseThrow(
                () -> CustomUnifiedException.aom(String.format("文件下载-目标文件[%s]存储类型不存在", id)));
    // 匹配文件类型操作器
    FileOperatorTypeEnum operatorTypeEnum = FileOperatorTypeEnum.getIgnoreCaseByName(type.name());
    // 获取指定的文件操作器
    return fileOperatorContext.getOperatorByType(operatorTypeEnum);
  }

  /**
   * 根据ID查询文件信息
   *
   * @param id 文件ID
   * @return FileInfo
   * @throws CustomUnifiedException 为空时抛出
   */
  private FileInfo gFileInfoById(String id) {

    JoinLambdaWrapper<String> wrapper = new JoinLambdaWrapper<>(id);
    return joinGetOne(wrapper, FileInfo.class);
  }

  /**
   * 检查允许的文件MimeType
   *
   * @param mimeType 媒体格式
   * @return 是否允许
   */
  private boolean checkMimeType(String mimeType) {
    Objects.requireNonNull(mimeType);
    // 允许的文件格式
    List<String> allowedDoc =
        Arrays.asList(
            // pdf
            "application/pdf",
            // word
            "application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            // excel
            "application/vnd.ms-excel",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            // 压缩文件  rar格式：application/x-rar-compressed; version=5
            "application/zip",
            "application/x-7z-compressed",
            "application/x-rar-compressed",
            "application/x-zip-compressed",
            // 图片
            "image/",
            // 视频
            "video/",
            // 投标的签名格式
            "application/pkcs7-signature");
    for (String doc : allowedDoc) {
      if (mimeType.startsWith(doc)) {
        return true;
      }
    }
    return false;
  }
}
