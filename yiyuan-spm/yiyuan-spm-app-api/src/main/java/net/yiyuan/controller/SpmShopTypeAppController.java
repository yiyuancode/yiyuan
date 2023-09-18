package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.SpmShopTypeAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 店铺类型移动端接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 * @folder 店铺管理/店铺类型移动端接口
 */
@Slf4j
@RestController
public class SpmShopTypeAppController {
  @Autowired private SpmShopTypeAppService spmShopTypeAppService;
}
