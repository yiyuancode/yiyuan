package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.*;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.mapper.UmIntegralMapper;

import  net.yiyuan.service.UmIntegralAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 积分移动端Service层接口实现
 *
 * @author  spring
 * @date 2023-12-19
 */
@Slf4j
@Service
public class UmIntegralAppServiceImpl extends JoinServiceImpl
        <UmIntegralMapper, UmIntegral>
        implements UmIntegralAppService {
    @Resource
    private UmIntegralMapper umIntegralMapper;

}
