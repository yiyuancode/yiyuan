package net.yiyuan.plugins.satoken.exception;

import cn.dev33.satoken.exception.*;
import net.yiyuan.common.exception.BusinessException;
import net.yiyuan.common.model.vo.CommonResult;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author 一源团队-花和尚
 * @date 2023/06/23
 */
@RestControllerAdvice
public class GlobalException {

  /**
   * 处理有效异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public CommonResult handleValidException(MethodArgumentNotValidException e) {
    // 从异常对象中拿到ObjectError对象
    ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
    // 然后提取错误提示信息进行返回
    return CommonResult.failed(objectError.getDefaultMessage());
  }

  /**
   * 处理约束违反异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(value = ConstraintViolationException.class)
  public CommonResult handleConstraintViolationException(ConstraintViolationException e) {
    // 从异常对象中拿到ObjectError对象
    return CommonResult.failed(
        e.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toList())
            .get(0));
  }

  /**
   * 缺少权限异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(NotPermissionException.class)
  public CommonResult handlerException(NotPermissionException e) {
    e.printStackTrace();
    return CommonResult.failed("缺少权限：" + e.getPermission());
  }

  /**
   * 缺少角色异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(NotRoleException.class)
  public CommonResult handlerException(NotRoleException e) {
    e.printStackTrace();
    return CommonResult.failed("缺少角色：" + e.getRole());
  }

  /**
   * 二级认证校验失败异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(NotSafeException.class)
  public CommonResult handlerException(NotSafeException e) {
    e.printStackTrace();
    return CommonResult.failed("二级认证校验失败：" + e.getService());
  }

  /**
   * 拦截：服务封禁异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(DisableServiceException.class)
  public CommonResult handlerException(DisableServiceException e) {
    e.printStackTrace();
    return CommonResult.failed(
        "当前账号 "
            + e.getService()
            + " 服务已被封禁 (level="
            + e.getLevel()
            + ")："
            + e.getDisableTime()
            + "秒后解封");
  }

  /**
   * 拦截：Http Basic 校验失败异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(NotBasicAuthException.class)
  public CommonResult handlerException(NotBasicAuthException e) {
    e.printStackTrace();
    return CommonResult.failed(e.getMessage());
  }

  /**
   * 全局异常拦截（拦截项目中的NotLoginException异常）,细分未登录的场景
   *
   * @param nle 有nle
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(NotLoginException.class)
  public CommonResult handlerNotLoginException(NotLoginException nle) throws Exception {

    // 打印堆栈，以供调试
    nle.printStackTrace();
    // 判断场景值，定制化异常信息
    String message = "";
    if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
      message = "未提供token";
    } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
      message = "token无效";
    } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
      message = "token已过期";
    } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
      message = "token已被顶下线";
    } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
      message = "token已被踢下线";
    } else {
      message = "当前会话未登录";
    }
    // 返回给前端
    return CommonResult.failed(message);
  }

  @ExceptionHandler(BusinessException.class)
  public CommonResult handleBusinessException(BusinessException e) {
    e.printStackTrace();
    return CommonResult.failed(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  public CommonResult handleRuntimeException(RuntimeException e) {
    e.printStackTrace();
    return CommonResult.failed(e.getMessage());
  }

  /**
   * 拦截：Mp枚举参数不在界定范围之外的异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  //    @ExceptionHandler(BindException.class)
  //    public CommonResult handleIllegalArgumentException(BindException e) {
  //        e.printStackTrace();
  //        if(e.getMessage().indexOf("无法匹配对应的枚举类型")!=-1){
  //            String regex = "(无法匹配对应的枚举类型)";
  //            Pattern pattern = Pattern.compile(regex);
  //            Matcher matcher = pattern.matcher(e.getMessage());
  //            return CommonResult.failed(ResultCode.PARAMETER_TO_ENUM_ERROR);
  //        }
  //        return CommonResult.failed(e.getMessage());
  //    }
  @ExceptionHandler(BindException.class)
  public CommonResult handleBindException(BindException e) {
    List<ObjectError> errors = e.getAllErrors();
    StringBuilder errorMessage = new StringBuilder();
    for (ObjectError error : errors) {
      errorMessage.append(error.getDefaultMessage()).append("; ");
    }
    return CommonResult.failed(errorMessage.toString());
  }

  /**
   * 拦截：其它所有异常
   *
   * @param e e
   * @return {@link CommonResult }
   * @author 一源团队-花和尚
   * @date 2023/06/23
   */
  @ExceptionHandler(Exception.class)
  public CommonResult handlerException(Exception e) {
    e.printStackTrace();
    return CommonResult.failed(e.getMessage());
  }
}
