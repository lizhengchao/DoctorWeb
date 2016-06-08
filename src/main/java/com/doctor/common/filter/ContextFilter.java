package com.doctor.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lzc on 2016/5/14.
 */
public class ContextFilter implements Filter{
    @Override
    public void destroy() {
        System.out.println("ContextFilter destroy");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ContextFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println(((HttpServletRequest)servletRequest).getRequestURI());
//        System.out.println("ContextFilter doFilter");
        //http://heisetoufa.iteye.com/blog/227371
        //在filter中根据seesion过滤未登陆的用户

        filterChain.doFilter(servletRequest,servletResponse);
    }


}
