package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;

public interface Teacherservice {
        void register(Teacher teacher);

        Teacher login(Teacher teacher);

        void update(Teacher teacher);
    }

