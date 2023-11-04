package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.FtmFreightTempPriceMapper;
import net.yiyuan.model.FtmFreightTempPrice;
import net.yiyuan.service.FtmFreightTempPriceAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 物流模板价格移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-04
 */
@Slf4j
@Service
public class FtmFreightTempPriceAppServiceImpl
    extends JoinServiceImpl<FtmFreightTempPriceMapper, FtmFreightTempPrice>
    implements FtmFreightTempPriceAppService {
  @Resource private FtmFreightTempPriceMapper ftmFreightTempPriceMapper;
}
