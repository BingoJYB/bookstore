package com.company.dao.impl;

import com.company.dao.IOrderDao;
import com.company.entity.Order;
import com.company.entity.OrderItem;

public class OrderDao extends BaseDao implements IOrderDao {

    public int saveOrder(Order order) {

        String query = "INSERT INTO t_order (create_time, price, status, user_id) VALUES (?, ?, ?, ?)";

        return update(query, order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    public int saveOrderItem(OrderItem orderItem) {

        String query = "INSERT INTO t_order_item (name, count, price, total_price, order_id) VALUES (?, ?, ?, ?, ?)";

        return update(query, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(),
                orderItem.getOrderId());
    }
}
