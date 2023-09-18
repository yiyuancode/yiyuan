package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.*;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.model.SpmShopMainCategory;
import net.yiyuan.mapper.SpmShopMainCategoryMapper;

import  net.yiyuan.service.SpmShopMainCategoryAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 店铺主营类目移动端Service层接口实现
 *
 * @author  一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SpmShopMainCategoryAppServiceImpl extends JoinServiceImpl
        <SpmShopMainCategoryMapper, SpmShopMainCategory>
        implements SpmShopMainCategoryAppService {
    @Resource
    private SpmShopMainCategoryMapper spmShopMainCategoryMapper;

}
