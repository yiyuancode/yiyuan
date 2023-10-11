package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.PtmProductGetPageListDTO;
import net.yiyuan.model.PtmProduct;
import net.yiyuan.vo.PtmProductQueryVO;

/**
 * 商品信息移动端Service层接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
public interface PtmProductAppService extends JoinIService<PtmProduct> {

  public Page<PtmProductQueryVO> getPageList(PtmProductGetPageListDTO request) throws Exception;
}
