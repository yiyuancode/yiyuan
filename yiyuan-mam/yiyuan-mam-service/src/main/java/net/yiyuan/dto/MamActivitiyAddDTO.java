package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 营销活动新增接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class MamActivitiyAddDTO implements Serializable {


    /**
     * 商户id
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */


    @NotBlank(message = "商户id不能为空")


    private String tenantId;


    /**
     * 活动名称
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    @NotBlank(message = "活动名称不能为空")


    private String name;


    /**
     * 开始时间
     *
     * @mock CURRENT_TIMESTAMP
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */


    @NotNull(message = "开始时间不能为空")


    private Date startTime;


    /**
     * 结束时间
     *
     * @mock CURRENT_TIMESTAMP
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */


    @NotNull(message = "结束时间不能为空")


    private Date endTime;


}
