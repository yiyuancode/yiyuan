package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 * 积分分页接口请求入参实体
 *
 * @author spring
 * @date 2023-12-19
 */
@Data
public class UmIntegralPageDTO implements Serializable {
    /**
     * 分页条数
     *
     * @mock 10
     * @author spring
     * @date 2023-12-19
     */
    @NotNull(message = "分页条数不能为空")
    private Integer pageSize = 10;
    /**
     * 分页页数
     *
     * @mock 1
     * @author spring
     * @date 2023-12-19
     */
    @NotNull(message = "分页页数不能为空")
    private Integer pageNum = 1;


    /**
     * @author spring
     * @date 2023-12-19
     */
    private String id;


    /**
     * 用户id
     *
     * @author spring
     * @date 2023-12-19
     */
    private String uid;


    /**
     * 积分
     *
     * @author spring
     * @date 2023-12-19
     */
    private Integer integral;


    /**
     * 类型
     *
     * @author spring
     * @date 2023-12-19
     */
    private String type;


    /**
     * (查询开始时间)
     *
     * @author spring
     * @date 2023-12-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeStart;
    /**
     * (查询结束时间)
     *
     * @author spring
     * @date 2023-12-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;


}
