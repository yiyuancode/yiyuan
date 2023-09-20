package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.UmUserAddressIsDefaultEnum;
import net.yiyuan.enums.UmUserAddressIsDelEnum;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户地址修改接口请求入参实体
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Data
public class UmUserAddressEditDTO implements Serializable {


    /**
     * 用户地址id
     *
     * @author 小林同学
     * @date 2023-09-19
     */
    @NotBlank(message = "用户地址id不能为空")
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
     * @mock 0
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
     * @mock 0
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
     * @mock 0
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
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */

    private Integer postCode;


    /**
     * 地址经纬度
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */

    private String location;


    /**
     * 是否默认 # 0=否|1=是
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */

    private UmUserAddressIsDefaultEnum isDefault;


    /**
     * 是否删除 # 0=否|1=是
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */

    private UmUserAddressIsDelEnum isDel;


}