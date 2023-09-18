package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;

import net.yiyuan.service.SpmShopMainCategoryAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * 店铺主营类目移动端接口
 *
 * @author  一源-花和尚
 * @date 2023-09-18
 * @folder 店铺管理/店铺主营类目移动端接口
 */
@Slf4j
@RestController
public class SpmShopMainCategoryAppController {
    @Autowired
    private SpmShopMainCategoryAppService  spmShopMainCategoryAppService;
}
