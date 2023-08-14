package net.yiyuan.core.file.service;

import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;

import java.util.Date;

import net.yiyuan.core.file.model.FileInfo;
import net.yiyuan.core.file.model.FileInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.common.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Service层接口
 *
 * @author 一源团队--小林同学
 * @date 2023-07-15
 */
public interface FileInfoService extends JoinIService<FileInfo> {

    /**
     * 列表(全部)
     *
     * @param request 实体
     * @return {@link List}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    List<FileInfo> list(FileInfo request) throws Exception;


    /**
     * 列表(分页)
     *
     * @param request 实体
     * @return {@link Page}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    Page<FileInfo> pages(FileInfo request, Integer pageSize, Integer pageNum) throws Exception;


    /**
     * 详情
     *
     * @param id id
     * @return {@link FileInfo}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    FileInfo details(String id) throws Exception;


    /**
     * 详情
     *
     * @param request 实体
     * @return {@link FileInfo}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    FileInfo details(FileInfo request) throws Exception;


    /**
     * 删除(支持批量)
     *
     * @param ids id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */

    boolean delete(String ids) throws Exception;


    /**
     * 批量删除(根据同一属性,针对中间表)
     *
     * @param request 实体
     * @return {@link boolean}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    boolean delete(FileInfo request) throws Exception;

    /**
     * 编辑
     *
     * @param request 实体
     * @return {@link boolean}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    boolean edit(FileInfo request) throws Exception;


    /**
     * 新增
     *
     * @param request 实体
     * @return {@link boolean}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    boolean add(FileInfo request) throws Exception;

    /**
     * 文件上传
     *
     * @param file 实体
     * @return {@link boolean}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    String uploadAsTemp(MultipartFile file);
    /**
     * 文件下载
     *
     * @param request，response 实体
     * @return {@link boolean}
     * @author 一源团队--小林同学
     * @date 2023-07-15
     */
    void downloadToResponse(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}