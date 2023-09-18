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
 *  店铺主营类目修改接口请求入参实体
 *
 * @author  一源-花和尚
 * @date 2023-09-18
 *
 */
@Data
public class SpmShopMainCategoryEditDTO implements Serializable {

    
                    /**
             * 主营类目id
             *
             * @author 一源-花和尚
             * @date 2023-09-18
             */
            @NotBlank(message = "主营类目id不能为空")
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
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-18
                 */
                
                        private Integer sort;
        

    
                                    /**
                 * 显示状态#0=不显示|1=显示
                 *
                 * @mock 1
                 * @author 一源-花和尚
                 * @date 2023-09-18
                 */
                
                        private SpmShopMainCategoryIsShowEnum isShow;
        

    
                                    /**
                 * 是否删除#0=未删除|1=已删除
                 *
                 * @mock 0
                 * @author 一源-花和尚
                 * @date 2023-09-18
                 */
                
                        private SpmShopMainCategoryIsDelEnum isDel;
        

    
        

    
        

    
        

    
        

    
}