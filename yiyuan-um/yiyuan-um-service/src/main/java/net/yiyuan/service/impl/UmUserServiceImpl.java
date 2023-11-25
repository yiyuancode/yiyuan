package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.dto.UmUserAddDTO;
import net.yiyuan.dto.UmUserEditDTO;
import net.yiyuan.dto.UmUserListDTO;
import net.yiyuan.dto.UmUserPageDTO;
import net.yiyuan.mapper.UmUserMapper;
import net.yiyuan.model.UmUser;
import net.yiyuan.service.UmUserService;
import net.yiyuan.vo.UmUserQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户Service层接口实现
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Slf4j
@Service
public class UmUserServiceImpl extends JoinServiceImpl<UmUserMapper, UmUser>
    implements UmUserService {
  @Resource private UmUserMapper umUserMapper;

  /**
   * 用户列表(全部)
   *
   * @param request 用户实体
   * @return {@link List< UmUserQueryVO >}
   * @author 小林同学
   * @date 2023-09-18
   */
  @Override
  public List<UmUserQueryVO> list(UmUserListDTO request) throws Exception {

    UmUser po = new UmUser();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<UmUser> wrapper = new JoinLambdaWrapper<>(po);
    List<UmUserQueryVO> voList = umUserMapper.joinSelectList(wrapper, UmUserQueryVO.class);

    return voList;
  }

  /**
   * 用户列表(分页)
   *
   * @param request 用户实体
   * @return {@link Page< UmUserQueryVO >}
   * @author 小林同学
   * @date 2023-09-18
   */
  @Override
  public Page<UmUserQueryVO> page(UmUserPageDTO request) throws Exception {
    UmUser po = new UmUser();
    BeanUtilsPlus.copy(request, po);
    JoinLambdaWrapper<UmUser> wrapper = new JoinLambdaWrapper<>(po);
    Page<UmUserQueryVO> voPage =
        umUserMapper.joinSelectPage(
            new Page<>(request.getPageNum(), request.getPageSize()), wrapper, UmUserQueryVO.class);
    return voPage;
  }

  /**
   * 用户详情
   *
   * @param id 用户id
   * @return {@link UmUserQueryVO}
   * @author 小林同学
   * @date 2023-09-18
   */
  @Override
  public UmUserQueryVO details(String id) throws Exception {
    UmUser po = new UmUser();
    po.setId(id);
    JoinLambdaWrapper<UmUser> wrapper = new JoinLambdaWrapper<>(po);
    UmUserQueryVO voBean = umUserMapper.joinSelectOne(wrapper, UmUserQueryVO.class);
    return voBean;
  }

  /**
   * 用户详情
   *
   * @param request 用户实体
   * @return {@link UmUser}
   * @author 小林同学
   * @date 2023-09-18
   */
  @Override
  public UmUserQueryVO details(UmUser request) throws Exception {
    JoinLambdaWrapper<UmUser> wrapper = new JoinLambdaWrapper<>(request);
    UmUserQueryVO voBean = umUserMapper.joinSelectOne(wrapper, UmUserQueryVO.class);
    return voBean;
  }

  /**
   * 删除用户(支持批量)
   *
   * @param ids 用户id(多个逗号分割)
   * @return {@link boolean}
   * @author 小林同学
   * @date 2023-09-18
   */
  @Override
  public boolean delete(String ids) throws Exception {
    List<String> idList = Arrays.asList(ids.split(","));
    int i = umUserMapper.deleteBatchIds(idList);
    if (i == idList.size()) {
      return true;
    } else {
      throw new BusinessException("批量删除异常");
    }
  }

  /**
   * 编辑用户
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 小林同学
   * @date 2023-09-18
   */
  @Override
  public boolean edit(UmUserEditDTO request) throws Exception {
    UmUser po = new UmUser();
    BeanUtilsPlus.copy(request, po);
    int i = umUserMapper.updateById(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("修改异常");
    }
  }

  /**
   * 新增用户
   *
   * @param request 用户实体
   * @return {@link boolean}
   * @author 小林同学
   * @date 2023-09-18
   */
  @Override
  public boolean add(UmUserAddDTO request) throws Exception {
    UmUser po = new UmUser();
    BeanUtilsPlus.copy(request, po);
    int i = umUserMapper.insert(po);
    if (i != 0) {
      return true;
    } else {
      throw new BusinessException("新增异常");
    }
  }
}
