package com.company.service;

import com.company.entity.User;

public interface IUserService {

    public void registerUser(User user);

    public User login(User user);

    public boolean isUsernameDuplicated(String username);

}