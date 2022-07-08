package com.company.service;

import java.util.List;

import com.company.entity.Cart;
import com.company.entity.Order;
import com.company.entity.OrderItem;

public interface IOrderService {
    public String createOrder(Cart cart, Integer userId);

    public List<Order> getMyOrders(Integer userId);

    public List<Order> getAllOrder();

    public int sendOrder(String id);

    public int accept(String id);

    public List<OrderItem> getOrderDetails(String id);

}
