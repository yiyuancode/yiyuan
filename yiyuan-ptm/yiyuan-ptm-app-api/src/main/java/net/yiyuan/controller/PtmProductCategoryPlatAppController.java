package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.PtmProductCategoryPlatAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 平台商品分类
 *
 * @author 一源团队-花和尚
 * @date 2023-11-19
 * @folder 商品管理/平台商品分类
 */
@Slf4j
@RestController
public class PtmProductCategoryPlatAppController {
  @Autowired private PtmProductCategoryPlatAppService ptmProductCategoryPlatAppService;
}
