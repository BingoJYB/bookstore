package com.company.service;

import java.sql.SQLException;

import com.company.entity.User;

public interface IUserService {

    public int registerUser(User user) throws SQLException;

    public void deregisterUser(User user) throws SQLException;

    public User login(String username, String password) throws SQLException;

    public boolean isUsernameDuplicated(String username) throws SQLException;

}
