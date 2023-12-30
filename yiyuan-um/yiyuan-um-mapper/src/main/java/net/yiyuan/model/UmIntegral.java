package net.yiyuan.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分实体
 */
@Data
public class UmIntegral implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

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
