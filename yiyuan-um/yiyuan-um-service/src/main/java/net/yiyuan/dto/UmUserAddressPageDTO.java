package net.yiyuan.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.yiyuan.enums.UmUserAddressIsDefaultEnum;
import net.yiyuan.enums.UmUserAddressIsDelEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户地址分页接口请求入参实体
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Data
public class UmUserAddressPageDTO implements Serializable {
    /**
     * 分页条数
     *
     * @mock 10
     * @author 小林同学
     * @date 2023-09-19
     */
    @NotNull(message = "分页条数不能为空")
    private Integer pageSize = 10;
    /**
     * 分页页数
     *
     * @mock 1
     * @author 小林同学
     * @date 2023-09-19
     */
    @NotNull(message = "分页页数不能为空")
    private Integer pageNum= 1;


    /**
     * 用户地址id
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String id;


    /**
     * 用户id
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String uid;


    /**
     * 收货人姓名
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String name;


    /**
     * 收货人电话
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String phone;


    /**
     * 收货人所在省
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String province;


    /**
     * 省份ID
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private Integer provinceId;


    /**
     * 收货人所在市
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String city;


    /**
     * 城市id
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private Integer cityId;


    /**
     * 收货人所在区/县
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String district;


    /**
     * 区/县id
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private Integer districtId;


    /**
     * 收货人所在街道
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String street;


    /**
     * 收货人详细地址
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String detail;


    /**
     * 邮编
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private Integer postCode;


    /**
     * 地址经纬度
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private String location;


    /**
     * 是否默认 # 0=否|1=是
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private UmUserAddressIsDefaultEnum isDefault;


    /**
     * 是否删除 # 0=否|1=是
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    private UmUserAddressIsDelEnum isDel;


    /**
     * 创建时间(查询开始时间)
     *
     * @author 小林同学
     * @date 2023-09-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeStart;
    /**
     * 创建时间(查询结束时间)
     *
     * @author 小林同学
     * @date 2023-09-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTimeEnd;


    /**
     * 更新时间(查询开始时间)
     *
     * @author 小林同学
     * @date 2023-09-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeStart;
    /**
     * 更新时间(查询结束时间)
     *
     * @author 小林同学
     * @date 2023-09-19
     * @see Date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTimeEnd;


}
