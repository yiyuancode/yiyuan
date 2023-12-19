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
 *
 * @author spring
 * @date 2023-12-19
 */
@Data
public class UmIntegral implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * @author spring
     * @date 2023-12-19
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
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
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
