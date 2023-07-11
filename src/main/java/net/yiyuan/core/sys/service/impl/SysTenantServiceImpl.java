package net.yiyuan.core.sys.service.impl;
import java.util.Date;
import net.yiyuan.core.sys.model.SysTenant;
import net.yiyuan.core.sys.model.SysTenant;
import net.yiyuan.core.sys.mapper.SysTenantMapper;
import net.yiyuan.core.sys.service.SysTenantService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import java.util.Arrays;
import net.yiyuan.common.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
/**
* 租户管理Service层接口实现
*
* @author  一源团队--花和尚
* @date 2023-07-11
*
*/
@Slf4j
@Service
public class SysTenantServiceImpl extends JoinServiceImpl<SysTenantMapper, SysTenant> implements SysTenantService {
@Resource
private SysTenantMapper sysTenantMapper;

/**
* 租户列表(全部)
*
* @param request 租户实体
* @return {@link List}
* @author  一源团队--花和尚
* @date 2023-07-11
*/
@Override
public List< SysTenant > list(SysTenant request)throws Exception{
SysTenant query=new SysTenant();
JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
return joinList(wrapper,SysTenant.class);
}


/**
* 租户列表(分页)
*
* @param request 租户实体
* @return {@link Page}
* @author  一源团队--花和尚
* @date 2023-07-11
*/
@Override
public Page< SysTenant > pages(SysTenant request, Integer pageSize, Integer pageNum)throws Exception{
SysTenant query=new SysTenant();
JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
wrapper.orderByDesc(SysTenant::getCreatedTime);

Page< SysTenant > page = joinPage(new Page<>(pageNum, pageSize), wrapper, SysTenant.class);
return page;
}


/**
* 租户详情
*
* @param id 租户id
* @return {@link SysTenant}
* @author  一源团队--花和尚
* @date 2023-07-11
*/
@Override
public SysTenant details(String id)throws Exception{
SysTenant query=new SysTenant();
query.setId(id);
JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(query);
return joinGetOne(wrapper,SysTenant.class);
}


/**
* 租户详情
*
* @param request 租户实体
* @return {@link SysTenant}
* @author  一源团队--花和尚
* @date 2023-07-11
*/
@Override
public SysTenant details(SysTenant request)throws Exception{
JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
return joinGetOne(wrapper,SysTenant.class);
}


/**
* 删除租户(支持批量)
*
* @param ids 租户id(多个逗号分割)
* @return {@link boolean}
* @author  一源团队--花和尚
* @date 2023-07-11
*/

@Override
public boolean delete(String ids) throws Exception{
return removeByIds(Arrays.asList(ids.split(",")));
}

/**
* 批量删除租户表(根据同一属性,针对中间表)
*
* @param request 租户实体
* @return {@link boolean}
* @author  一源团队--花和尚
* @date 2023-07-11
*/
@Override
public boolean delete(SysTenant request) throws Exception {
JoinLambdaWrapper<SysTenant> wrapper = new JoinLambdaWrapper<>(request);
return remove(wrapper);
}

/**
* 编辑租户表
*
* @param request 租户实体
* @return {@link boolean}
* @author  一源团队--花和尚
* @date 2023-07-11
*/

@Override
public boolean edit(SysTenant request)throws Exception{
request.setUpdatedTime(new Date());
return updateById(request);
}


/**
* 新增租户表
*
* @param request 租户实体
* @return {@link boolean}
* @author  一源团队--花和尚
* @date 2023-07-11
*/

@Override
public boolean add(SysTenant request)throws Exception{
request.setCreatedTime(new Date());
request.setUpdatedTime(new Date());
return save(request);
}
}

