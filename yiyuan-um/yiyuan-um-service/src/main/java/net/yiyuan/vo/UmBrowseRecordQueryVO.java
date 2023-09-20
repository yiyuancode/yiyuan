package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 浏览记录查询请求响应参数实体
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Data
public class UmBrowseRecordQueryVO implements Serializable {


    /**
     * @author 小林同学
     * @date 2023-09-19
     */
    private String id;


    /**
     * 用户id
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String uid;


    /**
     * 商品id
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String productId;


    /**
     * 日期：年-月-日
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String date;


    /**
     * 创建时间
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}