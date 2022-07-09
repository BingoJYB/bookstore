package com.company.dao;

import java.sql.SQLException;
import java.util.List;

import com.company.entity.Order;

public interface IOrderDao {

    public int saveOrder(Order order) throws SQLException;

    public List<Order> queryOrdersByUserId(Integer userId) throws SQLException;

    public List<Order> queryOrders() throws SQLException;

    public int changeOrderStatus(String id, Integer status) throws SQLException;

}
