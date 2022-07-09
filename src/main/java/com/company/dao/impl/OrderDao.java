package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.IOrderDao;
import com.company.entity.Order;

public class OrderDao extends BaseDao implements IOrderDao {

    public int saveOrder(Order order) throws SQLException {

        int statusCode = -1;
        String query = "INSERT INTO t_order (id, create_time, price, status, user_id) VALUES (?, ?, ?, ?, ?)";

        statusCode = update(query, order.getId(), order.getCreateTime(), order.getPrice(), order.getStatus(),
                order.getUserId());

        return statusCode;
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) throws SQLException {

        List<Order> orders = new ArrayList<Order>();
        String query = "SELECT id, create_time createTime, price, status, user_id userId FROM t_order WHERE user_id = ?";

        orders = queryForList(Order.class, query, userId);

        return orders;
    }

    @Override
    public List<Order> queryOrders() throws SQLException {

        List<Order> orders = new ArrayList<Order>();
        String query = "SELECT id, create_time createTime, price, status, user_id userId FROM t_order";

        orders = queryForList(Order.class, query);

        return orders;
    }

    @Override
    public int changeOrderStatus(String id, Integer status) throws SQLException {

        int statusCode = -1;
        String query = "UPDATE t_order SET status = ? WHERE id = ?";

        statusCode = update(query, status, id);

        return statusCode;

    }

}
