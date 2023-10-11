package net.yiyuan.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import lombok.extern.slf4j.Slf4j;
import net.yiyuan.common.model.vo.CommonResult;
import net.yiyuan.service.PtmProductCategoryAppService;
import net.yiyuan.vo.PtmProductCategoryGetTreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类移动端接口
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 * @folder 商品管理/商品分类移动端接口
 */
@Slf4j
@RestController
public class PtmProductCategoryAppController {
  @Autowired private PtmProductCategoryAppService ptmProductCategoryAppService;

  /**
   * 商品分类列表(全部)
   *
   * @param request 商品分类实体
   * @return {@link CommonResult < List <PtmProductCategoryGetTreeVO>>}
   * @author 一源团队-花和尚
   * @date 2023-10-09
   */
  @SaIgnore
  @GetMapping(value = "/ptm/productCategory/getTree")
  @ResponseBody
  public CommonResult<List<PtmProductCategoryGetTreeVO>> getTree() throws Exception {
    return CommonResult.success(ptmProductCategoryAppService.getTree(), "查询商品分类列表成功");
  }
}
