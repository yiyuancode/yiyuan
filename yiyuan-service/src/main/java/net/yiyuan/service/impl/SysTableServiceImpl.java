package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysTableAddDTO;
import net.yiyuan.dto.SysTableEditDTO;
import net.yiyuan.dto.SysTableListDTO;
import net.yiyuan.dto.SysTablePageDTO;
import net.yiyuan.model.SysTable;
import net.yiyuan.vo.SysTableQueryVO;
import net.yiyuan.mapper.SysTableMapper;

import  net.yiyuan.service.SysTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 数据库Service层接口实现
 *
 * @author  一源团队-花和尚
 * @date 2023-08-25
 */
@Slf4j
@Service
public class SysTableServiceImpl extends JoinServiceImpl
        <SysTableMapper, SysTable>
        implements SysTableService {
    @Resource
    private SysTableMapper sysTableMapper;


    /**
     * 数据库列表(全部)
     *
     * @param request 数据库实体
     * @return {@link List< SysTableQueryVO >}
     * @author  一源团队-花和尚
     * @date 2023-08-25
     */
    @Override
    public List
            <SysTableQueryVO> list(SysTableListDTO request) throws Exception {

        SysTable po = new SysTable();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <SysTable> wrapper = new JoinLambdaWrapper<>(po);
        List
                <SysTableQueryVO> voList = joinList(wrapper, SysTableQueryVO.class);

        return voList;
    }

    /**
     * 数据库列表(分页)
     *
     * @param request 数据库实体
     * @return {@link Page< SysTableQueryVO >}
     * @author  一源团队-花和尚
     * @date 2023-08-25
     */
    @Override
    public Page
            <SysTableQueryVO> page(SysTablePageDTO request) throws Exception {
        SysTable po = new SysTable();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <SysTable> wrapper = new JoinLambdaWrapper<>(po);
        Page
                <SysTableQueryVO> voPage =
                joinPage(
                        new Page<>(request.getPageNum(), request.getPageSize()), wrapper, SysTableQueryVO.class);
        return voPage;
    }

    /**
     * 数据库详情
     *
     * @param id 数据库id
     * @return {@link SysTableQueryVO}
     * @author  一源团队-花和尚
     * @date 2023-08-25
     */
    @Override
    public SysTableQueryVO details(String id) throws Exception {
        SysTable po = new SysTable();
        po.setId(id);
        JoinLambdaWrapper
                <SysTable> wrapper = new JoinLambdaWrapper<>(po);
            SysTableQueryVO voBean = joinGetOne(wrapper, SysTableQueryVO.class);
        return voBean;
    }

    /**
     * 数据库详情
     *
     * @param request 数据库实体
     * @return {@link SysTable}
     * @author  一源团队-花和尚
     * @date 2023-08-25
     */
    @Override
    public SysTableQueryVO details(SysTable request) throws Exception {

        JoinLambdaWrapper
                <SysTable> wrapper = new JoinLambdaWrapper<>(request);
            SysTableQueryVO voBean = joinGetOne(wrapper, SysTableQueryVO.class);
        return voBean;
    }

    /**
     * 删除数据库(支持批量)
     *
     * @param ids 数据库id(多个逗号分割)
     * @return {@link boolean}
     * @author  一源团队-花和尚
     * @date 2023-08-25
     */
    @Override
    public boolean delete(String ids) throws Exception {
        return removeByIds(Arrays.asList(ids.split(",")));
    }


    /**
     * 编辑数据库
     *
     * @param request 数据库实体
     * @return {@link boolean}
     * @author  一源团队-花和尚
     * @date 2023-08-25
     */
    @Override
    public boolean edit(SysTableEditDTO request) throws Exception {
        SysTable po = new SysTable();
        BeanUtilsPlus.copy(request, po);
        JoinLambdaWrapper
                <SysTable> wrapper = new JoinLambdaWrapper<>(po);
        return updateById(po);
    }

    /**
     * 新增数据库
     *
     * @param request 数据库实体
     * @return {@link boolean}
     * @author  一源团队-花和尚
     * @date 2023-08-25
     */
    @Override
    public boolean add(SysTableAddDTO request) throws Exception {
        SysTable po = new SysTable();
        BeanUtilsPlus.copy(request, po);
        return save(po);
    }
}
