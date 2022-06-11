package com.company.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.User;
import com.company.service.impl.UserService;
import com.company.utils.WebUtils;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();

    void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username, password);

        if (user == null) {

            request.setAttribute("username", username);
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {

            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();

        WebUtils.mapParam2Bean(request, user);

        int returnCode = userService.registerUser(user);

        if (returnCode == -1) {

            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("msg", "用户名已存在");
            request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
        } else {

            request.getRequestDispatcher("/pages/user/register_success.jsp").forward(request, response);
        }
    }

}
