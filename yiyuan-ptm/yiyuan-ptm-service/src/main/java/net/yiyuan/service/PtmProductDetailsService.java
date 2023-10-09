package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductDetailsAddDTO;
import net.yiyuan.dto.PtmProductDetailsEditDTO;
import net.yiyuan.dto.PtmProductDetailsListDTO;
import net.yiyuan.dto.PtmProductDetailsPageDTO;
import net.yiyuan.model.PtmProductDetails;
import net.yiyuan.vo.PtmProductDetailsQueryVO;

import java.util.List;

/**
 * 商品详情Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductDetailsService extends JoinIService
        <PtmProductDetails> {

    /**
     * 商品详情列表(全部)
     *
     * @param request 商品详情实体
     * @return {@link List< PtmProductDetailsQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    List
            <PtmProductDetailsQueryVO> list(PtmProductDetailsListDTO request) throws Exception;

    /**
     * 商品详情列表(分页)
     *
     * @param request 商品详情实体
     * @return {@link Page< PtmProductDetailsQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    Page
            <PtmProductDetailsQueryVO> page(PtmProductDetailsPageDTO request) throws Exception;

    /**
     * 商品详情详情
     *
     * @param id 商品详情id
     * @return {@link PtmProductDetailsQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    PtmProductDetailsQueryVO details(String id) throws Exception;

    /**
     * 商品详情详情
     *
     * @param request 商品详情实体
     * @return {@link PtmProductDetails}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    PtmProductDetailsQueryVO details(PtmProductDetails request) throws Exception;

    /**
     * 删除商品详情(支持批量)
     *
     * @param ids 商品详情id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean delete(String ids) throws Exception;


    /**
     * 编辑商品详情
     *
     * @param request 商品详情实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean edit(PtmProductDetailsEditDTO request) throws Exception;

    /**
     * 新增商品详情
     *
     * @param request 商品详情实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean add(PtmProductDetailsAddDTO request) throws Exception;
}
