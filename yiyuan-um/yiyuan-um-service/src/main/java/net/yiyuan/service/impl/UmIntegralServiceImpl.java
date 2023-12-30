package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.*;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.UmIntegralAddDTO;
import net.yiyuan.dto.UmIntegralEditDTO;
import net.yiyuan.dto.UmIntegralListDTO;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.vo.UmIntegralQueryVO;
import net.yiyuan.mapper.UmIntegralMapper;

import  net.yiyuan.service.UmIntegralService;
import org.springframework.stereotype.Service;
import net.yiyuan.model.*;
import net.yiyuan.enums.*;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import net.yiyuan.plugins.mp.utils.LambdaFunUtils;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
/**
 * 积分Service层接口实现
 *
 * @author  spring
 * @date 2023-12-19
 */
@Slf4j
@Service
public class UmIntegralServiceImpl extends JoinServiceImpl<UmIntegralMapper, UmIntegral>
        implements UmIntegralService {
    @Resource
    private UmIntegralMapper umIntegralMapper;


    /**
     * 积分列表(全部)
     *
     * @param request 积分实体
     * @return {@link List< UmIntegralQueryVO >}
     * @author  spring
     * @date 2023-12-19
     */
    @Override
    public List<UmIntegralQueryVO> list(UmIntegralListDTO request) throws Exception {

        UmIntegral po = new UmIntegral();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <UmIntegral> wrapper = new JoinLambdaWrapper<>(po);
                                                            wrapper.orderByDesc(UmIntegral::getCreateTime);
                List
                <UmIntegralQueryVO> voList = umIntegralMapper.joinSelectList(wrapper, UmIntegralQueryVO.class);

        return voList;
    }

    /**
     * 积分列表(分页)
     *
     * @param request 积分实体
     * @return {@link Page< UmIntegralQueryVO >}
     * @author  spring
     * @date 2023-12-19
     */
    @Override
    public Page<UmIntegralQueryVO> page(UmIntegralPageDTO request) throws Exception {
        UmIntegral po = new UmIntegral();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <UmIntegral> wrapper = new JoinLambdaWrapper<>(po);
                                                            wrapper.orderByDesc(UmIntegral::getCreateTime);
                Page
                <UmIntegralQueryVO> voPage =
                    umIntegralMapper.joinSelectPage(
                new Page<>(request.getPageNum(), request.getPageSize()), wrapper, UmIntegralQueryVO.class);
        return voPage;
    }

    /**
     * 积分详情
     *
     * @param id 积分id
     * @return {@link UmIntegralQueryVO}
     * @author  spring
     * @date 2023-12-19
     */
    @Override
    public UmIntegralQueryVO details(String id) throws Exception {
        UmIntegral po = new UmIntegral();
        po.setId(id);
        JoinLambdaWrapper
                <UmIntegral> wrapper = new JoinLambdaWrapper<>(po);
                    UmIntegralQueryVO voBean = umIntegralMapper.joinSelectOne(wrapper, UmIntegralQueryVO.class);
        return voBean;
    }

    /**
     * 积分详情
     *
     * @param request 积分实体
     * @return {@link UmIntegral}
     * @author  spring
     * @date 2023-12-19
     */
    @Override
    public UmIntegralQueryVO details(UmIntegral request) throws Exception {
        JoinLambdaWrapper
                <UmIntegral> wrapper = new JoinLambdaWrapper<>(request);
                    UmIntegralQueryVO voBean = umIntegralMapper.joinSelectOne(wrapper, UmIntegralQueryVO.class);
        return voBean;
    }

    /**
     * 删除积分(支持批量)
     *
     * @param ids 积分id(多个逗号分割)
     * @return {@link boolean}
     * @author  spring
     * @date 2023-12-19
     */
    @Override
    public boolean delete(String ids) throws Exception {
                                                        List<String> idList = Arrays.asList(ids.split(","));
        int i = umIntegralMapper.deleteBatchIds(idList);
        if (i == idList.size()) {
            return true;
        } else {
            throw new BusinessException("批量删除异常");
        }

    }


    /**
     * 编辑积分
     *
     * @param request 积分实体
     * @return {@link boolean}
     * @author  spring
     * @date 2023-12-19
     */
    @Override
    public boolean edit(UmIntegralEditDTO request) throws Exception {
        UmIntegral po = new UmIntegral();
        BeanUtilsPlus.copy(request, po);
        int i = umIntegralMapper.updateById(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("修改异常");
        }
    }

    /**
     * 新增积分
     *
     * @param request 积分实体
     * @return {@link boolean}
     * @author  spring
     * @date 2023-12-19
     */
    @Override
    public boolean add(UmIntegralAddDTO request) throws Exception {
        UmIntegral po = new UmIntegral();
        BeanUtilsPlus.copy(request, po);
        int i = umIntegralMapper.insert(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("新增异常");
        }
    }
}
