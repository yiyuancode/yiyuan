package net.yiyuan.controller;
import cn.dev33.satoken.annotation.SaIgnore;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.service.ActiveEmailAndSmsService;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@Api(tags = "用户发送信息相关API")
@Slf4j
@RestController
public class SendMessageController {

  @Resource
  private ActiveEmailAndSmsService activeEmailAndSmsService;

  /**
   * 获取短信验证码
   *
   * @param phoneOrEmail 手机号码
   */
  @Description("获取短信验证码")
  @SaIgnore
  @GetMapping(value = "/api/aliyun/verify/sms")
  public CommonResult<String> verifySms(@RequestParam(name = "phoneOrEmail") String phoneOrEmail) throws Exception {

    return activeEmailAndSmsService.verifySms(phoneOrEmail);
  }


  /**
   * 短信验证码校验
   * @param codeId
   * @param code
   * @return
   */
  @Description("校验验证码")
  @SaIgnore
  @GetMapping(value = "/api/aliyun/verify/check")
  public CommonResult<String> checkSmsCode(
          @RequestParam(name = "codeId") String codeId,
          @RequestParam(name = "code") String code
          ) {
    boolean b = activeEmailAndSmsService.checkSmsCode(codeId, code);
      if (b){
        return CommonResult.success(null, "验证成功");
      }
    return CommonResult.failed("验证失败");
  }

}
