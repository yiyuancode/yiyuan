package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.PtmProductAttrValueAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * 商品属性value移动端接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品属性value移动端接口
 */
@Slf4j
@RestController
public class PtmProductAttrValueAppController {
    @Autowired
    private PtmProductAttrValueAppService ptmProductAttrValueAppService;
}
