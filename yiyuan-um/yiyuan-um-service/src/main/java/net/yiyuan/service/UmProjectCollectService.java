package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmProjectCollectAddDTO;
import net.yiyuan.dto.UmProjectCollectEditDTO;
import net.yiyuan.dto.UmProjectCollectListDTO;
import net.yiyuan.dto.UmProjectCollectPageDTO;
import net.yiyuan.model.UmProjectCollect;
import net.yiyuan.vo.UmProjectCollectQueryVO;

import java.util.List;

/**
 * 浏览记录Service层接口
 *
 * @author 小林同学
 * @date 2023-09-21
 */
public interface UmProjectCollectService extends JoinIService
        <UmProjectCollect> {

    /**
     * 浏览记录列表(全部)
     *
     * @param request 浏览记录实体
     * @return {@link List< UmProjectCollectQueryVO >}
     * @author 小林同学
     * @date 2023-09-21
     */
    List
            <UmProjectCollectQueryVO> list(UmProjectCollectListDTO request) throws Exception;

    /**
     * 浏览记录列表(分页)
     *
     * @param request 浏览记录实体
     * @return {@link Page< UmProjectCollectQueryVO >}
     * @author 小林同学
     * @date 2023-09-21
     */
    Page
            <UmProjectCollectQueryVO> page(UmProjectCollectPageDTO request) throws Exception;

    /**
     * 浏览记录详情
     *
     * @param id 浏览记录id
     * @return {@link UmProjectCollectQueryVO}
     * @author 小林同学
     * @date 2023-09-21
     */
    UmProjectCollectQueryVO details(String id) throws Exception;

    /**
     * 浏览记录详情
     *
     * @param request 浏览记录实体
     * @return {@link UmProjectCollect}
     * @author 小林同学
     * @date 2023-09-21
     */
    UmProjectCollectQueryVO details(UmProjectCollect request) throws Exception;

    /**
     * 删除浏览记录(支持批量)
     *
     * @param ids 浏览记录id(多个逗号分割)
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-21
     */
    boolean delete(String ids) throws Exception;


    /**
     * 编辑浏览记录
     *
     * @param request 浏览记录实体
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-21
     */
    boolean edit(UmProjectCollectEditDTO request) throws Exception;

    /**
     * 新增浏览记录
     *
     * @param request 浏览记录实体
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-21
     */
    boolean add(UmProjectCollectAddDTO request) throws Exception;
}
