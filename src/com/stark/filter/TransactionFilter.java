package com.stark.filter;

import com.stark.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * User: C.H.G
 * Date: 2021/8/17
 * Time: 下午6:16
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.transCommit();// 提交事务
        } catch (Exception e) {
            JdbcUtils.transRollback();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好的错误页面
        }
    }

    @Override
    public void destroy() {

    }
}
