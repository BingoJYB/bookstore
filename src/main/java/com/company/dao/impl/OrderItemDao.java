package com.company.dao.impl;

import java.sql.SQLException;

import com.company.dao.IOrderItemDao;
import com.company.entity.OrderItem;
import com.company.utils.JDBCUtils;

public class OrderItemDao extends BaseDao implements IOrderItemDao {

    public int saveOrderItem(OrderItem orderItem) {

        int statusCode = -1;
        String query = "INSERT INTO t_order_item (name, count, price, total_price, order_id) VALUES (?, ?, ?, ?, ?)";

        try {
            statusCode = update(query, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(),
                    orderItem.getTotalPrice(),
                    orderItem.getOrderId());

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;
    }
}
