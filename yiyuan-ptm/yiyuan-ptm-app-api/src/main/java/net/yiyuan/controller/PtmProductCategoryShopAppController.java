package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.PtmProductCategoryShopAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 店铺商品分类
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 * @folder 商品管理/店铺商品分类
 */
@Slf4j
@RestController
public class PtmProductCategoryShopAppController {
  @Autowired private PtmProductCategoryShopAppService ptmProductCategoryShopAppService;
}
