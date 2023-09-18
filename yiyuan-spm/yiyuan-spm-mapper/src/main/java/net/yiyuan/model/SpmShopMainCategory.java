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
 *  店铺主营类目实体
 *
 * @author  一源-花和尚
 * @date 2023-09-18
 *
 */
@Data
public class SpmShopMainCategory implements Serializable{
private static final long serialVersionUID=1L;


        /**
     * 主营类目id
     *
     * @author 一源-花和尚
     * @date 2023-09-18
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    

    
        

        /**
         * 主营类目名称
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                                                private String name;
            

    
        

        /**
         * 主营类目手续费
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                                                private BigDecimal fee;
            

    
        

        /**
         * 排序
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                                                private Integer sort;
            

    
        

        /**
         * 显示状态#0=不显示|1=显示
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                                                private SpmShopMainCategoryIsShowEnum isShow;
            

    
        

        /**
         * 是否删除#0=未删除|1=已删除
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                                                private SpmShopMainCategoryIsDelEnum isDel;
            

    
                /**
         * 创建时间
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                        @TableField(fill = FieldFill.INSERT)
            
        private Date createTime;
        /**
         * 创建时间(查询开始时间)
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
        @TableField(value = "create_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
        private Date createTimeStart;
        /**
         * 创建时间(查询结束时间)
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
        @TableField(value = "create_time", condition = CustomSqlCondition.END_EQUAL, select = false)
        private Date createTimeEnd;
            

    
                /**
         * 修改时间
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                        @TableField(fill = FieldFill.INSERT_UPDATE)
            
        private Date updateTime;
        /**
         * 修改时间(查询开始时间)
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
        @TableField(value = "update_time ", condition = CustomSqlCondition.START_EQUAL, select = false)
        private Date updateTimeStart;
        /**
         * 修改时间(查询结束时间)
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
        @TableField(value = "update_time", condition = CustomSqlCondition.END_EQUAL, select = false)
        private Date updateTimeEnd;
            

    
        

        /**
         * 创建人
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                        @TableField(fill = FieldFill.INSERT)
                    private String createUser;
            

    
        

        /**
         * 修改人
         *
         * @author 一源-花和尚
         * @date 2023-09-18
         */
                        @TableField(fill = FieldFill.INSERT_UPDATE)
                    private String updateUser;
            




}
