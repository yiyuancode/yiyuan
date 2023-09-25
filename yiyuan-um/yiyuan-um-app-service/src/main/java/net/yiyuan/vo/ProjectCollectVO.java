package net.yiyuan.vo;

import lombok.Data;

@Data
public class ProjectCollectVO {
    /**
     * 商品id
     */
    private String id;
    /**
     * 商品图片
     */
    private String projectImage;
    /**
     * 商品名称
     */
    private String projectName;
    /**
     * 商店id
     */
    private String shopId;
    /**
     * 价格
     */
    private String price;

}
