package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * 积分列表接口请求入参实体
 *
 * @author spring
 * @date 2023-12-19
 */
@Data
public class UmIntegralListDTO implements Serializable {


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
     * 类型:1、签到积分
     *
     * @author spring
     * @date 2023-12-19
     */
    private Integer type;


    /**
     * 创建时间(查询开始时间)
     *
     * @author spring
     * @date 2023-12-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author spring
     * @date 2023-12-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;


}
