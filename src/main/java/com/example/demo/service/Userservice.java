package com.example.demo.service;

import com.example.demo.entity.User;

public interface Userservice {
    void register(User user);

    User login(User user);

    void update(User user);
}
