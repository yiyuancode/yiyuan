package net.yiyuan.dto;
import net.yiyuan.model.*;
import net.yiyuan.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;
import net.yiyuan.common.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 *  店铺主营类目分页接口请求入参实体
 *
 * @author  一源-花和尚
 * @date 2023-09-18
 *
 */
@Data
public class SpmShopMainCategoryPageDTO implements Serializable {
    /**
     * 分页条数
     *
     * @mock 10
     * @author 一源-花和尚
     * @date 2023-09-18
     */
    @NotNull(message = "分页条数不能为空")
    private Integer pageSize;
    /**
     * 分页页数
     *
     * @mock 1
     * @author 一源-花和尚
     * @date 2023-09-18
     */
    @NotNull(message = "分页页数不能为空")
    private Integer pageNum;
    

                    /**
             * 主营类目id
             *
             * @author 一源-花和尚
             * @date 2023-09-18
             */
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
             * 创建时间(查询开始时间)
             *
             * @see Date
             * @author 一源-花和尚
             * @date 2023-09-18
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date createTimeStart;
            /**
             * 创建时间(查询结束时间)
             *
             * @see Date
             * @author 一源-花和尚
             * @date 2023-09-18
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date createTimeEnd;

        



    

                    /**
             * 修改时间(查询开始时间)
             *
             * @see Date
             * @author 一源-花和尚
             * @date 2023-09-18
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date updateTimeStart;
            /**
             * 修改时间(查询结束时间)
             *
             * @see Date
             * @author 一源-花和尚
             * @date 2023-09-18
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date updateTimeEnd;

        



    

                    /**
             * 创建人
             *
             * @author 一源-花和尚
             * @date 2023-09-18
             */
            private String createUser;
        



    

                    /**
             * 修改人
             *
             * @author 一源-花和尚
             * @date 2023-09-18
             */
            private String updateUser;
        



    
}
