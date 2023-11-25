package net.yiyuan.vo;

import lombok.Data;

@Data
public class MyselfIndexVO {
  /** 几颗星 保留字段 */
  private String star;
  /** 名称 */
  private String name;

  /** 头像 */
  private String head;
  /** 我的收藏 */
  private String myFavorite;
  /** 积分 */
  private String integral;
  /** 我的足迹 */
  private String myTracks;
  /** 我的卡卷 */
  private String myCars;
}
