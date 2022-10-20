package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("teacher")
public class Teacher {
    private int id;
    private String name;
    private int password;
    private String realname;
    private String subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", realname='" + realname + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}