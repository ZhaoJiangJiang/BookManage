package com.example.bookmanage.service;

import com.example.bookmanage.dto.AppointExecution;
import com.example.bookmanage.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    // 查看某学生预约的书
    List<Appointment> getAppointByStudentId(long studentId);
}
