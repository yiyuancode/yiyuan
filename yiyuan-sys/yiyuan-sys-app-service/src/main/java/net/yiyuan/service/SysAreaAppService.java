package net.yiyuan.service;

import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.model.SysArea;
import net.yiyuan.vo.SysAreaQueryVO;

import java.util.List;

/**
 * 行政区域移动端Service层接口
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
public interface SysAreaAppService extends JoinIService<SysArea> {
    List<SysAreaQueryVO> getAreaTree(String pid) throws Exception;
}
