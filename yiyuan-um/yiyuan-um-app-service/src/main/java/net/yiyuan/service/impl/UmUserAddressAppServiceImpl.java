package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.UmUserAddressMapper;
import net.yiyuan.model.UmUserAddress;
import net.yiyuan.service.UmUserAddressAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户地址移动端Service层接口实现
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Slf4j
@Service
public class UmUserAddressAppServiceImpl extends JoinServiceImpl<UmUserAddressMapper, UmUserAddress>
    implements UmUserAddressAppService {
  @Resource private UmUserAddressMapper umUserAddressMapper;
}
