package com.example.bookmanage.controller;

import com.example.bookmanage.entity.Appointment;
import com.example.bookmanage.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @RequestMapping(value = "queryAppoint")
    List<Appointment> getAppointByStudentId(long studentId) {
        return appointmentService.getAppointByStudentId(studentId);
    }
}
