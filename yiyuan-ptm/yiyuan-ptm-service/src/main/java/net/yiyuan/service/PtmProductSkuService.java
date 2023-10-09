package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductSkuAddDTO;
import net.yiyuan.dto.PtmProductSkuEditDTO;
import net.yiyuan.dto.PtmProductSkuListDTO;
import net.yiyuan.dto.PtmProductSkuPageDTO;
import net.yiyuan.model.PtmProductSku;
import net.yiyuan.vo.PtmProductSkuQueryVO;

import java.util.List;

/**
 * 商品skuService层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductSkuService extends JoinIService
        <PtmProductSku> {

    /**
     * 商品sku列表(全部)
     *
     * @param request 商品sku实体
     * @return {@link List< PtmProductSkuQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    List
            <PtmProductSkuQueryVO> list(PtmProductSkuListDTO request) throws Exception;

    /**
     * 商品sku列表(分页)
     *
     * @param request 商品sku实体
     * @return {@link Page< PtmProductSkuQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    Page
            <PtmProductSkuQueryVO> page(PtmProductSkuPageDTO request) throws Exception;

    /**
     * 商品sku详情
     *
     * @param id 商品skuid
     * @return {@link PtmProductSkuQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    PtmProductSkuQueryVO details(String id) throws Exception;

    /**
     * 商品sku详情
     *
     * @param request 商品sku实体
     * @return {@link PtmProductSku}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    PtmProductSkuQueryVO details(PtmProductSku request) throws Exception;

    /**
     * 删除商品sku(支持批量)
     *
     * @param ids 商品skuid(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean delete(String ids) throws Exception;


    /**
     * 编辑商品sku
     *
     * @param request 商品sku实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean edit(PtmProductSkuEditDTO request) throws Exception;

    /**
     * 新增商品sku
     *
     * @param request 商品sku实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean add(PtmProductSkuAddDTO request) throws Exception;
}
