package com.company.dao.impl;

import java.sql.SQLException;

import com.company.dao.IUserDao;
import com.company.entity.User;
import com.company.utils.JDBCUtils;

public class UserDao extends BaseDao implements IUserDao {

    public User getUserByUsername(String username) {

        User user = null;
        String query = "SELECT * FROM t_user WHERE username = ?";

        try {
            user = queryForOne(User.class, query, username);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) {

        User user = null;
        String query = "SELECT * FROM t_user WHERE username = ? AND password = ?";

        try {
            user = queryForOne(User.class, query, username, password);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return user;
    }

    public int saveUser(User user) {

        int statusCode = -1;
        String query = "INSERT INTO t_user (username, password, email) VALUES (?, ?, ?)";

        try {
            statusCode = update(query, user.getUsername(), user.getPassword(), user.getEmail());

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;
    }

    @Override
    public int deleteUser(User user) {

        int statusCode = -1;
        String query = "DELETE FROM t_user WHERE username = ?";

        try {
            statusCode = update(query, user.getUsername());

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;
    }

}
