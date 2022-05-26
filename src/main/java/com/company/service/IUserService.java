package com.company.service;

import com.company.entity.User;

public interface IUserService {

    public int registerUser(User user);

    public void deregisterUser(User user);

    public User login(User user);

    public boolean isUsernameDuplicated(String username);

}
