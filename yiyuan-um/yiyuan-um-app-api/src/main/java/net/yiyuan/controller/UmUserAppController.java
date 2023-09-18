package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.UmUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户移动端接口
 *
 * @author 小林同学
 * @date 2023-09-18
 * @folder 用户管理/用户移动端接口
 */
@Slf4j
@RestController
public class UmUserAppController {
  @Autowired private UmUserAppService umUserAppService;
}
