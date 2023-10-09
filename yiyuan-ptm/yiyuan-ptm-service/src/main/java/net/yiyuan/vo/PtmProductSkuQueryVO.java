package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品sku查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductSkuQueryVO implements Serializable {


    /**
     * 商品sku主键
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
     * 商品sku
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String sku;


    /**
     * 库存
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private Integer stock;


    /**
     * 售卖价格
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private BigDecimal salePrice;


    /**
     * 划线价格
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private BigDecimal crossedPrice;


    /**
     * 成本价
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private BigDecimal costPrice;


    /**
     * 是否显示0=否|1=是
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private Boolean isShow;


    /**
     * 创建时间
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    /**
     * 修改时间
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    /**
     * 创建人
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String createUser;


    /**
     * 修改人
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String updateUser;


}