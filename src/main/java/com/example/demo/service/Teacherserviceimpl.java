package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.mapper.Teachermapper;
import com.example.demo.mapper.Teachermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
@Service
@Transactional
public class Teacherserviceimpl implements Teacherservice {
        @Autowired
        private Teachermapper teachermapper;

        @Override
        public void register(Teacher teacher) {
            Teacher teacherdb = teachermapper.findbyname(teacher.getName());
            if(teacherdb==null){
                if(ObjectUtils.isEmpty(teachermapper.getMaxid())){
                    teacher.setId(1);
                }else {
                    teacher.setId((int) teachermapper.getMaxid() + 1);
                }
                System.out.println(teacher);
                teachermapper.register(teacher);
            }else {
                throw new RuntimeException("用户名已存在");
            }
        }

        @Override
        public Teacher login(Teacher teacher) {
            Teacher teacherdb = teachermapper.findbyname(teacher.getName());
            if (!ObjectUtils.isEmpty(teacherdb)){
                if (teacherdb.getPassword() == teacher.getPassword()){
                    return teacherdb;
                }else {
                    throw new RuntimeException("密码错误");
                }
            }else {
                throw new RuntimeException("用户名不存在");
            }
        }

        public void update(Teacher teacher) {
            teachermapper.updatebyname(teacher);
        }
    }

