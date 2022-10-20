package com.example.demo.controllers;


import com.example.demo.entity.User;
import com.example.demo.mapper.Usermapper;
import com.example.demo.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Usermapper usermapper;

    @Autowired
    private Userservice userservice;

    @GetMapping("/")
    public List  query(){
        List<User> list = usermapper.selectList(null);
        System.out.println(list);
        return list;
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Map<String,Object> login(User user){
        Map<String,Object> map = new HashMap<>();
        System.out.println(user);
        try {
            User userdb = userservice.login(user);
            map.put("status","success");
            map.put("msg","登录成功");
            userdb.setPassword(000000);
            map.put("user", userdb);
        }catch (Exception e){
            e.printStackTrace();
            map.put("status","fail");
            map.put("msg",e.getMessage());
        }
        return map;
    }


    /**
     *注册
     */
    @PostMapping("/register")
    public Map<String,Object> register(User user){
        Map<String,Object> map = new HashMap<>();
        System.out.println(user);
        try {
            userservice.register(user);
            map.put("status","success");
            map.put("msg","注册成功");
            return map;
        }
        catch (Exception e){
            e.printStackTrace();
            map.put("status","fail");
            map.put("msg",e.getMessage());
        }
        return map;
    }


    @PutMapping("/update")
    public String update(User user){
        userservice.update(user);
        System.out.println("修改密码后的用户"+user);
        return "更新成功";
    }

    @DeleteMapping("/delete")
    public String delete(int id) {
        usermapper.deleteById(id);
    return "删除";
    }
}
