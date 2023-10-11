package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 浏览记录分页接口请求入参实体
 *
 * @author 小林同学
 * @date 2023-09-21
 */
@Data
public class UmProjectCollectPageDTO implements Serializable {
    /**
     * 分页条数
     *
     * @mock 10
     * @author 小林同学
     * @date 2023-09-21
     */
    @NotNull(message = "分页条数不能为空")
    private Integer pageSize;
    /**
     * 分页页数
     *
     * @mock 1
     * @author 小林同学
     * @date 2023-09-21
     */
    @NotNull(message = "分页页数不能为空")
    private Integer pageNum;


    /**
     * @author 小林同学
     * @date 2023-09-21
     */
    private String id;


    /**
     * 用户id
     *
     * @author 小林同学
     * @date 2023-09-21
     */
    private String uid;


    /**
     * 商品id
     *
     * @author 小林同学
     * @date 2023-09-21
     */
    private String productId;


    /**
     * 日期：年-月-日
     *
     * @author 小林同学
     * @date 2023-09-21
     */
    private String date;


    /**
     * 创建时间(查询开始时间)
     *
     * @author 小林同学
     * @date 2023-09-21
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 小林同学
     * @date 2023-09-21
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;


}
