package com.company.service;

import com.company.entity.Cart;

public interface IOrderService {
    public int createOrder(Cart cart, Integer userId);
}
