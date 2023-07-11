package net.yiyuan.core.sys.model;
import net.yiyuan.core.sys.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.*;
import net.yiyuan.common.*;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
    /**
 * 租户管理实体
 *
 * @author  一源团队--花和尚
 * @date 2023-07-11
 *
 */
@Data

public class SysTenant  implements Serializable{
private static final long serialVersionUID=1L;
                                                    
    /**
     * 租户id
     * @date 2023-07-11
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
                                
            private String id;
                                                    
                /**
     * 租户名称
     *
     * @see String
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    private String name;
                                                    
                /**
     * 租户编号
     *
     * @see String
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    private String code;
                                                    
            /**
     * 开始时间 DateTimeFormat//请求非body json时候  JsonFormat//请求为body json时候
     * @see Date
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date startTime;
                                                    
            /**
     * 结束时间 DateTimeFormat//请求非body json时候  JsonFormat//请求为body json时候
     * @see Date
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date endTime;
                                                    
            /**
     * 修改时间 DateTimeFormat//请求非body json时候  JsonFormat//请求为body json时候
     * @see Date
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date updatedTime;
                                                    
            /**
     * 创建时间 DateTimeFormat//请求非body json时候  JsonFormat//请求为body json时候
     * @see Date
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Date createdTime;
                                                    
                /**
     * 0正常 9-冻结
     *
     * @see String
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    private String status;
                                                    
                /**
     * 租户id
     *
     * @see String
     * @author  一源团队--花和尚
     * @date 2023-07-11
     */
    private String tenantId;
        }