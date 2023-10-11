package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.MamActivitiyAddDTO;
import net.yiyuan.dto.MamActivitiyEditDTO;
import net.yiyuan.dto.MamActivitiyListDTO;
import net.yiyuan.dto.MamActivitiyPageDTO;
import net.yiyuan.mapper.MamActivitiyMapper;
import net.yiyuan.model.MamActivitiy;
import net.yiyuan.service.MamActivitiyService;
import net.yiyuan.vo.MamActivitiyQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 营销活动Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class MamActivitiyServiceImpl extends JoinServiceImpl
        <MamActivitiyMapper, MamActivitiy>
        implements MamActivitiyService {
    @Resource
    private MamActivitiyMapper mamActivitiyMapper;


    /**
     * 营销活动列表(全部)
     *
     * @param request 营销活动实体
     * @return {@link List< MamActivitiyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public List
            <MamActivitiyQueryVO> list(MamActivitiyListDTO request) throws Exception {

        MamActivitiy po = new MamActivitiy();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <MamActivitiy> wrapper = new JoinLambdaWrapper<>(po);
        wrapper.orderByDesc(MamActivitiy::getCreateTime);
        List
                <MamActivitiyQueryVO> voList = mamActivitiyMapper.joinSelectList(wrapper, MamActivitiyQueryVO.class);

        return voList;
    }

    /**
     * 营销活动列表(分页)
     *
     * @param request 营销活动实体
     * @return {@link Page< MamActivitiyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public Page
            <MamActivitiyQueryVO> page(MamActivitiyPageDTO request) throws Exception {
        MamActivitiy po = new MamActivitiy();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <MamActivitiy> wrapper = new JoinLambdaWrapper<>(po);
        wrapper.orderByDesc(MamActivitiy::getCreateTime);
        Page
                <MamActivitiyQueryVO> voPage =
                mamActivitiyMapper.joinSelectPage(
                        new Page<>(request.getPageNum(), request.getPageSize()), wrapper, MamActivitiyQueryVO.class);
        return voPage;
    }

    /**
     * 营销活动详情
     *
     * @param id 营销活动id
     * @return {@link MamActivitiyQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public MamActivitiyQueryVO details(String id) throws Exception {
        MamActivitiy po = new MamActivitiy();
        po.setId(id);
        JoinLambdaWrapper
                <MamActivitiy> wrapper = new JoinLambdaWrapper<>(po);
        MamActivitiyQueryVO voBean = mamActivitiyMapper.joinSelectOne(wrapper, MamActivitiyQueryVO.class);
        return voBean;
    }

    /**
     * 营销活动详情
     *
     * @param request 营销活动实体
     * @return {@link MamActivitiy}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public MamActivitiyQueryVO details(MamActivitiy request) throws Exception {
        JoinLambdaWrapper
                <MamActivitiy> wrapper = new JoinLambdaWrapper<>(request);
        MamActivitiyQueryVO voBean = mamActivitiyMapper.joinSelectOne(wrapper, MamActivitiyQueryVO.class);
        return voBean;
    }

    /**
     * 删除营销活动(支持批量)
     *
     * @param ids 营销活动id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean delete(String ids) throws Exception {
        List<String> idList = Arrays.asList(ids.split(","));
        int i = mamActivitiyMapper.deleteBatchIds(idList);
        if (i == idList.size()) {
            return true;
        } else {
            throw new BusinessException("批量删除异常");
        }

    }


    /**
     * 编辑营销活动
     *
     * @param request 营销活动实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean edit(MamActivitiyEditDTO request) throws Exception {
        MamActivitiy po = new MamActivitiy();
        BeanUtilsPlus.copy(request, po);
        int i = mamActivitiyMapper.updateById(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("修改异常");
        }
    }

    /**
     * 新增营销活动
     *
     * @param request 营销活动实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @Override
    public boolean add(MamActivitiyAddDTO request) throws Exception {
        MamActivitiy po = new MamActivitiy();
        BeanUtilsPlus.copy(request, po);
        int i = mamActivitiyMapper.insert(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("新增异常");
        }
    }
}
