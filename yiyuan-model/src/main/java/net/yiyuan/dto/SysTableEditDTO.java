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
 *  数据库修改接口请求入参实体
 *
 * @author  一源团队-花和尚
 * @date 2023-08-25
 *
 */
@Data
public class SysTableEditDTO implements Serializable {

    
                    /**
             * 主键id
             *
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
            @NotBlank(message = "主键id不能为空")
            private String id;
        

    
                                    /**
                 * 表名
                 *
                 * @author 一源团队-花和尚
                 * @date 2023-08-25
                 */
                        private String name;
        

    
                                    /**
                 * 表注释
                 *
                 * @author 一源团队-花和尚
                 * @date 2023-08-25
                 */
                        private String remark;
        

    
        

    
        

    
        

    
        

    
}