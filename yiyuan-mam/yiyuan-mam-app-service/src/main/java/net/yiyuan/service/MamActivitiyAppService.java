package net.yiyuan.service;

import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.model.MamActivitiy;

import java.util.List;

/**
 * 营销活动移动端Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface MamActivitiyAppService extends JoinIService<MamActivitiy> {

    public List<MamActivitiy> getIndexList() throws Exception;
}
