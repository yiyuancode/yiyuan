package net.yiyuan.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectCollectShopVO {
  /** 商店id */
  private String id;
  /** 商店头像 */
  private String shopImage;
  /** 商店星级 */
  private Integer star;
  /** 商品名称 */
  private String ShopName;
  /** 时间 */
  private Date date;
}
