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
 *  浏览记录列表接口请求入参实体
 *
 * @author  小林同学
 * @date 2023-09-21
 *
 */
@Data
public class UmProjectCollectListDTO implements Serializable {

    
                    /**
             * 
             *
             * @author 小林同学
             * @date 2023-09-21
             */
            private String id;
        


    
                    /**
             * 用户id
             *
             * @author 小林同学
             * @date 2023-09-21
             */
            private String uid;
        


    
                    /**
             * 商品id
             *
             * @author 小林同学
             * @date 2023-09-21
             */
            private String productId;
        


    
                    /**
             * 日期：年-月-日
             *
             * @author 小林同学
             * @date 2023-09-21
             */
            private String date;
        


    
                    /**
             * 创建时间(查询开始时间)
             *
             * @see Date
             * @author 小林同学
             * @date 2023-09-21
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date createTimeStart;
            /**
             * 创建时间(查询结束时间)
             *
             * @see Date
             * @author 小林同学
             * @date 2023-09-21
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date createTimeEnd;

        


    
}
