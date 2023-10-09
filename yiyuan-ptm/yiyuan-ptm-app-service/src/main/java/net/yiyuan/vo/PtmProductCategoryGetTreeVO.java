package net.yiyuan.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品分类查询请求响应参数实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductCategoryGetTreeVO implements Serializable {


    /**
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String id;


    /**
     * 父级ID
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String pid;


    /**
     * 名称
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String name;


    /**
     * icon
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String icon;


    /**
     * 子集
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private List<PtmProductCategoryGetTreeVO> children;


}