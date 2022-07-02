package com.company.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static Properties props;
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            props = new Properties();
            props.load(JDBCUtils.class.getClassLoader().getResourceAsStream(Constants.BOOKSTORE_DB_PROPS));

            driver = props.getProperty("jdbc.driver");

            if (driver != null) {
                Class.forName(driver);
            }

            url = props.getProperty("jdbc.url");
            username = props.getProperty("jdbc.username");
            password = props.getProperty("jdbc.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private JDBCUtils() {

    }

    public static Connection getConnection() {

        Connection conn = conns.get();

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, username, password);
                conns.set(conn);
                conn.setAutoCommit(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close() {

        Connection conn = conns.get();

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commitAndClose() {

        Connection conn = conns.get();

        try {
            if (conn != null) {
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        conns.remove();
    }

    public static void rollbackAndClose() {

        Connection conn = conns.get();

        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        conns.remove();
    }

}
