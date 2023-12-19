package net.yiyuan.dto;

import lombok.*;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;


/**
 * 积分修改接口请求入参实体
 *
 * @author spring
 * @date 2023-12-19
 */
@Data
public class UmIntegralEditDTO implements Serializable {


    /**
     * @author spring
     * @date 2023-12-19
     */
    @NotBlank(message = "不能为空")
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


}