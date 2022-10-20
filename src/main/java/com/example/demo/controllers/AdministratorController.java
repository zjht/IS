package com.example.demo.controllers;

import com.example.demo.entity.Administrator;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.mapper.Administratormapper;
import com.example.demo.mapper.Coursemapper;
import com.example.demo.mapper.Teachermapper;
import com.example.demo.mapper.Usermapper;
import com.example.demo.service.Administratorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private Coursemapper coursemapper;
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private Teachermapper teachermapper;
    @Autowired
    private Administratormapper administratormapper;
    @Autowired
    private Administratorservice administratorservice;
    /**
     * 登录
     */
    @PostMapping("/login")
    public Map<String,Object> login(Administrator administrator){
        Map<String,Object> map = new HashMap<>();
        System.out.println(administrator);
        try {
            Administrator administratordb = administratorservice.login(administrator);
            map.put("status","success");
            map.put("msg","登录成功");
            administratordb.setPassword(000000);
            map.put("administrator", administratordb);
        }catch (Exception e){
            e.printStackTrace();
            map.put("status","fail");
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @PostMapping("/switch2teacher")
    public Map<String,Object> switch2teacher(User user){
        Map<String,Object> map = new HashMap<>();
        System.out.println("switch:"+user);
        try {
            usermapper.deleteById(user.getId());
            if(ObjectUtils.isEmpty(teachermapper.getMaxid())){
                user.setId(1);
            }else {
            user.setId((int) teachermapper.getMaxid() + 1);}
            administratormapper.switch2teacher(user);
            map.put("status","success");
            map.put("msg","转换成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status","fail");
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @PostMapping("/switch2student")
    public Map<String,Object> switch2student(Teacher teacher){
        Map<String,Object> map = new HashMap<>();
        System.out.println("switch:"+teacher);
        try {
            teachermapper.deleteById(teacher.getId());
            coursemapper.deletebytid(teacher.getId());
            if(ObjectUtils.isEmpty(usermapper.getMaxid())){
                teacher.setId(1);
            }else {
            teacher.setId((int) usermapper.getMaxid() + 1);}
            administratormapper.switch2student(teacher);
            map.put("status","success");
            map.put("msg","转换成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status","fail");
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
