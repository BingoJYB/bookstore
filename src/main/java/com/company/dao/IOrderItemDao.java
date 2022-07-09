package com.company.dao;

import java.sql.SQLException;
import java.util.List;

import com.company.entity.OrderItem;

public interface IOrderItemDao {

    public int saveOrderItem(OrderItem orderItem) throws SQLException;

    public List<OrderItem> queryOrderItemsByOrderId(String orderId) throws SQLException;

}
