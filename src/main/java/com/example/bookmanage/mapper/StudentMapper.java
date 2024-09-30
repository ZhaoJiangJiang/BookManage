package com.example.bookmanage.mapper;

import com.example.bookmanage.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    Student queryStudent(@Param("studentId") long studentId, @Param("password") long password);
}
