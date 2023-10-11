package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.UmProjectCollectAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * 浏览记录移动端接口
 *
 * @author 小林同学
 * @date 2023-09-21
 * @folder 用户管理/浏览记录移动端接口
 */
@Slf4j
@RestController
public class UmProjectCollectAppController {
    @Autowired
    private UmProjectCollectAppService umProjectCollectAppService;
}
