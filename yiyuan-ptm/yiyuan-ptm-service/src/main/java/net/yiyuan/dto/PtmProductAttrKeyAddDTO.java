package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品属性key新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductAttrKeyAddDTO implements Serializable {


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
     * 商品分类id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    @NotBlank(message = "商品分类id不能为空")


    private String ptmProductCategoryId;


    /**
     * 商品属性key
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    @NotBlank(message = "商品属性key不能为空")


    private String attrKey;


}
