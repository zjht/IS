package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import javax.xml.soap.SAAJResult;

import static com.baomidou.mybatisplus.core.assist.ISqlRunner.UPDATE;

@Mapper
public interface Usermapper extends BaseMapper<User> {

    @Insert("insert into student (id,age,password,name,gender) values (#{id},#{age},#{password},#{name},#{gender})")
    void register(User user);

    @Select("select * from student where name =#{name}")
    User findbyname(String name);

    @Select("select id from student order by id desc limit 1")
    Object getMaxid();

    @Update("update student set password = #{password} where name = #{name}")
    void updatebyname(User user);
}
