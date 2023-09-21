package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.PtmProductAuditStatusEnum;
import net.yiyuan.enums.PtmProductIsAuditEnum;
import net.yiyuan.enums.PtmProductIsDelEnum;
import net.yiyuan.enums.PtmProductIsShowEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *  商品新增接口请求入参实体
 *
 * @author  一源-花和尚
 * @date 2023-09-21
 *
 */
@Data
public class PtmProductAddDTO implements Serializable {

    
        



    
                                    /**
                 * 商户id
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
                
            
                                                        @NotBlank(message = "商户id不能为空")
                

            
        private String tenantId;

        



    
                                    /**
                 * 商品图片
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
            
                                                        @NotBlank(message = "商品图片不能为空")
                

            
        private String image;

        



    
                                    /**
                 * 展示图
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
            
                                                        @NotBlank(message = "展示图不能为空")
                

            
        private String flatPattern;

        



    
                                    /**
                 * 轮播图
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
            
                                                        @NotBlank(message = "轮播图不能为空")
                

            
        private String sliderImage;

        



    
                                    /**
                 * 商品名称
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
            
                                                        @NotBlank(message = "商品名称不能为空")
                

            
        private String name;

        



    
                                    /**
                 * 商品简介
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
            
                                                        @NotBlank(message = "商品简介不能为空")
                

            
        private String title;

        



    
                                    /**
                 * 关键字,英文逗号拼接
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
            
                                                        @NotBlank(message = "关键字,英文逗号拼接不能为空")
                

            
        private String keyword;

        



    
                                    /**
                 * 租户分类id(逗号拼接)
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
            
                                                        @NotBlank(message = "租户分类id(逗号拼接)不能为空")
                

            
        private String cateId;

        



    
                                    /**
                 * 品牌id
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
                
            
                                                        @NotBlank(message = "品牌id不能为空")
                

            
        private String brandId;

        



    
                                    /**
                 * 平台分类id
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
                
            
                                                        @NotBlank(message = "平台分类id不能为空")
                

            
        private String categoryId;

        



    
                                    /**
                 * 保障服务ids(英文逗号拼接)
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */
                
            
                                                        @NotBlank(message = "保障服务ids(英文逗号拼接)不能为空")
                

            
        private String guaranteeIds;
                                    /**
                 * 单位名
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */

                                                        @NotBlank(message = "单位名不能为空")



        private String unitName; price;
                                    /**
                 * 虚拟销量
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "虚拟销量不能为空")



        private Integer ficti; vipPrice;
                                    /**
                 * 浏览量
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "浏览量不能为空")



        private Integer browse; otPrice;
                                    /**
                 * 商品二维码地址(用户小程序海报)
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


        private String codePath;
                                    /**
                 * 主图视频链接
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


        private String videoLink; sales;
                                    /**
                 * 运费模板ID
                 *
                 * @mock 1
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "运费模板ID不能为空")



        private Integer tempId; stock;
                                    /**
                 * 排序
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "排序不能为空")



        private Short sort; cost;
                                    /**
                 * 总后台排序
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "总后台排序不能为空")



        private Short rank;
                                    /**
                 * 状态#0=未上架|1=上架
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "状态#0=未上架|1=上架不能为空")



        private PtmProductIsShowEnum isShow;
                                    /**
                 * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
                 *
                 * @mock 1
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝不能为空")



        private PtmProductAuditStatusEnum auditStatus;
                                    /**
                 * 是否加入审核#0=正常|1=审核流程中
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "是否加入审核#0=正常|1=审核流程中不能为空")



        private PtmProductIsAuditEnum isAudit;
                                    /**
                 * 拒绝原因
                 *
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */

                                                        @NotBlank(message = "拒绝原因不能为空")



        private String reasonContent;
                                    /**
                 * 是否删除#0=否|1=是
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "是否删除#0=否|1=是不能为空")



        private PtmProductIsDelEnum isDel;

        



    
/**
                 * 商品价格
                 *
                 * @mock 0.00
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "商品价格不能为空")



        private ${columnsItem.propertyType}

        



    
                                    /**
                 * 会员价格
                 *
                 * @mock 0.00
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "会员价格不能为空")



        private ${columnsItem.propertyType} specType;

        



    
                                    /**
                 * 市场价
                 *
                 * @mock 0.00
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "市场价不能为空")



        private ${columnsItem.propertyType} isRecycle;

        



    
                                    /**
                 * 销量
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "销量不能为空")



        private ${columnsItem.propertyType} isSub;

        



    
/**
                 * 库存
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "库存不能为空")



        private ${columnsItem.propertyType}

        



    
/**
                 * 成本价
                 *
                 * @mock 0.00
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "成本价不能为空")



        private ${columnsItem.propertyType}

        



    
/**
                 * 规格 0单 1多
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "规格 0单 1多不能为空")



        private ${columnsItem.propertyType}

        



    
/**
                 * 是否回收站
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "是否回收站不能为空")



        private ${columnsItem.propertyType}

        



    
/**
                 * 是否单独分佣
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-21
                 */


                                                        @NotNull(message = "是否单独分佣不能为空")



        private ${columnsItem.propertyType}

        



    
        



    
        



    
}
