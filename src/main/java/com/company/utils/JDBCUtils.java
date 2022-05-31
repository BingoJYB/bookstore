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

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
