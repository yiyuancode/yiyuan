package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.PtmProductAppService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 商品移动端接口
 *
 * @author 一源-花和尚
 * @date 2023-09-21
 * @folder 商品管理/商品移动端接口
 */
@Slf4j
@RestController
public class PtmProductAppController {
  @Autowired private PtmProductAppService ptmProductAppService;
}
