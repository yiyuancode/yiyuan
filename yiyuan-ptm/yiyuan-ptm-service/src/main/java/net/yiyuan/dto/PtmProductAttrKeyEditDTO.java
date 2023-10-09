package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 商品属性key修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductAttrKeyEditDTO implements Serializable {


    /**
     * 商品属性key主键
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @NotBlank(message = "商品属性key主键不能为空")
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
     * 商品分类id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String ptmProductCategoryId;


    /**
     * 商品属性key
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String attrKey;


    /**
     * 是否显示0=否|1=是
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Boolean isShow;


}