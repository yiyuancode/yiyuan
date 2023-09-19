package net.yiyuan.dto;

import lombok.Data;
import net.yiyuan.enums.UmUserAddressIsDefaultEnum;
import net.yiyuan.enums.UmUserAddressIsDelEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户地址新增接口请求入参实体
 *
 * @author 小林同学
 * @date 2023-09-19
 */
@Data
public class UmUserAddressAddDTO implements Serializable {


    /**
     * 用户id
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "用户id不能为空")


    private String uid;


    /**
     * 收货人姓名
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "收货人姓名不能为空")


    private String name;


    /**
     * 收货人电话
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "收货人电话不能为空")


    private String phone;


    /**
     * 收货人所在省
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "收货人所在省不能为空")


    private String province;


    /**
     * 省份ID
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */


    @NotNull(message = "省份ID不能为空")


    private Integer provinceId;


    /**
     * 收货人所在市
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "收货人所在市不能为空")


    private String city;


    /**
     * 城市id
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */


    @NotNull(message = "城市id不能为空")


    private Integer cityId;


    /**
     * 收货人所在区/县
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "收货人所在区/县不能为空")


    private String district;


    /**
     * 区/县id
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */


    @NotNull(message = "区/县id不能为空")


    private Integer districtId;


    /**
     * 收货人所在街道
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "收货人所在街道不能为空")


    private String street;


    /**
     * 收货人详细地址
     *
     * @author 小林同学
     * @date 2023-09-19
     */

    @NotBlank(message = "收货人详细地址不能为空")


    private String detail;


    /**
     * 邮编
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */


    @NotNull(message = "邮编不能为空")


    private Integer postCode;


    /**
     * 地址经纬度
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */


    @NotBlank(message = "地址经纬度不能为空")


    private String location;


    /**
     * 是否默认 # 0=否|1=是
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */


    @NotNull(message = "是否默认 # 0=否|1=是不能为空")


    private UmUserAddressIsDefaultEnum isDefault;


    /**
     * 是否删除 # 0=否|1=是
     *
     * @mock 0
     * @author 小林同学
     * @date 2023-09-19
     */


    @NotNull(message = "是否删除 # 0=否|1=是不能为空")


    private UmUserAddressIsDelEnum isDel;


}
