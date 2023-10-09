package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.PtmProductAttrKeyAddDTO;
import net.yiyuan.dto.PtmProductAttrKeyEditDTO;
import net.yiyuan.dto.PtmProductAttrKeyListDTO;
import net.yiyuan.dto.PtmProductAttrKeyPageDTO;
import net.yiyuan.mapper.PtmProductAttrKeyMapper;
import net.yiyuan.model.PtmProductAttrKey;
import net.yiyuan.service.PtmProductAttrKeyService;
import net.yiyuan.vo.PtmProductAttrKeyQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品属性keyService层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductAttrKeyServiceImpl extends JoinServiceImpl
        <PtmProductAttrKeyMapper, PtmProductAttrKey>
        implements PtmProductAttrKeyService {
    @Resource
    private PtmProductAttrKeyMapper ptmProductAttrKeyMapper;


    /**
     * 商品属性key列表(全部)
     *
     * @param request 商品属性key实体
     * @return {@link List< PtmProductAttrKeyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public List
            <PtmProductAttrKeyQueryVO> list(PtmProductAttrKeyListDTO request) throws Exception {

        PtmProductAttrKey po = new PtmProductAttrKey();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <PtmProductAttrKey> wrapper = new JoinLambdaWrapper<>(po);
        wrapper.orderByDesc(PtmProductAttrKey::getCreateTime);
        List
                <PtmProductAttrKeyQueryVO> voList = ptmProductAttrKeyMapper.joinSelectList(wrapper, PtmProductAttrKeyQueryVO.class);

        return voList;
    }

    /**
     * 商品属性key列表(分页)
     *
     * @param request 商品属性key实体
     * @return {@link Page< PtmProductAttrKeyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public Page
            <PtmProductAttrKeyQueryVO> page(PtmProductAttrKeyPageDTO request) throws Exception {
        PtmProductAttrKey po = new PtmProductAttrKey();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <PtmProductAttrKey> wrapper = new JoinLambdaWrapper<>(po);
        wrapper.orderByDesc(PtmProductAttrKey::getCreateTime);
        Page
                <PtmProductAttrKeyQueryVO> voPage =
                ptmProductAttrKeyMapper.joinSelectPage(
                        new Page<>(request.getPageNum(), request.getPageSize()), wrapper, PtmProductAttrKeyQueryVO.class);
        return voPage;
    }

    /**
     * 商品属性key详情
     *
     * @param id 商品属性keyid
     * @return {@link PtmProductAttrKeyQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public PtmProductAttrKeyQueryVO details(String id) throws Exception {
        PtmProductAttrKey po = new PtmProductAttrKey();
        po.setId(id);
        JoinLambdaWrapper
                <PtmProductAttrKey> wrapper = new JoinLambdaWrapper<>(po);
        PtmProductAttrKeyQueryVO voBean = ptmProductAttrKeyMapper.joinSelectOne(wrapper, PtmProductAttrKeyQueryVO.class);
        return voBean;
    }

    /**
     * 商品属性key详情
     *
     * @param request 商品属性key实体
     * @return {@link PtmProductAttrKey}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public PtmProductAttrKeyQueryVO details(PtmProductAttrKey request) throws Exception {
        JoinLambdaWrapper
                <PtmProductAttrKey> wrapper = new JoinLambdaWrapper<>(request);
        PtmProductAttrKeyQueryVO voBean = ptmProductAttrKeyMapper.joinSelectOne(wrapper, PtmProductAttrKeyQueryVO.class);
        return voBean;
    }

    /**
     * 删除商品属性key(支持批量)
     *
     * @param ids 商品属性keyid(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean delete(String ids) throws Exception {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = ptmProductAttrKeyMapper.deleteBatchIds(idList);
        if (i == idList.size()) {
            return true;
        } else {
            throw new BusinessException("批量删除异常");
        }

    }


    /**
     * 编辑商品属性key
     *
     * @param request 商品属性key实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean edit(PtmProductAttrKeyEditDTO request) throws Exception {
        PtmProductAttrKey po = new PtmProductAttrKey();
        BeanUtilsPlus.copy(request, po);
        int i = ptmProductAttrKeyMapper.updateById(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("修改异常");
        }
    }

    /**
     * 新增商品属性key
     *
     * @param request 商品属性key实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean add(PtmProductAttrKeyAddDTO request) throws Exception {
        PtmProductAttrKey po = new PtmProductAttrKey();
        BeanUtilsPlus.copy(request, po);
        int i = ptmProductAttrKeyMapper.insert(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("新增异常");
        }
    }
}
