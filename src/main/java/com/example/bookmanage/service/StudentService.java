package com.example.bookmanage.service;

import com.example.bookmanage.entity.Student;

public interface StudentService {
    Student validateStudent(Long studentId, Long password);
}
