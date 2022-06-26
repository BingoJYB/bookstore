package com.company.dao;

import java.util.List;

import com.company.entity.Order;

public interface IOrderDao {

    public int saveOrder(Order order);

    public List<Order> queryOrdersByUserId(Integer userId);

}
