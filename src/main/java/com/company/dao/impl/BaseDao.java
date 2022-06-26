package com.company.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.company.utils.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public abstract class BaseDao {

    private QueryRunner runner = new QueryRunner();

    private <T> ResultSetHandler<List<T>> getCustomHandler(Class<T> type) {
        return new ResultSetHandler<List<T>>() {

            @Override
            public List<T> handle(ResultSet rs) throws SQLException {

                List<T> list = new ArrayList<>();
                while (rs.next()) {

                    try {

                        T t = type.newInstance();
                        ResultSetMetaData md = rs.getMetaData();
                        int columnCount = md.getColumnCount();
                        for (int i = 0; i < columnCount; i++) {

                            Object value = rs.getObject(i + 1);
                            if (value instanceof LocalDateTime) {

                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                String time = simpleDateFormat.format(rs.getTimestamp(i + 1));
                                value = simpleDateFormat.parse(time);
                            }
                            String columnLabel = md.getColumnLabel(i + 1);
                            Field field = type.getDeclaredField(columnLabel);
                            field.setAccessible(true);
                            field.set(t, value);
                        }
                        list.add(t);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
                return list;
            }
        };
    }

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
            return runner.query(conn, sql, getCustomHandler(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }

        return null;
    }

    public <T> T queryForSingleValue(String sql, Object... params) {

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
