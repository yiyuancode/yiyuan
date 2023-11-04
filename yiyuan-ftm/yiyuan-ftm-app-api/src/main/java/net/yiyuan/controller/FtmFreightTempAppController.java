package net.yiyuan.controller;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.service.FtmFreightTempAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 物流模板移动端接口
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 * @folder 物流模块/物流模板移动端接口
 */
@Slf4j
@RestController
public class FtmFreightTempAppController {
  @Autowired private FtmFreightTempAppService ftmFreightTempAppService;
}
