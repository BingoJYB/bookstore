package com.company.service;

import java.util.List;

import com.company.entity.Cart;
import com.company.entity.Order;

public interface IOrderService {
    public String createOrder(Cart cart, Integer userId);

    public List<Order> getMyOrders(Integer userId);
}
