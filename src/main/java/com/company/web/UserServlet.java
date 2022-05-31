package com.company.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.User;
import com.company.service.impl.UserService;

public class UserServlet extends BaseServlet {

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();

        User user = userService.login(username, password);

        if (user == null) {

            request.setAttribute("username", username);
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();

        User user = userService.login(username, password);

        if (user == null) {

            request.setAttribute("username", username);
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

}
