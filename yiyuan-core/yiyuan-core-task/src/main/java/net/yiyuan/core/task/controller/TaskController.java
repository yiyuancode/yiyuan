package net.yiyuan.core.task.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.task.model.add_task.AddTaskReq;
import net.yiyuan.core.task.service.TaskService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 定时任务管理
 *
 * @author 一源团队--花和尚
 * @date 2023-06-23
 * @module 定时任务管理模块
 * @folder 定时任务管理模块
 */
@Slf4j
@RestController
public class TaskController {
  @Resource TaskService taskService;
  /**
   * 添加定时任务
   *
   * @param request 用户实体
   * @return {@link CommonResult <Boolean>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/task/addTask", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Boolean> login(@RequestBody @Validated AddTaskReq request) throws Exception {
    return CommonResult.success(taskService.addTask(request));
  }
}
