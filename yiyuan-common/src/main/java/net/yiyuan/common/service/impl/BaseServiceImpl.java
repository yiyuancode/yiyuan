package net.yiyuan.common.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.mapper.JoinBaseMapper;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import net.yiyuan.common.service.IBaseService;

import java.util.List;

public class BaseServiceImpl<T, D, V, M extends JoinBaseMapper<T>> extends JoinServiceImpl<M, T>
    implements IBaseService<T, D, V> {

  @Override
  public List<V> list(D request) throws Exception {
    //    T po = getNewObject(T);
    //    BeanUtilsPlus.copy(request, po);
    //    JoinLambdaWrapper<AuthAdmin> wrapper = new JoinLambdaWrapper<>(po);
    //    joinRoleList(wrapper);
    //    Page<AuthAdminQueryVO> voPage =
    //        joinPage(
    //            new Page<>(request.getPageNum(), request.getPageSize()),
    //            wrapper,
    //            AuthAdminQueryVO.class);
    return null;
  }

  @Override
  public Page<V> page(D request) throws Exception {
    return null;
  }

  @Override
  public V details(String id) throws Exception {
    return null;
  }

  @Override
  public V details(T request) throws Exception {
    return null;
  }

  @Override
  public boolean delete(String ids) throws Exception {
    return false;
  }

  @Override
  public boolean delete(T request) throws Exception {
    return false;
  }

  @Override
  public boolean edit(D request) throws Exception {
    return false;
  }

  @Override
  public boolean add(D request) throws Exception {
    return false;
  }

  // newInstance() method need constructor without parameter
  // Class<T> come form Class.class
  public <T> T getNewObject(T t) {
    T t2 = null;
    try {
      t2 = (T) t.getClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return t2;
  }
}
