package com.dawnlee.bolg.service;

import com.dawnlee.bolg.model.User;

public interface UserService {


    public User insert(User user);

    User findByToken(String token);
}
