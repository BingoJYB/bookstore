package com.company.dao;

import java.util.List;

import com.company.entity.Order;

public interface IOrderDao {

    public int saveOrder(Order order);

    public List<Order> queryOrdersByUserId(Integer userId);

    public List<Order> queryOrders();

    public int changeOrderStatus(String id, Integer status);

}
