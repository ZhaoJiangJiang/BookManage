package com.example.bookmanage.service.impl;

import com.example.bookmanage.entity.Student;
import com.example.bookmanage.mapper.StudentMapper;
import com.example.bookmanage.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student validateStudent(Long studentId, Long password) {
        Student queryStudentResult = studentMapper.queryStudent(studentId, password);
        logger.info(queryStudentResult.toString());
        return queryStudentResult;
    }
}
