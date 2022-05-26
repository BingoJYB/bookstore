package com.company.service.impl;

import com.company.dao.impl.UserDao;
import com.company.entity.User;
import com.company.service.IUserService;

public class UserService implements IUserService {

    private final UserDao userDao = new UserDao();

    @Override
    public void registerUser(User user) {

        String username = user.getUsername();

        if (!isUsernameDuplicated(username)) {
            userDao.saveUser(user);
        }
    }

    @Override
    public User login(User user) {

        String username = user.getUsername();
        String password = user.getPassword();

        return userDao.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean isUsernameDuplicated(String username) {

        return userDao.getUserByUsername(username) != null;
    }

}
