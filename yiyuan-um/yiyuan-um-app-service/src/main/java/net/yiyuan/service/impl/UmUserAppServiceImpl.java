package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.UmUserMapper;
import net.yiyuan.model.UmUser;
import net.yiyuan.service.UmUserAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户移动端Service层接口实现
 *
 * @author 小林同学
 * @date 2023-09-18
 */
@Slf4j
@Service
public class UmUserAppServiceImpl extends JoinServiceImpl<UmUserMapper, UmUser>
    implements UmUserAppService {
  @Resource private UmUserMapper umUserMapper;
}
