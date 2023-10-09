package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductAttrKeyAddDTO;
import net.yiyuan.dto.PtmProductAttrKeyEditDTO;
import net.yiyuan.dto.PtmProductAttrKeyListDTO;
import net.yiyuan.dto.PtmProductAttrKeyPageDTO;
import net.yiyuan.model.PtmProductAttrKey;
import net.yiyuan.vo.PtmProductAttrKeyQueryVO;

import java.util.List;

/**
 * 商品属性keyService层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductAttrKeyService extends JoinIService
        <PtmProductAttrKey> {

    /**
     * 商品属性key列表(全部)
     *
     * @param request 商品属性key实体
     * @return {@link List< PtmProductAttrKeyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    List
            <PtmProductAttrKeyQueryVO> list(PtmProductAttrKeyListDTO request) throws Exception;

    /**
     * 商品属性key列表(分页)
     *
     * @param request 商品属性key实体
     * @return {@link Page< PtmProductAttrKeyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    Page
            <PtmProductAttrKeyQueryVO> page(PtmProductAttrKeyPageDTO request) throws Exception;

    /**
     * 商品属性key详情
     *
     * @param id 商品属性keyid
     * @return {@link PtmProductAttrKeyQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    PtmProductAttrKeyQueryVO details(String id) throws Exception;

    /**
     * 商品属性key详情
     *
     * @param request 商品属性key实体
     * @return {@link PtmProductAttrKey}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    PtmProductAttrKeyQueryVO details(PtmProductAttrKey request) throws Exception;

    /**
     * 删除商品属性key(支持批量)
     *
     * @param ids 商品属性keyid(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean delete(String ids) throws Exception;


    /**
     * 编辑商品属性key
     *
     * @param request 商品属性key实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean edit(PtmProductAttrKeyEditDTO request) throws Exception;

    /**
     * 新增商品属性key
     *
     * @param request 商品属性key实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean add(PtmProductAttrKeyAddDTO request) throws Exception;
}
