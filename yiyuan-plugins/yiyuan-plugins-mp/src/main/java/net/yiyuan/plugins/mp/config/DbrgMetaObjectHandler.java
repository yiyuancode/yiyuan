package net.yiyuan.plugins.mp.config;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DbrgMetaObjectHandler implements MetaObjectHandler {
  private static final String CREATE_USER_BY_FIELD_NAME = "createUser";
  private static final String CREATE_TIME_FIELD_NAME = "createTime";
  private static final String UPDATE_USER_BY_FIELD_NAME = "updateUser";
  private static final String UPDATE_TIME_FIELD_NAME = "updateTime";

  @Override
  public void insertFill(MetaObject metaObject) {
    try {
      boolean isLogin = StpUtil.isLogin();
      // 1、自动设置创建人信息,当外部接口调用时，用户可能为空
      if (isLogin) {
        String loginIdAsString = StpUtil.getLoginIdAsString();
        this.setFieldValByName(CREATE_USER_BY_FIELD_NAME, loginIdAsString, metaObject);
        this.setFieldValByName(UPDATE_USER_BY_FIELD_NAME, loginIdAsString, metaObject);
      }
      // 2、自动设置创建时间
      this.setFieldValByName(CREATE_TIME_FIELD_NAME, new Date(), metaObject);
      // 4、自动设置更新时间
      this.setFieldValByName(UPDATE_TIME_FIELD_NAME, new Date(), metaObject);
    } catch (Exception e) {
      if (e instanceof SaTokenException) {
        // 2、自动设置创建时间
        this.setFieldValByName(CREATE_TIME_FIELD_NAME, new Date(), metaObject);
        // 4、自动设置更新时间
        this.setFieldValByName(UPDATE_TIME_FIELD_NAME, new Date(), metaObject);
      }
    }
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    try {
      boolean isLogin = StpUtil.isLogin();
      // 1、自动设置更新人信息,当外部接口调用时，用户可能为空
      if (isLogin) {
        String loginIdAsString = StpUtil.getLoginIdAsString();
        this.setFieldValByName(UPDATE_USER_BY_FIELD_NAME, loginIdAsString, metaObject);
      }
      // 2、自动设置更新时间
      this.setFieldValByName(UPDATE_TIME_FIELD_NAME, new Date(), metaObject);
    } catch (Exception e) {
      if (e instanceof SaTokenException) {
        // 2、自动设置更新时间
        this.setFieldValByName(UPDATE_TIME_FIELD_NAME, new Date(), metaObject);
      }
    }
  }
}
