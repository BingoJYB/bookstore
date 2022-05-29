package com.company.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.User;
import com.company.service.impl.UserService;

public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        request.setAttribute("username", username);
        request.setAttribute("email", email);

        if (code == null) {

            request.setAttribute("msg", "验证码错误");
            request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
        } else {

            UserService userService = new UserService();
            User user = new User(null, username, password, email);

            if (userService.registerUser(user) == -1) {

                request.setAttribute("msg", "注册失败");
                request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
            } else {

                request.getRequestDispatcher("/pages/user/register_success.jsp").forward(request, response);
            }
        }
    }

}
