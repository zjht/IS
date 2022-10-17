package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("course")
public class Course {
    private int id;
    private String name;
    private Teacher teacher;
@TableField(exist = false)
    private Teacher teacherinfo;
    private String studyhour;
    private String Syllabus;
    private String document;
    private int tid;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getStudyhour() {
        return studyhour;
    }

    public void setStudyhour(String studyhour) {
        this.studyhour = studyhour;
    }

    public String getSyllabus() {
        return Syllabus;
    }

    public void setSyllabus(String syllabus) {
        Syllabus = syllabus;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studyhour='" + studyhour + '\'' +
                ", Syllabus='" + Syllabus + '\'' +
                ", document='" + document + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }
}
