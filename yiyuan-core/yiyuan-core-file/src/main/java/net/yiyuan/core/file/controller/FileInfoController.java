package net.yiyuan.core.file.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.file.model.FileInfo;
import net.yiyuan.core.file.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author 一源团队--小林同学
 * @date 2023-07-15
 * @module 文件管理
 * @folder 文件管理/
 */
@SaCheckLogin
@Slf4j
@RestController
public class FileInfoController {
  @Autowired private FileInfoService fileInfoService;

  /**
   * 列表(全部)
   *
   * @param request 实体
   * @return {@link CommonResult<List<FileInfo>>}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Description("文件管理//查询")
  @SaCheckPermission(
      value = {"file:info:query"},
      orRole = "admin")
  @GetMapping(value = "/file/info/list")
  @ResponseBody
  public CommonResult<List<FileInfo>> list(FileInfo request) throws Exception {
    return CommonResult.success(fileInfoService.list(request), "查询列表成功");
  }

  /**
   * 列表(分页)
   *
   * @param request 实体
   * @return {@link CommonResult<Page<FileInfo>>}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Description("文件管理//查询")
  @SaCheckPermission(
      value = {"file:info:query"},
      orRole = "admin")
  @GetMapping(value = "/file/info/pages")
  @ResponseBody
  public CommonResult<Page<FileInfo>> pages(
      FileInfo request,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "1") Integer pageNum)
      throws Exception {
    return CommonResult.success(fileInfoService.pages(request, pageSize, pageNum), "分页查询成功");
  }

  /**
   * 详情
   *
   * @param id id
   * @return {@link CommonResult<FileInfo>}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Description("文件管理//查询")
  @SaCheckPermission(
      value = {"file:info:query"},
      orRole = "admin")
  @GetMapping(value = "/file/info/details/{id}")
  @ResponseBody
  public CommonResult<FileInfo> details(@PathVariable("id") @Validated({NotEmpty.class}) String id)
      throws Exception {
    return CommonResult.success(fileInfoService.details(id), "查询详情成功");
  }

  /**
   * 删除(支持批量)
   *
   * @param ids id(多个逗号分割)
   * @return {@link CommonResult<String>}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Description("文件管理//删除")
  @SaCheckPermission(
      value = {"file:info:delete"},
      orRole = "admin")
  @PostMapping(value = "/file/info/delete")
  @ResponseBody
  public CommonResult<String> delete(@RequestParam @Validated({NotEmpty.class}) String ids)
      throws Exception {
    if (fileInfoService.delete(ids)) {
      return CommonResult.success(null, "删除成功");
    } else {
      return CommonResult.failed("删除失败");
    }
  }

  /**
   * 编辑
   *
   * @param request 实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Description("文件管理//编辑")
  @SaCheckPermission(
      value = {"file:info:edit"},
      orRole = "admin")
  @PostMapping(value = "/file/info/edit")
  @ResponseBody
  public CommonResult<String> edit(@RequestBody @Validated FileInfo request) throws Exception {
    if (fileInfoService.edit(request)) {
      return CommonResult.success(null, "修改成功");
    } else {
      return CommonResult.failed("修改失败");
    }
  }

  /**
   * 新增
   *
   * @param request 实体
   * @return {@link CommonResult<String>}
   * @author 一源团队--小林同学
   * @date 2023-07-15
   */
  @Description("文件管理//新增")
  @SaCheckPermission(
      value = {"file:info:add"},
      orRole = "admin")
  @PostMapping(value = "/file/info/add")
  @ResponseBody
  public CommonResult<String> add(@RequestBody @Validated FileInfo request) throws Exception {
    if (fileInfoService.add(request)) {
      return CommonResult.success(null, "新增成功");
    } else {
      return CommonResult.failed("新增失败");
    }
  }

  /**
   * 上传文件
   *
   * @param file 文件
   * @return fid
   */
  @SaIgnore
  @Description("文件管理//文件上传")
  @RequestMapping(value = "/file/upload", method = RequestMethod.POST)
  public CommonResult<String> upload(MultipartFile file) {
    if (file == null) {
      return CommonResult.failed("请选择上传文件");
    }
    String fileId;
    try {
      fileId = fileInfoService.uploadAsTemp(file);
    } catch (Exception e) {

      return CommonResult.failed("上传失败");
    }
    return CommonResult.success("上传成功", fileId);
  }

  /**
   * 文件下载
   *
   * @param fid 文件主键
   */
  @Description("文件管理//文件下载")
  @GetMapping("/file/download/{fid}")
  public void download(
      HttpServletRequest request, HttpServletResponse response, @PathVariable("fid") String fid)
      throws Exception {

    fileInfoService.downloadToResponse(fid, request, response);
  }
}
