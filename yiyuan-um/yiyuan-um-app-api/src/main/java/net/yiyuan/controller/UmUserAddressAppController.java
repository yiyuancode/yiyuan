package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.UmUserAddressAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户地址移动端接口
 *
 * @author 小林同学
 * @date 2023-09-19
 * @folder 用户管理/用户地址移动端接口
 */
@Slf4j
@RestController
public class UmUserAddressAppController {
  @Autowired private UmUserAddressAppService umUserAddressAppService;
}
