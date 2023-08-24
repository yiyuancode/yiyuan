package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysTenantInfoAddDTO;
import net.yiyuan.dto.SysTenantInfoEditDTO;
import net.yiyuan.dto.SysTenantInfoListDTO;
import net.yiyuan.dto.SysTenantInfoPageDTO;
import net.yiyuan.mapper.SysTenantInfoMapper;
import net.yiyuan.model.SysTenantInfo;
import net.yiyuan.service.SysTenantInfoService;
import net.yiyuan.vo.SysTenantInfoQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 租户信息Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Slf4j
@Service
public class SysTenantInfoServiceImpl extends JoinServiceImpl<SysTenantInfoMapper, SysTenantInfo>
    implements SysTenantInfoService {
  @Resource private SysTenantInfoMapper sysTenantInfoMapper;

  /**
   * 租户信息列表(全部)
   *
   * @param request 租户信息实体
   * @return {@link List< SysTenantInfoQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public List<SysTenantInfoQueryVO> list(SysTenantInfoListDTO request) throws Exception {

    SysTenantInfo po = new SysTenantInfo();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantInfo> wrapper = new JoinLambdaWrapper<>(po);
    List<SysTenantInfoQueryVO> voList = joinList(wrapper, SysTenantInfoQueryVO.class);

    return voList;
  }

  /**
   * 租户信息列表(分页)
   *
   * @param request 租户信息实体
   * @return {@link Page< SysTenantInfoQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public Page<SysTenantInfoQueryVO> page(SysTenantInfoPageDTO request) throws Exception {
    SysTenantInfo po = new SysTenantInfo();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantInfo> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysTenantInfoQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysTenantInfoQueryVO.class);
    return voPage;
  }

  /**
   * 租户信息详情
   *
   * @param id 租户信息id
   * @return {@link SysTenantInfoQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public SysTenantInfoQueryVO details(String id) throws Exception {
    SysTenantInfo po = new SysTenantInfo();
    po.setId(id);
    JoinLambdaWrapper<SysTenantInfo> wrapper = new JoinLambdaWrapper<>(po);
    SysTenantInfoQueryVO voBean = joinGetOne(wrapper, SysTenantInfoQueryVO.class);
    return voBean;
  }

  /**
   * 租户信息详情
   *
   * @param request 租户信息实体
   * @return {@link SysTenantInfo}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public SysTenantInfoQueryVO details(SysTenantInfo request) throws Exception {

    JoinLambdaWrapper<SysTenantInfo> wrapper = new JoinLambdaWrapper<>(request);
    SysTenantInfoQueryVO voBean = joinGetOne(wrapper, SysTenantInfoQueryVO.class);
    return voBean;
  }

  /**
   * 删除租户信息(支持批量)
   *
   * @param ids 租户信息id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑租户信息
   *
   * @param request 租户信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean edit(SysTenantInfoEditDTO request) throws Exception {
    SysTenantInfo po = new SysTenantInfo();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantInfo> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增租户信息
   *
   * @param request 租户信息实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean add(SysTenantInfoAddDTO request) throws Exception {
    SysTenantInfo po = new SysTenantInfo();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }
}
