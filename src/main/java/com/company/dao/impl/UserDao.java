package com.company.dao.impl;

import com.company.dao.IUserDao;
import com.company.entity.User;

public class UserDao extends BaseDao implements IUserDao {

    public User getUserByUsername(String username) {

        String query = "SELECT * FROM t_user WHERE username = ?";

        return queryForOne(User.class, query, username);
    }

    public User getUserByUsernameAndPassword(String username, String password) {

        String query = "SELECT * FROM t_user WHERE username = ? AND password = ?";

        return queryForOne(User.class, query, username, password);
    }

    public int saveUser(User user) {

        String query = "INSERT INTO t_user (username, password, email) VALUES (?, ?, ?)";

        return update(query, user.getUsername(), user.getPassword(), user.getEmail());
    }

}
