package net.yiyuan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.UmUserAddressAddDTO;
import net.yiyuan.dto.UmUserAddressEditDTO;
import net.yiyuan.dto.UmUserAddressListDTO;
import net.yiyuan.dto.UmUserAddressPageDTO;
import net.yiyuan.mapper.UmUserAddressMapper;
import net.yiyuan.model.UmUserAddress;
import net.yiyuan.service.UmUserAddressService;
import net.yiyuan.vo.UmUserAddressQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户地址Service层接口实现
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Slf4j
@Service
public class UmUserAddressServiceImpl extends JoinServiceImpl<UmUserAddressMapper, UmUserAddress>
    implements UmUserAddressService {
  @Resource private UmUserAddressMapper umUserAddressMapper;

  /**
   * 用户地址列表(全部)
   *
   * @param request 用户地址实体
   * @return {@link List< UmUserAddressQueryVO >}
   * @author 小林同学
   * @date 2023-09-19
   */
  @Override
  public List<UmUserAddressQueryVO> list(UmUserAddressListDTO request) throws Exception {
    String loginId = (String) StpUtil.getLoginId();
    request.setUid(loginId);
    UmUserAddress po = new UmUserAddress();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<UmUserAddress> wrapper = new JoinLambdaWrapper<>(po);
    List<UmUserAddressQueryVO> voList =
        umUserAddressMapper.joinSelectList(wrapper, UmUserAddressQueryVO.class);

    return voList;
  }

  /**
   * 用户地址列表(分页)
   *
   * @param request 用户地址实体
   * @return {@link Page< UmUserAddressQueryVO >}
   * @author 小林同学
   * @date 2023-09-19
   */
  @Override
  public Page<UmUserAddressQueryVO> page(UmUserAddressPageDTO request) throws Exception {
    String loginId = (String) StpUtil.getLoginId();
    request.setUid(loginId);
    UmUserAddress po = new UmUserAddress();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<UmUserAddress> wrapper = new JoinLambdaWrapper<>(po);
    Page<UmUserAddressQueryVO> voPage =
        umUserAddressMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            UmUserAddressQueryVO.class);
    return voPage;
  }

  /**
   * 用户地址详情
   *
   * @param id 用户地址id
   * @return {@link UmUserAddressQueryVO}
   * @author 小林同学
   * @date 2023-09-19
   */
  @Override
  public UmUserAddressQueryVO details(String id) throws Exception {
    UmUserAddress po = new UmUserAddress();
    po.setId(id);
    JoinLambdaWrapper<UmUserAddress> wrapper = new JoinLambdaWrapper<>(po);
    UmUserAddressQueryVO voBean =
        umUserAddressMapper.joinSelectOne(wrapper, UmUserAddressQueryVO.class);
    return voBean;
  }

  /**
   * 用户地址详情
   *
   * @param request 用户地址实体
   * @return {@link UmUserAddress}
   * @author 小林同学
   * @date 2023-09-19
   */
  @Override
  public UmUserAddressQueryVO details(UmUserAddress request) throws Exception {
    JoinLambdaWrapper<UmUserAddress> wrapper = new JoinLambdaWrapper<>(request);
    UmUserAddressQueryVO voBean =
        umUserAddressMapper.joinSelectOne(wrapper, UmUserAddressQueryVO.class);
    return voBean;
  }

  /**
   * 删除用户地址(支持批量)
   *
   * @param ids 用户地址id(多个逗号分割)
   * @return {@link boolean}
   * @author 小林同学
   * @date 2023-09-19
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = umUserAddressMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑用户地址
   *
   * @param request 用户地址实体
   * @return {@link boolean}
   * @author 小林同学
   * @date 2023-09-19
   */
  @Override
  public boolean edit(UmUserAddressEditDTO request) throws Exception {
    UmUserAddress po = new UmUserAddress();
    BeanUtilsPlus.copy(request, po);
    int i = umUserAddressMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增用户地址
   *
   * @param request 用户地址实体
   * @return {@link boolean}
   * @author 小林同学
   * @date 2023-09-19
   */
  @Override
  public boolean add(UmUserAddressAddDTO request) throws Exception {
    UmUserAddress po = new UmUserAddress();
    BeanUtilsPlus.copy(request, po);
    int i = umUserAddressMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
