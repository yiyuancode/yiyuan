package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.PtmProductAttrValueAddDTO;
import net.yiyuan.dto.PtmProductAttrValueEditDTO;
import net.yiyuan.dto.PtmProductAttrValueListDTO;
import net.yiyuan.dto.PtmProductAttrValuePageDTO;
import net.yiyuan.mapper.PtmProductAttrValueMapper;
import net.yiyuan.model.PtmProductAttrValue;
import net.yiyuan.service.PtmProductAttrValueService;
import net.yiyuan.vo.PtmProductAttrValueQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品属性valueService层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductAttrValueServiceImpl extends JoinServiceImpl
        <PtmProductAttrValueMapper, PtmProductAttrValue>
        implements PtmProductAttrValueService {
    @Resource
    private PtmProductAttrValueMapper ptmProductAttrValueMapper;


    /**
     * 商品属性value列表(全部)
     *
     * @param request 商品属性value实体
     * @return {@link List< PtmProductAttrValueQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public List
            <PtmProductAttrValueQueryVO> list(PtmProductAttrValueListDTO request) throws Exception {

        PtmProductAttrValue po = new PtmProductAttrValue();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <PtmProductAttrValue> wrapper = new JoinLambdaWrapper<>(po);
        wrapper.orderByDesc(PtmProductAttrValue::getCreateTime);
        List
                <PtmProductAttrValueQueryVO> voList = ptmProductAttrValueMapper.joinSelectList(wrapper, PtmProductAttrValueQueryVO.class);

        return voList;
    }

    /**
     * 商品属性value列表(分页)
     *
     * @param request 商品属性value实体
     * @return {@link Page< PtmProductAttrValueQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public Page
            <PtmProductAttrValueQueryVO> page(PtmProductAttrValuePageDTO request) throws Exception {
        PtmProductAttrValue po = new PtmProductAttrValue();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <PtmProductAttrValue> wrapper = new JoinLambdaWrapper<>(po);
        wrapper.orderByDesc(PtmProductAttrValue::getCreateTime);
        Page
                <PtmProductAttrValueQueryVO> voPage =
                ptmProductAttrValueMapper.joinSelectPage(
                        new Page<>(request.getPageNum(), request.getPageSize()), wrapper, PtmProductAttrValueQueryVO.class);
        return voPage;
    }

    /**
     * 商品属性value详情
     *
     * @param id 商品属性valueid
     * @return {@link PtmProductAttrValueQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public PtmProductAttrValueQueryVO details(String id) throws Exception {
        PtmProductAttrValue po = new PtmProductAttrValue();
        po.setId(id);
        JoinLambdaWrapper
                <PtmProductAttrValue> wrapper = new JoinLambdaWrapper<>(po);
        PtmProductAttrValueQueryVO voBean = ptmProductAttrValueMapper.joinSelectOne(wrapper, PtmProductAttrValueQueryVO.class);
        return voBean;
    }

    /**
     * 商品属性value详情
     *
     * @param request 商品属性value实体
     * @return {@link PtmProductAttrValue}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public PtmProductAttrValueQueryVO details(PtmProductAttrValue request) throws Exception {
        JoinLambdaWrapper
                <PtmProductAttrValue> wrapper = new JoinLambdaWrapper<>(request);
        PtmProductAttrValueQueryVO voBean = ptmProductAttrValueMapper.joinSelectOne(wrapper, PtmProductAttrValueQueryVO.class);
        return voBean;
    }

    /**
     * 删除商品属性value(支持批量)
     *
     * @param ids 商品属性valueid(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean delete(String ids) throws Exception {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = ptmProductAttrValueMapper.deleteBatchIds(idList);
        if (i == idList.size()) {
            return true;
        } else {
            throw new BusinessException("批量删除异常");
        }

    }


    /**
     * 编辑商品属性value
     *
     * @param request 商品属性value实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean edit(PtmProductAttrValueEditDTO request) throws Exception {
        PtmProductAttrValue po = new PtmProductAttrValue();
        BeanUtilsPlus.copy(request, po);
        int i = ptmProductAttrValueMapper.updateById(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("修改异常");
        }
    }

    /**
     * 新增商品属性value
     *
     * @param request 商品属性value实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean add(PtmProductAttrValueAddDTO request) throws Exception {
        PtmProductAttrValue po = new PtmProductAttrValue();
        BeanUtilsPlus.copy(request, po);
        int i = ptmProductAttrValueMapper.insert(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("新增异常");
        }
    }
}
