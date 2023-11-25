package net.yiyuan.service.impl;

import icu.mhb.mybatisplus.plugln.base.service.impl.JoinServiceImpl;
import icu.mhb.mybatisplus.plugln.core.JoinLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.utils.StringUtilsPlus;
import net.yiyuan.enums.SysAreaLevelEnum;
import net.yiyuan.mapper.SysAreaMapper;
import net.yiyuan.model.SysArea;
import net.yiyuan.service.SysAreaAppService;
import net.yiyuan.vo.SysAreaQueryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 行政区域移动端Service层接口实现
 *
 * @author 一源-花和尚
 * @date 2023-09-18
 */
@Slf4j
@Service
public class SysAreaAppServiceImpl extends JoinServiceImpl<SysAreaMapper, SysArea>
    implements SysAreaAppService {
  @Resource private SysAreaMapper sysAreaMapper;

  @Override
  public List<SysAreaQueryVO> getAreaTree(String pid) throws Exception {

    JoinLambdaWrapper<SysArea> wrapper = new JoinLambdaWrapper<>(SysArea.class);
    if (StringUtilsPlus.isEmpty(pid)) {
      wrapper.eq(SysArea::getPid, "0");
    } else {
      wrapper.eq(SysArea::getPid, pid);
    }
    List<SysAreaQueryVO> spmShopCities =
            sysAreaMapper.joinSelectList(wrapper, SysAreaQueryVO.class);

    List<String> areaIdList = StringUtilsPlus.parseCodeToIds(pid);
    if (areaIdList.size() == SysAreaLevelEnum.FOURTH_LEVEL_CLASSIFICATION.getValue()) {
      spmShopCities.forEach(
              (item) -> {
                item.setIsLeaf(true);
              });
    }
    return spmShopCities;
  }
}
