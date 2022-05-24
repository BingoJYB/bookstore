package com.company.dao;

import com.company.entity.User;

public interface IUserDao {

    public User getUserByUsername(String username);

    public User getUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);
}
