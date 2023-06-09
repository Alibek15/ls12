package com.example.ls12.service;

import com.example.ls12.entity.User;

public interface DbService {
    User getUserByEmail(String email);
}
