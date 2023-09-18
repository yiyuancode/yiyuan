package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.SysTableAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库移动端接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 * @folder 系统管理/数据库移动端接口
 */
@Slf4j
@RestController
public class SysTableAppController {
  @Autowired private SysTableAppService sysTableAppService;
}
