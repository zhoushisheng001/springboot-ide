package com.zhuguang.zhou.file;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new MyHttpServeletRequest((HttpServletRequest)servletRequest,(HttpServletResponse)servletResponse),servletResponse);
    }

    @Override
    public void destroy() {

    }
}
