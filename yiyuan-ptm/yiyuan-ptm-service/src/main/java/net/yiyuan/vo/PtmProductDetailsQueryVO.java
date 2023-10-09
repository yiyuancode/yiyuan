package net.yiyuan.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品详情查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductDetailsQueryVO implements Serializable {


    /**
     * 商品id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String id;


    /**
     * 商户id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String tenantId;


    /**
     * 商品id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String ptmProductId;


    /**
     * 商品详情(富文本)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String details;


}