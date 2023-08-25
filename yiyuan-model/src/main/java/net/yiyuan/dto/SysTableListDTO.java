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
 *  数据库列表接口请求入参实体
 *
 * @author  一源团队-花和尚
 * @date 2023-08-25
 *
 */
@Data
public class SysTableListDTO implements Serializable {

    
                    /**
             * 主键id
             *
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
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
        


    
                    /**
             * 修改时间(查询开始时间)
             *
             * @see Date
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date updateTimeStart;
            /**
             * 修改时间(查询结束时间)
             *
             * @see Date
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date updateTimeEnd;

        


    
                    /**
             * 创建时间(查询开始时间)
             *
             * @see Date
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date createTimeStart;
            /**
             * 创建时间(查询结束时间)
             *
             * @see Date
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            private Date createTimeEnd;

        


    
                    /**
             * 创建人
             *
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
            private String createUser;
        


    
                    /**
             * 修改人
             *
             * @author 一源团队-花和尚
             * @date 2023-08-25
             */
            private String updateUser;
        


    
}
