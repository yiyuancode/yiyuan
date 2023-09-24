package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;

import net.yiyuan.service.UmProjectCollectAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 浏览记录移动端接口
 *
 * @author  小林同学
 * @date 2023-09-21
 * @folder 用户管理/浏览记录移动端接口
 */
@Slf4j
@RestController
public class UmProjectCollectAppController {
    @Autowired
    private UmProjectCollectAppService  umProjectCollectAppService;
}
