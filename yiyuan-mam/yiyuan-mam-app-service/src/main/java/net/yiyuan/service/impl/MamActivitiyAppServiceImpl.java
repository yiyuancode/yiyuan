package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import icu.mhb.mybatisplus.plugln.extend.Joins;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.mapper.MamActivitiyMapper;
import net.yiyuan.model.MamActivitiy;
import net.yiyuan.service.MamActivitiyAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 营销活动移动端Service层接口实现
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Slf4j
@Service
public class MamActivitiyAppServiceImpl extends JoinServiceImpl<MamActivitiyMapper, MamActivitiy>
    implements MamActivitiyAppService {
  @Resource private MamActivitiyMapper mamActivitiyMapper;

  @Override
  public List<MamActivitiy> getIndexList() throws Exception {
    JoinLambdaWrapper<MamActivitiy> wrapper = Joins.of(MamActivitiy.class);
    wrapper.select(MamActivitiy::getId, MamActivitiy::getName);
    wrapper.eq(MamActivitiy::getIsShow, true);
    wrapper.orderByDesc(MamActivitiy::getCreateTime);
    List<MamActivitiy> mamActivitiyList =
        mamActivitiyMapper.joinSelectList(wrapper, MamActivitiy.class);
    return mamActivitiyList;
  }
}
