package com.example.bookmanage.mapper;

import com.example.bookmanage.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppointmentMapper {
    // 通过 bookId 和 studentId 预约书籍
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    // 通过 studentId 查询已预约的书籍
    List<Appointment> queryAppointmentBookByStudentId(long studentId);
}
