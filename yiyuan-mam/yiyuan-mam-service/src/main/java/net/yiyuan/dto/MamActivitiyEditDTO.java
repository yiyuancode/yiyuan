package net.yiyuan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 营销活动修改接口请求入参实体
 *
 * @author 一源团队-花和尚
 * @date 2023-10-09
 */
@Data
public class MamActivitiyEditDTO implements Serializable {


    /**
     * 活动id
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    @NotBlank(message = "活动id不能为空")
    private String id;


    /**
     * 商户id
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private String tenantId;


    /**
     * 活动名称
     *
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */
    private String name;


    /**
     * 开始时间
     *
     * @mock CURRENT_TIMESTAMP
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Date startTime;


    /**
     * 结束时间
     *
     * @mock CURRENT_TIMESTAMP
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Date endTime;


    /**
     * 是否显示0=否|1=是
     *
     * @mock 0
     * @author 一源团队-花和尚
     * @date 2023-10-09
     */

    private Boolean isShow;


}