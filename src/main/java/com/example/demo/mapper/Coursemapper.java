package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Coursemapper extends BaseMapper<Course> {

    @Select("select * from course where id =#{id} order by id asc")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "studyhour",property = "studyhour"),
            @Result(column = "Syllabus",property = "Syllabus"),
            @Result(column = "document",property = "document"),
            @Result(column = "tid",property = "tid"),
            @Result(column = "tid",property = "teacher",javaType = Teacher.class,
                    one = @One(select = "com.example.demo.mapper.Teachermapper.selectById")),
    })
    Course selectbyid(int id);

    @Select("select * from course order by id asc")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "studyhour",property = "studyhour"),
            @Result(column = "Syllabus",property = "Syllabus"),
            @Result(column = "document",property = "document"),
            @Result(column = "tid",property = "tid"),
            @Result(column = "tid",property = "teacher",javaType = Teacher.class,
            one = @One(select = "com.example.demo.mapper.Teachermapper.selectById")),
    })
    List<Course> selectAllCourseAndTeacher();
}
