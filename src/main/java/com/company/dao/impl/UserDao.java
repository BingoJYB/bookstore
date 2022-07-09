package com.company.dao.impl;

import java.sql.SQLException;

import com.company.dao.IUserDao;
import com.company.entity.User;

public class UserDao extends BaseDao implements IUserDao {

    public User getUserByUsername(String username) throws SQLException {

        User user = null;
        String query = "SELECT * FROM t_user WHERE username = ?";

        user = queryForOne(User.class, query, username);

        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {

        User user = null;
        String query = "SELECT * FROM t_user WHERE username = ? AND password = ?";

        user = queryForOne(User.class, query, username, password);

        return user;
    }

    public int saveUser(User user) throws SQLException {

        int statusCode = -1;
        String query = "INSERT INTO t_user (username, password, email) VALUES (?, ?, ?)";

        statusCode = update(query, user.getUsername(), user.getPassword(), user.getEmail());

        return statusCode;
    }

    @Override
    public int deleteUser(User user) throws SQLException {

        int statusCode = -1;
        String query = "DELETE FROM t_user WHERE username = ?";

        statusCode = update(query, user.getUsername());

        return statusCode;
    }

}
