package net.yiyuan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.exception.*;
import net.yiyuan.common.utils.BeanUtilsPlus;
import net.yiyuan.model.UmProjectCollect;
import net.yiyuan.mapper.UmProjectCollectMapper;

import  net.yiyuan.service.UmProjectCollectAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
/**
 * 浏览记录移动端Service层接口实现
 *
 * @author  小林同学
 * @date 2023-09-21
 */
@Slf4j
@Service
public class UmProjectCollectAppServiceImpl extends JoinServiceImpl
        <UmProjectCollectMapper, UmProjectCollect>
        implements UmProjectCollectAppService {
    @Resource
    private UmProjectCollectMapper umProjectCollectMapper;

}
