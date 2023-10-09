package net.yiyuan.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品详情列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductDetailsListDTO implements Serializable {


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
