package com.example.demo.controllers;

import com.example.demo.entity.Teacher;
import com.example.demo.mapper.Teachermapper;
import com.example.demo.service.Teacherservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private Teachermapper teachermapper;

    @Autowired
    private Teacherservice teacherservice;

    @GetMapping("/")
    public List query(){
        List<Teacher> list = teachermapper.selectList(null);
        System.out.println(list);
        return list;
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Map<String,Object> login(Teacher teacher){
        Map<String,Object> map = new HashMap<>();
        System.out.println(teacher);
        try {
            Teacher teacherdb = teacherservice.login(teacher);
            map.put("status","success");
            map.put("msg","登录成功");
            teacherdb.setPassword(000000);
            map.put("user", teacherdb);
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
    public Map<String,Object> register(Teacher teacher){
        Map<String,Object> map = new HashMap<>();
        System.out.println(teacher);
        try {
            teacherservice.register(teacher);
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
    public String update(Teacher teacher){
        teacherservice.update(teacher);
        System.out.println("修改密码后的老师"+teacher);
        return "更新成功";
    }

    @DeleteMapping("/delete")
    public String delete(int id) {
        teachermapper.deleteById(id);
        return "删除";
    }
}
