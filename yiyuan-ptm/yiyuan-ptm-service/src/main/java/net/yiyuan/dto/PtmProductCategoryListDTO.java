package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.PtmProductCategoryLevelEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类列表接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class PtmProductCategoryListDTO implements Serializable {


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
     * 商户id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String tenantId;


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
     * 分类级别#1=一级分类|2=二级分类|3=三级分类
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private PtmProductCategoryLevelEnum level;


    /**
     * 显示状态0=不显示|1=显示
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private Boolean isShow;


    /**
     * 创建时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;


    /**
     * 修改时间(查询开始时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeStart;
    /**
     * 修改时间(查询结束时间)
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeEnd;


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
