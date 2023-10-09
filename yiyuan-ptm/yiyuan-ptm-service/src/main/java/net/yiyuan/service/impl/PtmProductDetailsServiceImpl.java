package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.PtmProductDetailsAddDTO;
import net.yiyuan.dto.PtmProductDetailsEditDTO;
import net.yiyuan.dto.PtmProductDetailsListDTO;
import net.yiyuan.dto.PtmProductDetailsPageDTO;
import net.yiyuan.mapper.PtmProductDetailsMapper;
import net.yiyuan.model.PtmProductDetails;
import net.yiyuan.service.PtmProductDetailsService;
import net.yiyuan.vo.PtmProductDetailsQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品详情Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class PtmProductDetailsServiceImpl extends JoinServiceImpl
        <PtmProductDetailsMapper, PtmProductDetails>
        implements PtmProductDetailsService {
    @Resource
    private PtmProductDetailsMapper ptmProductDetailsMapper;


    /**
     * 商品详情列表(全部)
     *
     * @param request 商品详情实体
     * @return {@link List< PtmProductDetailsQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public List
            <PtmProductDetailsQueryVO> list(PtmProductDetailsListDTO request) throws Exception {

        PtmProductDetails po = new PtmProductDetails();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <PtmProductDetails> wrapper = new JoinLambdaWrapper<>(po);
        List
                <PtmProductDetailsQueryVO> voList = ptmProductDetailsMapper.joinSelectList(wrapper, PtmProductDetailsQueryVO.class);

        return voList;
    }

    /**
     * 商品详情列表(分页)
     *
     * @param request 商品详情实体
     * @return {@link Page< PtmProductDetailsQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public Page
            <PtmProductDetailsQueryVO> page(PtmProductDetailsPageDTO request) throws Exception {
        PtmProductDetails po = new PtmProductDetails();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <PtmProductDetails> wrapper = new JoinLambdaWrapper<>(po);
        Page
                <PtmProductDetailsQueryVO> voPage =
                ptmProductDetailsMapper.joinSelectPage(
                        new Page<>(request.getPageNum(), request.getPageSize()), wrapper, PtmProductDetailsQueryVO.class);
        return voPage;
    }

    /**
     * 商品详情详情
     *
     * @param id 商品详情id
     * @return {@link PtmProductDetailsQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public PtmProductDetailsQueryVO details(String id) throws Exception {
        PtmProductDetails po = new PtmProductDetails();
        po.setId(id);
        JoinLambdaWrapper
                <PtmProductDetails> wrapper = new JoinLambdaWrapper<>(po);
        PtmProductDetailsQueryVO voBean = ptmProductDetailsMapper.joinSelectOne(wrapper, PtmProductDetailsQueryVO.class);
        return voBean;
    }

    /**
     * 商品详情详情
     *
     * @param request 商品详情实体
     * @return {@link PtmProductDetails}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public PtmProductDetailsQueryVO details(PtmProductDetails request) throws Exception {
        JoinLambdaWrapper
                <PtmProductDetails> wrapper = new JoinLambdaWrapper<>(request);
        PtmProductDetailsQueryVO voBean = ptmProductDetailsMapper.joinSelectOne(wrapper, PtmProductDetailsQueryVO.class);
        return voBean;
    }

    /**
     * 删除商品详情(支持批量)
     *
     * @param ids 商品详情id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean delete(String ids) throws Exception {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = ptmProductDetailsMapper.deleteBatchIds(idList);
        if (i == idList.size()) {
            return true;
        } else {
            throw new BusinessException("批量删除异常");
        }

    }


    /**
     * 编辑商品详情
     *
     * @param request 商品详情实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean edit(PtmProductDetailsEditDTO request) throws Exception {
        PtmProductDetails po = new PtmProductDetails();
        BeanUtilsPlus.copy(request, po);
        int i = ptmProductDetailsMapper.updateById(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("修改异常");
        }
    }

    /**
     * 新增商品详情
     *
     * @param request 商品详情实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean add(PtmProductDetailsAddDTO request) throws Exception {
        PtmProductDetails po = new PtmProductDetails();
        BeanUtilsPlus.copy(request, po);
        int i = ptmProductDetailsMapper.insert(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("新增异常");
        }
    }
}
