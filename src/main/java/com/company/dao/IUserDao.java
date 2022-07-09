package com.company.dao;

import java.sql.SQLException;

import com.company.entity.User;

public interface IUserDao {

    public User getUserByUsername(String username) throws SQLException;

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException;

    public int saveUser(User user) throws SQLException;

    public int deleteUser(User user) throws SQLException;

}
