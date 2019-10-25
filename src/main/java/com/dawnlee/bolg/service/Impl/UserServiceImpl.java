package com.dawnlee.bolg.service.Impl;

import com.dawnlee.bolg.mapper.UserMapper;
import com.dawnlee.bolg.model.User;
import com.dawnlee.bolg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @CachePut(value = "user",key = "#result.id")
    @Override
    public User insert(User user) {

        userMapper.insertUser(user);
        return user;

    }
    @Cacheable(value = "user",cacheManager = "MyUsercacheManager")
    @Override
    public User findByToken(String token) {
        User user = userMapper.findByToken(token);
        return user;
    }
}
