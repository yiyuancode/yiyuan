package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.PtmProductGuaranteeMapper;
import net.yiyuan.model.PtmProductGuarantee;
import net.yiyuan.service.PtmProductGuaranteeAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 保障服务移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-11-09
 */
@Slf4j
@Service
public class PtmProductGuaranteeAppServiceImpl
    extends JoinServiceImpl<PtmProductGuaranteeMapper, PtmProductGuarantee>
    implements PtmProductGuaranteeAppService {
  @Resource private PtmProductGuaranteeMapper ptmProductGuaranteeMapper;
}
