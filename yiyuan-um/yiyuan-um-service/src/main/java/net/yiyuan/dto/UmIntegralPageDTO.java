package net.yiyuan.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 积分记录接口请求入参实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmIntegralPageDTO implements Serializable {

    /**
     * 分页条数
     */
    @NotNull(message = "分页条数不能为空")
    private Integer pageSize = 10;

    /**
     * 分页页数
     */
    @NotNull(message = "分页页数不能为空")
    private Integer pageNum = 1;

    /**
     * 用户ID
     */
    private String uid;
    /**
     * 积分
     */
    private Integer integral;

    /**
     * 积分类型
     */
    private String type;


    /**
     * 积分获取时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
