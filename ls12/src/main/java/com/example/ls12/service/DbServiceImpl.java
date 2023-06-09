package com.example.ls12.service;

import com.example.ls12.dbUtll.DbManager;
import com.example.ls12.entity.User;

public class DbServiceImpl implements DbService {

    private DbManager dbManager;
    public DbServiceImpl() {

        dbManager = new DbManager();
        dbManager.setConnection();
    }

    @Override
    public User getUserByEmail(final String email) {
        return dbManager.getUserByEmail(email);
    }
}
