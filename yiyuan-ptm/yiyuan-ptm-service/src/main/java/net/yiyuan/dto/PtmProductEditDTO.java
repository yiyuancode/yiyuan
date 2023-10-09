package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductAuditStatusEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品信息修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductEditDTO implements Serializable {


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
     * 主类目id(商品分类2级id，逗号拼接)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String tenantCategoryId;


    /**
     * 店铺内部分类id(商品分类3级)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String shopCategoryId;


    /**
     * 品牌id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String brandId;


    /**
     * 保障服务ids(英文逗号拼接)
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private String guaranteeIds;


    /**
     * 运费模板ID
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String tempId;


    /**
     * 商品橱窗图片
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String image;


    /**
     * 详情图(多个逗号分割)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String sliderImage;


    /**
     * 详情视频链接
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String videoLink;


    /**
     * 商品名称
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String name;


    /**
     * 商品简介
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String title;


    /**
     * 关键字,英文逗号拼接
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String keyword;


    /**
     * 库存(根据sku所有累计库存自动设置)
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Integer stock;


    /**
     * 售卖价格(根据sku最低售卖价格自动设置)
     *
     * @mock 0.00
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private BigDecimal salePrice;


    /**
     * 划线价格(根据sku最低划线价格自动设置)
     *
     * @mock 0.00
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private BigDecimal crossedPrice;


    /**
     * 成本价(根据sku最低成本价自动设置)
     *
     * @mock 0.00
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private BigDecimal costPrice;


    /**
     * 单位名
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String unitName;


    /**
     * 实际销量
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Integer sales;


    /**
     * 虚拟销量(如果为默认值前端展示实际销量,反之展示虚拟销量)
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Integer fictiSales;


    /**
     * 浏览量
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Integer browse;


    /**
     * 商品二维码地址(用户小程序海报)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String codePath;


    /**
     * 总后台排序
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Integer tenantSort;


    /**
     * 是否单规格0=单|1=多
     *
     * @mock 1
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Boolean isSpecType;


    /**
     * 是否放入回收站0=否|1=是
     *
     * @mock 1
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Boolean isRecycle;


    /**
     * 是否单独分佣0=否|1=是
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Boolean isSub;


    /**
     * 是否加入审核0=否|1=是
     *
     * @mock 1
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Boolean isAudit;


    /**
     * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
     *
     * @mock 1
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private PtmProductAuditStatusEnum auditStatus;


    /**
     * 拒绝原因
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String reasonContent;


    /**
     * 排序
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Integer sort;


    /**
     * 是否上架0=否|1=是
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Boolean isShow;


}