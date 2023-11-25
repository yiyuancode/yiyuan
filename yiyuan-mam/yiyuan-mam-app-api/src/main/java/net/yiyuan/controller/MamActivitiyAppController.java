package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.model.MamActivitiy;
import net.yiyuan.service.MamActivitiyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 营销活动移动端接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 营销管理/营销活动移动端接口
 */
@Slf4j
@RestController
public class MamActivitiyAppController {
  @Autowired private MamActivitiyAppService mamActivitiyAppService;

  /**
   * 查询活动列表(首页)
   *
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @SaIgnore
  @GetMapping(value = "/mam/activitiy/getIndexList")
  @ResponseBody
  public CommonResult<List<MamActivitiy>> getIndexList() throws Exception {
    return CommonResult.success(mamActivitiyAppService.getIndexList(), "查询营销活动列表成功");
  }
}
