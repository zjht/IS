package com.example.demo.controllers;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.mapper.Coursemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class CourseController {
    @Autowired
    private Coursemapper coursemapper;

    @GetMapping("/course")
    public List query(){
        List<Course> list = coursemapper.selectAllCourseAndTeacher();
        System.out.println(list);
        return list;
    }

    @GetMapping("/course/id")
    public List<Course> queryById(int id){
        List list = new ArrayList<>();
        list.add(coursemapper.selectbyid(id));
        System.out.println("queryById   "+list);
        return list;
    }

    @PostMapping("/course")
    public String save(Course course){
        System.out.println("插入"+course);
        Course innercourse = coursemapper.selectbyid(course.getId());
        boolean f = false;
        if(innercourse==null){
            f = true;
        }
        if (course.getId()>0&&f){
            coursemapper.insert(course);
            return "插入成功";
        }else {
            return "插入失败,id重复";
        }
    }
    @DeleteMapping("/course/delete")
    public Map<String,Object> delete(int id, int tid) {
        Map<String,Object> map = new HashMap<>();
        Course course = coursemapper.selectbyid(id);

        boolean f = true;
        if(course==null){
            f = false;
        }
        if (f){
            if(tid==course.getTid()){
            coursemapper.deleteById(id);
            map.put("status","success");
            map.put("msg","deleted successfully");
            System.out.println("删除"+course);
            return map;}
            else {
                map.put("status","fail");
                map.put("msg","Insufficient permissions,Deleted failed");
                System.out.println("权限不足");
                return map;
            }
        }
        else {
            map.put("status","fail");
            map.put("msg",",id not exist,Deleted failed");
            System.out.println("id不存在,删除失败");
            return map;
        }
    }

    @PutMapping("/course/update")
    public Course update(Course course){
        coursemapper.updateById(course);
        System.out.println(course);
        return course;
    }
}
