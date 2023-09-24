package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.*;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.UmProjectCollectAddDTO;
import net.yiyuan.dto.UmProjectCollectEditDTO;
import net.yiyuan.dto.UmProjectCollectListDTO;
import net.yiyuan.dto.UmProjectCollectPageDTO;
import net.yiyuan.model.UmProjectCollect;
import net.yiyuan.vo.UmProjectCollectQueryVO;
import net.yiyuan.mapper.UmProjectCollectMapper;

import  net.yiyuan.service.UmProjectCollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 浏览记录Service层接口实现
 *
 * @author  小林同学
 * @date 2023-09-21
 */
@Slf4j
@Service
public class UmProjectCollectServiceImpl extends JoinServiceImpl
        <UmProjectCollectMapper, UmProjectCollect>
        implements UmProjectCollectService {
    @Resource
    private UmProjectCollectMapper umProjectCollectMapper;


    /**
     * 浏览记录列表(全部)
     *
     * @param request 浏览记录实体
     * @return {@link List< UmProjectCollectQueryVO >}
     * @author  小林同学
     * @date 2023-09-21
     */
    @Override
    public List
            <UmProjectCollectQueryVO> list(UmProjectCollectListDTO request) throws Exception {

        UmProjectCollect po = new UmProjectCollect();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <UmProjectCollect> wrapper = new JoinLambdaWrapper<>(po);
        List
                <UmProjectCollectQueryVO> voList = umProjectCollectMapper.joinSelectList(wrapper, UmProjectCollectQueryVO.class);

        return voList;
    }

    /**
     * 浏览记录列表(分页)
     *
     * @param request 浏览记录实体
     * @return {@link Page< UmProjectCollectQueryVO >}
     * @author  小林同学
     * @date 2023-09-21
     */
    @Override
    public Page
            <UmProjectCollectQueryVO> page(UmProjectCollectPageDTO request) throws Exception {
        UmProjectCollect po = new UmProjectCollect();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <UmProjectCollect> wrapper = new JoinLambdaWrapper<>(po);
        Page
                <UmProjectCollectQueryVO> voPage =
                    umProjectCollectMapper.joinSelectPage(
                new Page<>(request.getPageNum(), request.getPageSize()), wrapper, UmProjectCollectQueryVO.class);
        return voPage;
    }

    /**
     * 浏览记录详情
     *
     * @param id 浏览记录id
     * @return {@link UmProjectCollectQueryVO}
     * @author  小林同学
     * @date 2023-09-21
     */
    @Override
    public UmProjectCollectQueryVO details(String id) throws Exception {
        UmProjectCollect po = new UmProjectCollect();
        po.setId(id);
        JoinLambdaWrapper
                <UmProjectCollect> wrapper = new JoinLambdaWrapper<>(po);
            UmProjectCollectQueryVO voBean = umProjectCollectMapper.joinSelectOne(wrapper, UmProjectCollectQueryVO.class);
        return voBean;
    }

    /**
     * 浏览记录详情
     *
     * @param request 浏览记录实体
     * @return {@link UmProjectCollect}
     * @author  小林同学
     * @date 2023-09-21
     */
    @Override
    public UmProjectCollectQueryVO details(UmProjectCollect request) throws Exception {
        JoinLambdaWrapper
                <UmProjectCollect> wrapper = new JoinLambdaWrapper<>(request);
            UmProjectCollectQueryVO voBean = umProjectCollectMapper.joinSelectOne(wrapper, UmProjectCollectQueryVO.class);
        return voBean;
    }

    /**
     * 删除浏览记录(支持批量)
     *
     * @param ids 浏览记录id(多个逗号分割)
     * @return {@link boolean}
     * @author  小林同学
     * @date 2023-09-21
     */
    @Override
    public boolean delete(String ids) throws Exception {
        List<String> idList = Arrays.asList(ids.split("," ));
        int i = umProjectCollectMapper.deleteBatchIds(idList);
        if (i == idList.size()) {
            return true;
        } else {
            throw new BusinessException("批量删除异常" );
        }

    }


    /**
     * 编辑浏览记录
     *
     * @param request 浏览记录实体
     * @return {@link boolean}
     * @author  小林同学
     * @date 2023-09-21
     */
    @Override
    public boolean edit(UmProjectCollectEditDTO request) throws Exception {
        UmProjectCollect po = new UmProjectCollect();
        BeanUtilsPlus.copy(request, po);
        int i = umProjectCollectMapper.updateById(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("修改异常" );
        }
    }

    /**
     * 新增浏览记录
     *
     * @param request 浏览记录实体
     * @return {@link boolean}
     * @author  小林同学
     * @date 2023-09-21
     */
    @Override
    public boolean add(UmProjectCollectAddDTO request) throws Exception {
        UmProjectCollect po = new UmProjectCollect();
        BeanUtilsPlus.copy(request, po);
        int i = umProjectCollectMapper.insert(po);
        if (i != 0) {
            return true;
        } else {
            throw new BusinessException("新增异常" );
        }
    }
}
