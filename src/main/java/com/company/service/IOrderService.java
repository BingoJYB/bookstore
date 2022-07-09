package com.company.service;

import java.sql.SQLException;
import java.util.List;

import com.company.entity.Cart;
import com.company.entity.Order;
import com.company.entity.OrderItem;

public interface IOrderService {
    public String createOrder(Cart cart, Integer userId) throws SQLException;

    public List<Order> getMyOrders(Integer userId) throws SQLException;

    public List<Order> getAllOrder() throws SQLException;

    public int sendOrder(String id) throws SQLException;

    public int accept(String id) throws SQLException;

    public List<OrderItem> getOrderDetails(String id) throws SQLException;

}
