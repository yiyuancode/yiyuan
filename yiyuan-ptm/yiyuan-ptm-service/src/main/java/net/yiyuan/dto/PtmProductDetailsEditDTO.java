package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品详情修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductDetailsEditDTO implements Serializable {


    /**
     * 商品id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @NotBlank(message = "商品id不能为空")
    private String id;


    /**
     * 商户id
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private String tenantId;


    /**
     * 商品id
     *
     * @mock 0
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