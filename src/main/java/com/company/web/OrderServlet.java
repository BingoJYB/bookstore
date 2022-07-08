package com.company.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Cart;
import com.company.entity.Order;
import com.company.entity.OrderItem;
import com.company.entity.User;
import com.company.service.impl.OrderService;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderService();

    void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();
        String orderId = orderService.createOrder(cart, userId);

        cart.clearCart();

        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }

    void getMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();
        List<Order> orders = orderService.getMyOrders(userId);

        request.setAttribute("orderList", orders);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
    }

    void getAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orders = orderService.getAllOrder();

        request.setAttribute("orderList", orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
    }

    void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("orderId");

        int returnCode = orderService.sendOrder(id);

        if (returnCode != -1) {
            response.sendRedirect(request.getContextPath() + "/OrderServlet?method=getAllOrder");
        }
    }

    void accept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("orderId");

        int returnCode = orderService.accept(id);

        if (returnCode != -1) {
            response.sendRedirect(request.getContextPath() + "/OrderServlet?method=getMyOrder");
        }
    }

    void getOrderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("orderId");

        List<OrderItem> orderItems = orderService.getOrderDetails(id);

        request.setAttribute("orderItems", orderItems);
        request.getRequestDispatcher("/pages/order/orderdetails.jsp").forward(request, response);
    }

}
