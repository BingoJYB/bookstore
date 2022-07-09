package com.company.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Cart;
import com.company.entity.Order;
import com.company.entity.OrderItem;
import com.company.entity.User;
import com.company.service.impl.OrderService;
import com.company.utils.JDBCUtils;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderService();

    void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();

        try {
            String orderId = orderService.createOrder(cart, userId);

            JDBCUtils.commitAndClose();

            cart.clearCart();

            request.getSession().setAttribute("orderId", orderId);
            response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }
    }

    void getMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();

        try {
            List<Order> orders = orderService.getMyOrders(userId);

            JDBCUtils.commitAndClose();

            request.setAttribute("orderList", orders);
            request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

    }

    void getAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Order> orders = orderService.getAllOrder();

            JDBCUtils.commitAndClose();

            request.setAttribute("orderList", orders);
            request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }
    }

    void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int returnCode = -1;
        String id = request.getParameter("orderId");

        try {
            returnCode = orderService.sendOrder(id);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (returnCode != -1) {
            response.sendRedirect(request.getContextPath() + "/OrderServlet?method=getAllOrder");
        }
    }

    void accept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int returnCode = -1;
        String id = request.getParameter("orderId");

        try {
            returnCode = orderService.accept(id);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (returnCode != -1) {
            response.sendRedirect(request.getContextPath() + "/OrderServlet?method=getMyOrder");
        }
    }

    void getOrderDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("orderId");

        try {
            List<OrderItem> orderItems = orderService.getOrderDetails(id);

            JDBCUtils.commitAndClose();

            request.setAttribute("orderItems", orderItems);
            request.getRequestDispatcher("/pages/order/orderdetails.jsp").forward(request, response);
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }
    }

}
