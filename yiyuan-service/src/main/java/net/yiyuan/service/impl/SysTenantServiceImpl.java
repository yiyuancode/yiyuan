package net.yiyuan.service.impl;

import cn.dev33.satoken.util.SaFoxUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.*;
import net.yiyuan.mapper.AuthAdminMapper;
import net.yiyuan.mapper.SysTenantMapper;
import net.yiyuan.model.AuthAdmin;
import net.yiyuan.model.SysTenant;
import net.yiyuan.service.SysTenantService;
import net.yiyuan.vo.SysTenantQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 商户Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-09-08
 */
@Slf4j
@Service
public class SysTenantServiceImpl extends JoinServiceImpl<SysTenantMapper, SysTenant>
    implements SysTenantService {
  @Resource private SysTenantMapper sysTenantMapper;
  @Resource private AuthAdminMapper authAdminMapper;

  /**
   * 商户列表(全部)
   *
   * @param request 商户实体
   * @return {@link List< SysTenantQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public List<SysTenantQueryVO> list(SysTenantListDTO request) throws Exception {

    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    List<SysTenantQueryVO> voList = joinList(wrapper, SysTenantQueryVO.class);

    return voList;
  }

  /**
   * 商户列表(分页)
   *
   * @param request 商户实体
   * @return {@link Page< SysTenantQueryVO >}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public Page<SysTenantQueryVO> page(SysTenantPageDTO request) throws Exception {
    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    Page<SysTenantQueryVO> voPage =
        joinPage(
            new Page<>(request.getPageNum(), request.getPageSize()),
            wrapper,
            SysTenantQueryVO.class);
    return voPage;
  }

  /**
   * 商户详情
   *
   * @param id 商户id
   * @return {@link SysTenantQueryVO}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public SysTenantQueryVO details(String id) throws Exception {
    SysTenant po = new SysTenant();
    po.setId(id);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    SysTenantQueryVO voBean = joinGetOne(wrapper, SysTenantQueryVO.class);
    return voBean;
  }

  /**
   * 商户详情
   *
   * @param request 商户实体
   * @return {@link SysTenant}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public SysTenantQueryVO details(SysTenant request) throws Exception {

    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
    SysTenantQueryVO voBean = joinGetOne(wrapper, SysTenantQueryVO.class);
    return voBean;
  }

  /**
   * 删除商户(支持批量)
   *
   * @param ids 商户id(多个逗号分割)
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public boolean delete(String ids) throws Exception {
    return removeByIds(Arrays.asList(ids.split(",")));
  }

  /**
   * 编辑商户
   *
   * @param request 商户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public boolean edit(SysTenantEditDTO request) throws Exception {
    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    return updateById(po);
  }

  /**
   * 新增商户
   *
   * @param request 商户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public boolean add(SysTenantAddDTO request) throws Exception {
    SysTenant po = new SysTenant();
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  /**
   * 发起商户入驻申请
   *
   * @param request 商户实体
   * @return {@link boolean}
   * @author 一源团队-花和尚
   * @date 2023-09-08
   */
  @Override
  public boolean apply(SysTenantApplyDTO request) throws Exception {
    SysTenant po = new SysTenant();
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SysTenant::getName, request.getName());
    int count = joinCount(wrapper);
    if (count > 0) {
      throw new BusinessException("商户名称已存在");
    }
    wrapper.clear();
    wrapper.eq(SysTenant::getSocialCreditCode, request.getSocialCreditCode());
    count = joinCount(wrapper);
    if (count > 0) {
      throw new BusinessException("统一社会信用代码已存在");
    }
    wrapper.clear();
    wrapper.eq(SysTenant::getPhone, request.getPhone());
    count = joinCount(wrapper);
    if (count > 0) {
      throw new BusinessException("联系手机已存在");
    }
    wrapper.clear();
    wrapper.eq(SysTenant::getEmail, request.getEmail());
    count = joinCount(wrapper);
    if (count > 0) {
      throw new BusinessException("联系邮箱已存在");
    }
    // 校验通过,插入商户数据,状态默认为待审核
    BeanUtilsPlus.copy(request, po);
    return save(po);
  }

  @Override
  public boolean process(SysTenantProcessDTO request) throws Exception {
    SysTenant po = new SysTenant();
    // 如果是被驳回,只修改申请状态
    switch (request.getStatus()) {
      case REJECTED:
        BeanUtilsPlus.copy(request, po);
        sysTenantMapper.updateById(po);
        return true;
    }
    // 根据id
    JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(po);
    wrapper.eq(SysTenant::getId, request.getId());
    SysTenantQueryVO sysTenantQueryVO = joinGetOne(wrapper, SysTenantQueryVO.class);
    // 使用入驻申请的时候手机号和邮箱创建租户管理员账号
    AuthAdmin authAdminPO = new AuthAdmin();
    authAdminPO.setUsername(sysTenantQueryVO.getPhone());
    // 随机生成临时密码，并发送短信通知商户
    authAdminPO.setPassword(SaFoxUtil.getRandomString(8));
    // 设置商户id
    authAdminPO.setTenantId(sysTenantQueryVO.getId());
    authAdminMapper.insert(authAdminPO);
    return true;
  }
}
