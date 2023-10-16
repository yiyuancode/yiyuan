package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.UmProjectCollectMapper;
import net.yiyuan.model.UmProjectCollect;
import net.yiyuan.service.UmProjectCollectAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 浏览记录移动端Service层接口实现
 *
 * @author 小林同学
 * @date 2023-09-21
 */
@Slf4j
@Service
public class UmProjectCollectAppServiceImpl
    extends JoinServiceImpl<UmProjectCollectMapper, UmProjectCollect>
    implements UmProjectCollectAppService {
  @Resource private UmProjectCollectMapper umProjectCollectMapper;
}
