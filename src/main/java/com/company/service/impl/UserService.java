package com.company.service.impl;

import java.sql.SQLException;

import com.company.dao.impl.UserDao;
import com.company.entity.User;
import com.company.service.IUserService;

public class UserService implements IUserService {

    private final UserDao userDao = new UserDao();

    @Override
    public int registerUser(User user) throws SQLException {

        String username = user.getUsername();

        if (!isUsernameDuplicated(username)) {
            return userDao.saveUser(user);
        }

        return -1;
    }

    @Override
    public User login(String username, String password) throws SQLException {

        return userDao.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean isUsernameDuplicated(String username) throws SQLException {

        return userDao.getUserByUsername(username) != null;
    }

    @Override
    public void deregisterUser(User user) throws SQLException {

        String username = user.getUsername();

        if (userDao.getUserByUsername(username) != null) {
            userDao.deleteUser(user);
        }
    }

}
