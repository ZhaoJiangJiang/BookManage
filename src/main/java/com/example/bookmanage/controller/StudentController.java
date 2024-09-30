package com.example.bookmanage.controller;

import com.example.bookmanage.entity.Student;
import com.example.bookmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/validateStudent")
    public Student validateStudentByIdAndPassword(long studentId, long password) {
        return studentService.validateStudent(studentId, password);
    }
}
