package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmUserAddressAddDTO;
import net.yiyuan.dto.UmUserAddressEditDTO;
import net.yiyuan.dto.UmUserAddressListDTO;
import net.yiyuan.dto.UmUserAddressPageDTO;
import net.yiyuan.model.UmUserAddress;
import net.yiyuan.vo.UmUserAddressQueryVO;

import java.util.List;

/**
 * 用户地址移动端Service层接口
 *
 * @author 小林同学
 * @date 2023-09-19
 */
public interface UmUserAddressAppService extends JoinIService<UmUserAddress> {
    /**
     * 用户地址列表(全部)
     *
     * @param request 用户地址实体
     * @return {@link List <  UmUserAddressQueryVO  >}
     * @author 小林同学
     * @date 2023-09-19
     */
    List<UmUserAddressQueryVO> list(UmUserAddressListDTO request) throws Exception;

    /**
     * 用户地址列表(分页)
     *
     * @param request 用户地址实体
     * @return {@link Page < UmUserAddressQueryVO >}
     * @author 小林同学
     * @date 2023-09-19
     */
    Page<UmUserAddressQueryVO> page(UmUserAddressPageDTO request) throws Exception;

    /**
     * 用户地址详情
     *
     * @param id 用户地址id
     * @return {@link UmUserAddressQueryVO}
     * @author 小林同学
     * @date 2023-09-19
     */
    UmUserAddressQueryVO details(String id) throws Exception;

    /**
     * 用户地址详情
     *
     * @param request 用户地址实体
     * @return {@link UmUserAddress}
     * @author 小林同学
     * @date 2023-09-19
     */
    UmUserAddressQueryVO details(UmUserAddress request) throws Exception;

    /**
     * 删除用户地址(支持批量)
     *
     * @param ids 用户地址id(多个逗号分割)
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-19
     */
    boolean delete(String ids) throws Exception;

    /**
     * 编辑用户地址
     *
     * @param request 用户地址实体
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-19
     */
    boolean edit(UmUserAddressEditDTO request) throws Exception;

    /**
     * 新增用户地址
     *
     * @param request 用户地址实体
     * @return {@link boolean}
     * @author 小林同学
     * @date 2023-09-19
     */
    boolean add(UmUserAddressAddDTO request) throws Exception;
}
