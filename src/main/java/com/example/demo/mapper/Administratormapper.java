package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Administrator;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Administratormapper extends BaseMapper<Administrator> {
    @Select("select * from Administrator where name =#{name}")
    Administrator findbyname(String name);

    @Insert("insert into teacher (id,name,password,realname) values (#{id},#{name},#{password},#{realname})")
    void switch2teacher(User user);

    @Insert("insert into student (id,name,password,realname) values (#{id},#{name},#{password},#{realname})")
    void switch2student(Teacher teacher);
}
