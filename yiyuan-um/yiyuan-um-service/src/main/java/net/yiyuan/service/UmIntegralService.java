package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmIntegralAddDTO;
import net.yiyuan.dto.UmIntegralEditDTO;
import net.yiyuan.dto.UmIntegralListDTO;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.vo.UmIntegralQueryVO;

import java.util.List;

/**
 * 积分Service层接口
 *
 * @author  spring
 * @date 2023-12-19
 */
public interface UmIntegralService extends JoinIService
        <UmIntegral> {

    /**
     * 积分列表(全部)
     *
     * @param request 积分实体
     * @return {@link List< UmIntegralQueryVO >}
     * @author  spring
     * @date 2023-12-19
     */
    List
            <UmIntegralQueryVO> list(UmIntegralListDTO request) throws Exception;

    /**
     * 积分列表(分页)
     *
     * @param request 积分实体
     * @return {@link Page< UmIntegralQueryVO >}
     * @author  spring
     * @date 2023-12-19
     */
    Page
            <UmIntegralQueryVO> page(UmIntegralPageDTO request) throws Exception;

    /**
     * 积分详情
     *
     * @param id 积分id
     * @return {@link UmIntegralQueryVO}
     * @author  spring
     * @date 2023-12-19
     */
        UmIntegralQueryVO details(String id) throws Exception;

    /**
     * 积分详情
     *
     * @param request 积分实体
     * @return {@link UmIntegral}
     * @author  spring
     * @date 2023-12-19
     */
        UmIntegralQueryVO details(UmIntegral request) throws Exception;

    /**
     * 删除积分(支持批量)
     *
     * @param ids 积分id(多个逗号分割)
     * @return {@link boolean}
     * @author  spring
     * @date 2023-12-19
     */
    boolean delete(String ids) throws Exception;


    /**
     * 编辑积分
     *
     * @param request 积分实体
     * @return {@link boolean}
     * @author  spring
     * @date 2023-12-19
     */
    boolean edit(UmIntegralEditDTO request) throws Exception;

    /**
     * 新增积分
     *
     * @param request 积分实体
     * @return {@link boolean}
     * @author  spring
     * @date 2023-12-19
     */
    boolean add(UmIntegralAddDTO request) throws Exception;
}
