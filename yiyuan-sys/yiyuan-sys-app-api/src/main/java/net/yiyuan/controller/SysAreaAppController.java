package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.service.SysAreaAppService;
import net.yiyuan.vo.SysAreaQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 行政区域移动端接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 * @folder 系统管理/行政区域移动端接口
 */
@Slf4j
@RestController
public class SysAreaAppController {
  @Autowired private SysAreaAppService sysAreaAppService;

  /**
   * 行政区域查询
   *
   * @return {@link CommonResult <List<SysAreaQueryVO>>}
   * @author ${author}
   * @date 2023-07-27
   */
  @GetMapping(value = "/sys/area/Query/{pid}")
  @ResponseBody
  @SaIgnore
  public CommonResult<List<SysAreaQueryVO>> getUmUserInfo(@PathVariable("pid")  String pid) throws Exception {
    return CommonResult.success(sysAreaAppService.getAreaTree(pid), "获取用户信息成功");
  }

}
