package com.company.www.dao;

import com.company.www.entity.User;

public interface IUserDao {

    public User getUserByUsername(String username);

    public User getUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);
}
