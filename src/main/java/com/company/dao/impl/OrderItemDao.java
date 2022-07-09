package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.IOrderItemDao;
import com.company.entity.OrderItem;

public class OrderItemDao extends BaseDao implements IOrderItemDao {

    public int saveOrderItem(OrderItem orderItem) throws SQLException {

        int statusCode = -1;
        String query = "INSERT INTO t_order_item (name, count, price, total_price, order_id) VALUES (?, ?, ?, ?, ?)";

        statusCode = update(query, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(),
                orderItem.getTotalPrice(),
                orderItem.getOrderId());

        return statusCode;
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) throws SQLException {

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        String query = "SELECT id, name, count, price, total_price totalPrice FROM t_order_item WHERE order_id = ?";

        orderItems = queryForList(OrderItem.class, query, orderId);

        return orderItems;
    }

}
