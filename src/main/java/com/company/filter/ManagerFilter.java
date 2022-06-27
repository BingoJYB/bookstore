package com.company.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.company.entity.User;

public class ManagerFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("Filter destroys");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        User user = (User) httpServletRequest.getSession().getAttribute("user");

        if (user == null || !user.getUsername().equals("admin")) {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("Filter initializes");

    }

}
