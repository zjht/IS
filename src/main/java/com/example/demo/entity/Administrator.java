package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("administrator")
public class Administrator {
    private String name;
    private int password;

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

    @Override
    public String toString() {
        return "Administrator{" +
                "name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
