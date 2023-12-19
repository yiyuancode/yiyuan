package net.yiyuan.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 积分新增接口请求入参实体
 *
 * @author spring
 * @date 2023-12-19
 */
@Data
public class UmIntegralAddDTO implements Serializable {


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


}
