package com.example.demo.service;

import com.example.demo.entity.Administrator;
import com.example.demo.mapper.Administratormapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
@Service
public class Administratorserviceimpl implements Administratorservice{

    @Autowired
    private Administratormapper administratormapper;

    @Override
    public Administrator login(Administrator administrator) {
        Administrator administratordb = administratormapper.findbyname(administrator.getName());
        if (!ObjectUtils.isEmpty(administratordb)) {
            if (administratordb.getPassword() == administrator.getPassword()) {
                return administratordb;
            } else {
                throw new RuntimeException("密码错误");
            }
        } else {
            throw new RuntimeException("用户名不存在");
        }

        }
    }
