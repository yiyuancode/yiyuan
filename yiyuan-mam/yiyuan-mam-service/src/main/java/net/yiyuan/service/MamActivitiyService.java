package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.MamActivitiyAddDTO;
import net.yiyuan.dto.MamActivitiyEditDTO;
import net.yiyuan.dto.MamActivitiyListDTO;
import net.yiyuan.dto.MamActivitiyPageDTO;
import net.yiyuan.model.MamActivitiy;
import net.yiyuan.vo.MamActivitiyQueryVO;

import java.util.List;

/**
 * 营销活动Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface MamActivitiyService extends JoinIService
        <MamActivitiy> {

    /**
     * 营销活动列表(全部)
     *
     * @param request 营销活动实体
     * @return {@link List< MamActivitiyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    List
            <MamActivitiyQueryVO> list(MamActivitiyListDTO request) throws Exception;

    /**
     * 营销活动列表(分页)
     *
     * @param request 营销活动实体
     * @return {@link Page< MamActivitiyQueryVO >}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    Page
            <MamActivitiyQueryVO> page(MamActivitiyPageDTO request) throws Exception;

    /**
     * 营销活动详情
     *
     * @param id 营销活动id
     * @return {@link MamActivitiyQueryVO}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    MamActivitiyQueryVO details(String id) throws Exception;

    /**
     * 营销活动详情
     *
     * @param request 营销活动实体
     * @return {@link MamActivitiy}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    MamActivitiyQueryVO details(MamActivitiy request) throws Exception;

    /**
     * 删除营销活动(支持批量)
     *
     * @param ids 营销活动id(多个逗号分割)
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean delete(String ids) throws Exception;


    /**
     * 编辑营销活动
     *
     * @param request 营销活动实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean edit(MamActivitiyEditDTO request) throws Exception;

    /**
     * 新增营销活动
     *
     * @param request 营销活动实体
     * @return {@link boolean}
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    boolean add(MamActivitiyAddDTO request) throws Exception;
}
