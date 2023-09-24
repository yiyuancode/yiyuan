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
 *  浏览记录修改接口请求入参实体
 *
 * @author  小林同学
 * @date 2023-09-21
 *
 */
@Data
public class UmProjectCollectEditDTO implements Serializable {

    
                    /**
             * 
             *
             * @author 小林同学
             * @date 2023-09-21
             */
            @NotBlank(message = "不能为空")
            private String id;
        

    
                                    /**
                 * 用户id
                 *
                 * @mock 0
                 * @author 小林同学
                 * @date 2023-09-21
                 */
                
                        private String uid;
        

    
                                    /**
                 * 商品id
                 *
                 * @mock 0
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
        

    
        

    
}