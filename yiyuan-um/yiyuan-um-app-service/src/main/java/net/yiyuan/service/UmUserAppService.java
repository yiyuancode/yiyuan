package net.yiyuan.service;

import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmUserTokenDTO;
import net.yiyuan.model.UmUser;
import net.yiyuan.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 用户移动端Service层接口
 *
 * @author 小林同学
 * @date 2023-09-18
 */
public interface UmUserAppService extends JoinIService<UmUser> {

  UmUserTokenVO getUmUserToken(UmUserTokenDTO umUserTokenDto);

  GetUmUserInfoVO getUmUserInfo() throws Exception;

  MyselfIndexVO findMySelfIndexVO() throws Exception;

  Map<String, List<ProjectCollectReVO>> finProjectCollectListVO() throws Exception;

  Map<String, List<ProjectCollectReShopVO>> findProjectCollectListShopVO() throws Exception;
}
