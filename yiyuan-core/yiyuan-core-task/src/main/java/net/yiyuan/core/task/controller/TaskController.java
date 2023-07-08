package net.yiyuan.core.task.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.core.task.model.req.AddTaskReq;
import net.yiyuan.core.task.model.vo.TaskDeatilVo;
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
   * 查询定时任务详情
   *
   * @param request 用户实体
   * @return {@link CommonResult<TaskDeatilVo>}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/task/taskDeatil", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<TaskDeatilVo> taskDeatil(@RequestBody @Validated AddTaskReq request)
      throws Exception {
    return CommonResult.success(taskService.taskDeatil(request));
  }

  /**
   * 添加定时任务
   *
   * @param request 用户实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/task/addTask", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Boolean> addTask(@RequestBody @Validated AddTaskReq request)
      throws Exception {
    return CommonResult.success(taskService.addTask(request));
  }

  /**
   * 删除定时任务
   *
   * @param request 定时任务请求实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/task/delTask", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Boolean> delTask(@RequestBody @Validated AddTaskReq request)
      throws Exception {
    return CommonResult.success(taskService.delTask(request));
  }

  /**
   * 暂停定时任务
   *
   * @param request 定时任务请求实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/task/stopTask", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Boolean> stopTask(@RequestBody @Validated AddTaskReq request)
      throws Exception {
    return CommonResult.success(taskService.stopTask(request));
  }

  /**
   * 恢复定时任务
   *
   * @param request 定时任务请求实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/task/restartTask", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Boolean> restartTask(@RequestBody @Validated AddTaskReq request)
      throws Exception {
    return CommonResult.success(taskService.restartTask(request));
  }

  /**
   * 修改定时任务执行实践
   *
   * @param request 定时任务请求实体
   * @return {@link CommonResult}
   * @author 一源团队--花和尚
   * @date 2023-06-23
   */
  @SaIgnore
  @RequestMapping(value = "/task/editTaskCron", method = RequestMethod.POST)
  @ResponseBody
  public CommonResult<Boolean> editTaskCron(@RequestBody @Validated AddTaskReq request)
      throws Exception {
    return CommonResult.success(taskService.editTaskCron(request));
  }
}
