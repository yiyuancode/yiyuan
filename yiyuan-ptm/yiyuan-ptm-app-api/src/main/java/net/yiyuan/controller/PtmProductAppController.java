package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.dto.PtmProductGetPageListDTO;
import net.yiyuan.service.PtmProductAppService;
import net.yiyuan.vo.PtmProductQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品信息移动端接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品信息移动端接口
 */
@Slf4j
@RestController
public class PtmProductAppController {
  @Autowired private PtmProductAppService ptmProductAppService;

  /**
   * 商品分页查询
   *
   * @param request 商品分类实体
   * @return {@link CommonResult < List <PtmProductCategoryGetTreeVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @SaIgnore
  @GetMapping(value = "/ptm/product/getPageList")
  @ResponseBody
  public CommonResult<Page<PtmProductQueryVO>> getPageList(PtmProductGetPageListDTO request)
      throws Exception {
    return CommonResult.success(ptmProductAppService.getPageList(request), "查询商品分类列表成功");
  }
}
