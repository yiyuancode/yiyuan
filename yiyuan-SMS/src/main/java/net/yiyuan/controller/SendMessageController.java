package net.yiyuan.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.service.AliyunSmsService;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@Api(tags = "用户发送信息相关API")
@Slf4j
@RestController
@RequestMapping("/api")
public class SendMessageController {

  @Resource
  private AliyunSmsService aliyunSmsService;

  /**
   * 获取短信验证码
   *
   * @param phone 手机号码
   */
  @Description("获取短信验证码")
  @GetMapping(value = "/aliyun/verify/sms")
  public CommonResult<String> verifySms(@RequestParam(name = "phone") String phone) {

    return aliyunSmsService.verifySms(phone);
  }


  /**
   * 短信验证码校验
   * @param codeId
   * @param code
   * @return
   */
  @Description("校验验证码")
  @GetMapping(value = "/aliyun/verify/check")
  public CommonResult<String> checkSmsCode(
          @RequestParam(name = "codeId") String codeId,
          @RequestParam(name = "code") String code
          ) {
    boolean b = aliyunSmsService.checkSmsCode(codeId, code);
      if (b){
        return CommonResult.success(null, "验证成功");
      }
    return CommonResult.failed("验证失败");
  }

}
