package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.mapper.Teachermapper;
import com.example.demo.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
@Service
@Transactional
public class Teacherserviceimpl implements Teacherservice {
        @Autowired
        private Teachermapper teachermapper;
        @Autowired
        private Usermapper usermapper;

        @Override
        public void register(Teacher teacher) {
            Teacher teacherdb = teachermapper.findbyname(teacher.getName());
            User userdb = usermapper.findbyname(teacher.getName());
            if(teacherdb==null&&userdb==null){
                if(ObjectUtils.isEmpty(teachermapper.getMaxid())){
                    teacher.setId(1);
                }else {
                    teacher.setId((int) teachermapper.getMaxid() + 1);
                }
                teacher.setPassword(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()));
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
                if (teacherdb.getPassword().equals(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()))){
                    return teacherdb;
                }else {
                    throw new RuntimeException("密码错误");
                }
            }else {
                throw new RuntimeException("用户名不存在");
            }
        }

        public void update(Teacher teacher) {
            teacher.setPassword(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()));
            teachermapper.updatebyname(teacher);
        }
    }

