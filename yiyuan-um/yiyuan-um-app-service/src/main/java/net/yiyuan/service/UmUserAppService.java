package net.yiyuan.service;

import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmUserTokenDTO;
import net.yiyuan.model.UmUser;
import net.yiyuan.vo.GetUmUserInfoVO;
import net.yiyuan.vo.MyselfIndexVO;
import net.yiyuan.vo.UmUserTokenVO;

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
}
