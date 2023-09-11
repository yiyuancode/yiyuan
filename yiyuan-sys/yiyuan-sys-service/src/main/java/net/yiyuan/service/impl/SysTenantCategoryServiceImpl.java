package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.SysTenantCategoryAddDTO;
import net.yiyuan.dto.SysTenantCategoryEditDTO;
import net.yiyuan.dto.SysTenantCategoryListDTO;
import net.yiyuan.dto.SysTenantCategoryPageDTO;
import net.yiyuan.mapper.SysTenantCategoryMapper;
import net.yiyuan.model.SysTenantCategory;
import net.yiyuan.service.SysTenantCategoryService;
import net.yiyuan.vo.SysTenantCategoryQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 租户店铺分类Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-08-24
 */
@Slf4j
@Service
public class SysTenantCategoryServiceImpl
    extends JoinServiceImpl<SysTenantCategoryMapper, SysTenantCategory>
    implements SysTenantCategoryService {
  @Resource private SysTenantCategoryMapper sysTenantCategoryMapper;

  /**
   * 租户店铺分类列表(全部)
   *
   * @param request 租户店铺分类实体
   * @return {@link List< SysTenantCategoryQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public List<SysTenantCategoryQueryVO> list(SysTenantCategoryListDTO request) throws Exception {

    SysTenantCategory po = new SysTenantCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantCategory> wrapper = new JoinLambdaWrapper<>(po);
    List<SysTenantCategoryQueryVO> voList = joinList(wrapper, SysTenantCategoryQueryVO.class);

    return voList;
  }

  /**
   * 租户店铺分类列表(分页)
   *
   * @param request 租户店铺分类实体
   * @return {@link Page< SysTenantCategoryQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public Page<SysTenantCategoryQueryVO> page(SysTenantCategoryPageDTO request) throws Exception {
    SysTenantCategory po = new SysTenantCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantCategory> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysTenantCategoryQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysTenantCategoryQueryVO.class);
    return voPage;
  }

  /**
   * 租户店铺分类详情
   *
   * @param id 租户店铺分类id
   * @return {@link SysTenantCategoryQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public SysTenantCategoryQueryVO details(String id) throws Exception {
    SysTenantCategory po = new SysTenantCategory();
    po.setId(id);
    JoinLambdaWrapper<SysTenantCategory> wrapper = new JoinLambdaWrapper<>(po);
    SysTenantCategoryQueryVO voBean = joinGetOne(wrapper, SysTenantCategoryQueryVO.class);
    return voBean;
  }

  /**
   * 租户店铺分类详情
   *
   * @param request 租户店铺分类实体
   * @return {@link SysTenantCategory}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public SysTenantCategoryQueryVO details(SysTenantCategory request) throws Exception {

    JoinLambdaWrapper<SysTenantCategory> wrapper = new JoinLambdaWrapper<>(request);
    SysTenantCategoryQueryVO voBean = joinGetOne(wrapper, SysTenantCategoryQueryVO.class);
    return voBean;
  }

  /**
   * 删除租户店铺分类(支持批量)
   *
   * @param ids 租户店铺分类id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑租户店铺分类
   *
   * @param request 租户店铺分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean edit(SysTenantCategoryEditDTO request) throws Exception {
    SysTenantCategory po = new SysTenantCategory();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenantCategory> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增租户店铺分类
   *
   * @param request 租户店铺分类实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-08-24
   */
  @Override
  public boolean add(SysTenantCategoryAddDTO request) throws Exception {
    SysTenantCategory po = new SysTenantCategory();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }
}
