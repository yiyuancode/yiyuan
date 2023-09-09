package net.yiyuan.admin.cofig.web;

import javax.servlet.*;
import java.io.IOException;

public class FontFilter implements Filter {

  /**
   * 初始化
   *
   * @param filterConfig
   * @throws ServletException
   */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  /**
   * 过滤器拦截
   *
   * @param servletRequest
   * @param servletResponse
   * @param filterChain
   * @throws IOException
   * @throws ServletException
   */
  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    filterChain.doFilter(servletRequest, servletResponse);
  }

  /** 销毁 */
  @Override
  public void destroy() {}
}
