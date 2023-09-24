package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.PtmProductAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品移动端接口
 *
 * @author 一源-花和尚
 * @date 2023-09-22
 * @folder 商品管理/商品移动端接口
 */
@Slf4j
@RestController
public class PtmProductAppController {
    @Autowired
    private PtmProductAppService ptmProductAppService;
}
