package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.PtmProductBrandAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 品牌移动端接口
 *
 * @author 一源-花和尚
 * @date 2023-10-06
 * @folder 商品管理/品牌移动端接口
 */
@Slf4j
@RestController
public class PtmProductBrandAppController {
  @Autowired private PtmProductBrandAppService ptmProductBrandAppService;
}
