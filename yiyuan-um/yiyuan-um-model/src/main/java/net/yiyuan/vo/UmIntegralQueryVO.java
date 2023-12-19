package net.yiyuan.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分查询请求响应参数实体
 *
 * @author spring
 * @date 2023-12-19
 */
@Data
public class UmIntegralQueryVO implements Serializable {


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
     * @author spring
     * @date 2023-12-19
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}