package net.yiyuan.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *  商品分页接口请求入参实体
 *
 * @author  一源-花和尚
 * @date 2023-09-21
 *
 */
@Data
public class PtmProductPageDTO implements Serializable {
    /**
     * 分页条数
     *
     * @mock 10
     * @author 一源-花和尚
     * @date 2023-09-21
     */
    @NotNull(message = "分页条数不能为空")
    private Integer pageSize;
    /**
     * 分页页数
     *
     * @mock 1
     * @author 一源-花和尚
     * @date 2023-09-21
     */
    @NotNull(message = "分页页数不能为空")
    private Integer pageNum;
    

                    /**
             * 商品id
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String id;
        



    

                    /**
             * 商户id
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String tenantId;
        



    

                    /**
             * 商品图片
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String image;
        



    

                    /**
             * 展示图
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String flatPattern;
        



    

                    /**
             * 轮播图
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String sliderImage;
        



    

                    /**
             * 商品名称
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String name;
        



    

                    /**
             * 商品简介
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String title;
        



    

                    /**
             * 关键字,英文逗号拼接
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String keyword;
        



    

                    /**
             * 租户分类id(逗号拼接)
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String cateId;
        



    

                    /**
             * 品牌id
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String brandId;
        



    

                    /**
             * 平台分类id
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String categoryId;
        



    

                    /**
             * 保障服务ids(英文逗号拼接)
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String guaranteeIds;
                    /**
             * 单位名
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String unitName; price;
                    /**
             * 虚拟销量
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private Integer ficti; vipPrice;
                    /**
             * 浏览量
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
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
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private Integer tempId; stock;
                    /**
             * 排序
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private Short sort; cost;
                    /**
             * 总后台排序
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private Short rank;
                    /**
             * 状态#0=未上架|1=上架
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private PtmProductIsShowEnum isShow;
                    /**
             * 审核状态#0=无需审核|1=待审核|2=审核成功|3=审核拒绝
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private PtmProductAuditStatusEnum auditStatus;
                    /**
             * 是否加入审核#0=正常|1=审核流程中
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private PtmProductIsAuditEnum isAudit;
                    /**
             * 拒绝原因
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private String reasonContent;
                    /**
             * 是否删除#0=否|1=是
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private PtmProductIsDelEnum isDel;
                    /**
             * 创建时间
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private Timestamp createTime;
                    /**
             * 更新时间
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private Timestamp updateTime; specType;
        



    

                    /**
             * 商品价格
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType} isRecycle;
        



    

                    /**
             * 会员价格
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType} isSub;
        



    

/**
             * 市场价
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType}
        



    

/**
             * 销量
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType}
        



    

/**
             * 库存
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType}
        



    

/**
             * 成本价
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType}
        



    

/**
             * 规格 0单 1多
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType}
        



    

/**
             * 是否回收站
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType}
        



    

/**
             * 是否单独分佣
             *
             * @author 一源-花和尚
             * @date 2023-09-21
             */
            private ${columnsItem.propertyType}
        



    
}
