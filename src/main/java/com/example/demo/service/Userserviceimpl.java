package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class Userserviceimpl implements Userservice{
    @Autowired
    private Usermapper usermapper;

    @Override
    public void register(User user) {
        User userdb = usermapper.findbyname(user.getName());
        if(userdb==null){
            if(ObjectUtils.isEmpty(usermapper.getMaxid())){
                user.setId(1);
            }else {
                user.setId((int) usermapper.getMaxid() + 1);
            }
            System.out.println(user);
            usermapper.register(user);
        }else {
            throw new RuntimeException("用户名已存在");
        }
    }

    @Override
    public User login(User user) {
        User userdb = usermapper.findbyname(user.getName());
        if (!ObjectUtils.isEmpty(userdb)){
            if (userdb.getPassword() == user.getPassword()){
                return userdb;
            }else {
                throw new RuntimeException("密码错误");
            }
        }else {
            throw new RuntimeException("用户名不存在");
        }
    }

    public void update(User user) {
            usermapper.updatebyname(user);
    }
}
