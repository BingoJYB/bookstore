package com.company.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.User;
import com.company.service.impl.UserService;
import com.company.utils.JDBCUtils;
import com.company.utils.WebUtils;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();

    void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            user = userService.login(username, password);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

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

        String codeInSession = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        User user = new User();
        WebUtils.mapParam2Bean(request, user);

        String code = request.getParameter("code");

        if (code.equals(codeInSession)) {
            int returnCode = -1;

            try {
                returnCode = userService.registerUser(user);
                JDBCUtils.commitAndClose();
            } catch (SQLException e) {
                JDBCUtils.rollbackAndClose();
            }

            if (returnCode == -1) {
                request.setAttribute("username", request.getParameter("username"));
                request.setAttribute("email", request.getParameter("email"));
                request.setAttribute("msg", "用户名已存在");
                request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/pages/user/register_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("msg", "验证码不一致");
            request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
        }
    }

    void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().removeAttribute("user");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    void checkUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean isUsernameInvalid = false;
        String username = request.getParameter("username");

        try {
            isUsernameInvalid = userService.isUsernameDuplicated(username);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (isUsernameInvalid) {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("用户已存在!");
        }
    }

}
