package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.IOrderDao;
import com.company.entity.Order;
import com.company.utils.JDBCUtils;

public class OrderDao extends BaseDao implements IOrderDao {

    public int saveOrder(Order order) {

        int statusCode = -1;
        String query = "INSERT INTO t_order (id, create_time, price, status, user_id) VALUES (?, ?, ?, ?, ?)";

        try {
            statusCode = update(query, order.getId(), order.getCreateTime(), order.getPrice(), order.getStatus(),
                    order.getUserId());

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {

        List<Order> orders = new ArrayList<Order>();
        String query = "SELECT id, create_time createTime, price, status, user_id userId FROM t_order WHERE user_id = ?";

        try {
            orders = queryForList(Order.class, query, userId);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return orders;
    }

    @Override
    public List<Order> queryOrders() {

        List<Order> orders = new ArrayList<Order>();
        String query = "SELECT id, create_time createTime, price, status, user_id userId FROM t_order";

        try {
            orders = queryForList(Order.class, query);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return orders;
    }

    @Override
    public int changeOrderStatus(String id, Integer status) {

        int statusCode = -1;
        String query = "UPDATE t_order SET status = ? WHERE id = ?";

        try {
            statusCode = update(query, status, id);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;

    }

}
