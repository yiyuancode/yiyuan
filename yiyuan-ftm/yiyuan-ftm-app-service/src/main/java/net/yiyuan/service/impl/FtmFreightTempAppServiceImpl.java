package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.FtmFreightTempMapper;
import net.yiyuan.model.FtmFreightTemp;
import net.yiyuan.service.FtmFreightTempAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 物流模板移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Slf4j
@Service
public class FtmFreightTempAppServiceImpl
    extends JoinServiceImpl<FtmFreightTempMapper, FtmFreightTemp>
    implements FtmFreightTempAppService {
  @Resource private FtmFreightTempMapper ftmFreightTempMapper;
}
