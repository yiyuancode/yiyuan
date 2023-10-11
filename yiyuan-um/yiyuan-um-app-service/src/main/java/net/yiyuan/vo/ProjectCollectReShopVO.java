package net.yiyuan.vo;

import lombok.Data;

@Data
public class ProjectCollectReShopVO {
    /**
     * 商店id
     */
    private String id;
    /**
     * 商店头像
     */
    private String shopImage;
    /**
     * 商店星级
     */
    private Integer star;
    /**
     * 商品名称
     */
    private String ShopName;
    /**
     * 时间
     */
    private String date;
}
