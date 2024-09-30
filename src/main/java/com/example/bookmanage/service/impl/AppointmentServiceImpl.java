package com.example.bookmanage.service.impl;

import com.example.bookmanage.dto.AppointExecution;
import com.example.bookmanage.entity.Appointment;
import com.example.bookmanage.mapper.AppointmentMapper;
import com.example.bookmanage.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    AppointmentMapper appointmentMapper;

    @Override
    public List<Appointment> getAppointByStudentId(long studentId) {
        logger.info("studentId = " + studentId);
        return appointmentMapper.queryAppointmentBookByStudentId(studentId);
    }
}




















