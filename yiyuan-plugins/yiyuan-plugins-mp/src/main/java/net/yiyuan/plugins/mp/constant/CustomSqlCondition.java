package net.yiyuan.plugins.mp.constant;

import com.baomidou.mybatisplus.annotation.SqlCondition;

public class CustomSqlCondition extends SqlCondition {

  /**
   * 大于
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String GET = "%s <![CDATA[ > ]]> #{%s} ";
  /**
   * 大于平等
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String GET_EQUAL = "%s <![CDATA[ >= ]]> #{%s}";

  /**
   * 小于
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String LT = "%s  <![CDATA[ < ]]> #{%s}";
  /**
   * 小于等于
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String LT_EQUAL = "%s <![CDATA[ <= ]]> #{%s}";
}
