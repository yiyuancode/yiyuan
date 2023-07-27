package net.yiyuan.core.sys.dto;

import lombok.Data;
import net.yiyuan.core.sys.enums.SysTenantStatusEnum;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 租户新增接口请求入参实体
 *
 * @author 一源团队--花和尚
 * @date 2023-07-27
 */
@Data
public class SysTenantAddDTO implements Serializable {


    /**
     * 租户名称
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */


    private String name;


    /**
     * 租户编号
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */


    private String code;


    /**
     * 开始时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */


    private Date startTime;


    /**
     * 结束时间
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */


    private Date endTime;


    /**
     * 状态#0=正常|1=冻结
     *
     * @mock 0
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */

    @NotNull(message = "状态#0=正常|1=冻结不能为空" )


    private SysTenantStatusEnum status;


    /**
     * 租户id
     *
     * @author 一源团队--花和尚
     * @date 2023-07-27
     */


    private String tenantId;


}
