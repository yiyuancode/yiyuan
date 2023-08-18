package net.yiyuan.common.constatnt;

public class CustomSqlCondition {
  public static final String EQUAL = "%s=#{%s}";
  public static final String NOT_EQUAL = "%s&lt;&gt;#{%s}";
  public static final String LIKE = "%s LIKE CONCAT('%%',#{%s},'%%')";
  public static final String ORACLE_LIKE = "%s LIKE CONCAT(CONCAT('%%',#{%s}),'%%')";
  public static final String LIKE_LEFT = "%s LIKE CONCAT('%%',#{%s})";
  public static final String LIKE_RIGHT = "%s LIKE CONCAT(#{%s},'%%')";
  /**
   * 大于
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String START = "%s <![CDATA[ > ]]> #{%s} ";
  /**
   * 大于平等
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String START_EQUAL = "%s <![CDATA[ >= ]]> #{%s}";

  /**
   * 小于
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String END = "%s  <![CDATA[ < ]]> #{%s}";
  /**
   * 小于等于
   *
   * @see String
   * @author 一源团队-花和尚
   * @date 2023/07/14
   */
  public static final String END_EQUAL = "%s <![CDATA[ <= ]]> #{%s}";
}
