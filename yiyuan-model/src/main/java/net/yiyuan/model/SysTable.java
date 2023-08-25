package net.yiyuan.model;
import net.yiyuan.enums.*;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import net.yiyuan.common.constatnt.CustomSqlCondition;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
/**
 *  数据库实体
 *
 * @author  一源团队-花和尚
 * @date 2023-08-25
 *
 */
@Data
public class SysTable implements Serializable{
private static final long serialVersionUID=1L;


        /**
     * 主键id
     *
     * @author 一源团队-花和尚
     * @date 2023-08-25
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    

    
        

        /**
         * 表名
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
                        @TableField(condition = CustomSqlCondition.LIKE)
                    private String name;
            

    
        

        /**
         * 表注释
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
                        @TableField(condition = CustomSqlCondition.LIKE)
                    private String remark;
            

    
                /**
         * 修改时间
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
                        @TableField(fill = FieldFill.INSERT_UPDATE)
            
        private Date updateTime;
        /**
         * 修改时间(查询开始时间)
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
        @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
        private Date updateTimeStart;
        /**
         * 修改时间(查询结束时间)
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
        @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
        private Date updateTimeEnd;
            

    
                /**
         * 创建时间
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
                        @TableField(fill = FieldFill.INSERT)
            
        private Date createTime;
        /**
         * 创建时间(查询开始时间)
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
        @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
        private Date createTimeStart;
        /**
         * 创建时间(查询结束时间)
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
        @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
        private Date createTimeEnd;
            

    
        

        /**
         * 创建人
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
                        @TableField(fill = FieldFill.INSERT)
                    private String createUser;
            

    
        

        /**
         * 修改人
         *
         * @author 一源团队-花和尚
         * @date 2023-08-25
         */
                        @TableField(fill = FieldFill.INSERT_UPDATE)
                    private String updateUser;
            




}
