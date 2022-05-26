package com.company.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.company.utils.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public abstract class BaseDao {

    private QueryRunner runner = new QueryRunner();

    public int update(String sql, Object... args) {

        Connection conn = JDBCUtils.getConnection();

        try {
            return runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... params) {

        Connection conn = JDBCUtils.getConnection();

        try {
            return runner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... params) {

        Connection conn = JDBCUtils.getConnection();

        try {
            return runner.query(conn, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

        return null;
    }

    public <T> Object queryForSingleValue(String sql, Object... params) {

        Connection conn = JDBCUtils.getConnection();

        try {
            return runner.query(conn, sql, new ScalarHandler<T>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

        return null;
    }
}
