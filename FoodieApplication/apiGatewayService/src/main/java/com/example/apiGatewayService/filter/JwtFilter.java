package com.example.apiGatewayService.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse servletResponse = (HttpServletResponse) response;

        HttpServletRequest servletRequest = (HttpServletRequest) request;

        String authHeader = servletRequest.getHeader("authorization");

        if("OPTIONS".equals(servletRequest.getMethod()))
        {
            servletResponse.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(servletRequest,servletResponse);
        }
        else if (authHeader==null || !authHeader.startsWith("Bearer "))
        {
            throw new ServletException("Missing or Invalid");
        }
    }
}
