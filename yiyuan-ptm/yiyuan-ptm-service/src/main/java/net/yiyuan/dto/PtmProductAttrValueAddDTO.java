package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品属性value新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductAttrValueAddDTO implements Serializable {


    /**
     * 商户id
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */


    @NotBlank(message = "商户id不能为空")


    private String tenantId;


    /**
     * 商品属性key表id
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */


    @NotBlank(message = "商品属性key表id不能为空")


    private String ptmProductAttrKeyId;


    /**
     * 商品属性value值
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */


    @NotBlank(message = "商品属性value值不能为空")


    private String attrValue;


}
