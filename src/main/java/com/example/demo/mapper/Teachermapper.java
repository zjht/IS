package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface Teachermapper extends BaseMapper<Teacher> {

    @Insert("insert into teacher (id,name,password,realname,subject) values (#{id},#{name},#{password},#{realname},#{subject})")
    void register(Teacher teacher);

    @Select("select * from teacher where name =#{name}")
    Teacher findbyname(String name);

    @Select("select id from teacher order by id desc limit 1")
    Object getMaxid();

    @Update("update teacher set password = #{password} where name = #{name}")
    void updatebyname(Teacher teacher);
}
