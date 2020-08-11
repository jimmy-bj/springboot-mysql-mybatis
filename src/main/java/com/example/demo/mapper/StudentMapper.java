package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student findById(Long id);
    List<Student> findAll();
    int insertObj(Student stu);
    int deleteObj(Long id);
    int updateObj(Student stu);

    @Update("update student set name=#{name},idNum=#{idNum} where id = #{id}")
    int edit(Student stu);
}
