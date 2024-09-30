package com.example.bookmanage.service.impl;

import com.example.bookmanage.dto.AppointExecution;
import com.example.bookmanage.entity.Appointment;
import com.example.bookmanage.entity.Book;
import com.example.bookmanage.enums.AppointStateEnum;
import com.example.bookmanage.exception.AppointException;
import com.example.bookmanage.exception.NoNumberException;
import com.example.bookmanage.exception.RepeatAppointException;
import com.example.bookmanage.mapper.AppointmentMapper;
import com.example.bookmanage.mapper.BookMapper;
import com.example.bookmanage.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    BookMapper bookMapper;

    @Autowired
    AppointmentMapper appointmentMapper;

    @Override
    public List<Book> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    public Book queryByBookId(long bookId) {
        logger.info("query bookId = " + bookId);
        return bookMapper.queryByBookId(bookId);
    }

    public List<Book> getSomeBookList(String bookName) {
        logger.info("query bookName = " + bookName);
        return bookMapper.getSomeBookList(bookName);
    }

    @Override
    public AppointExecution appointBook(long bookId, long studentId) {
        try {
            int updateBookNumber = bookMapper.reduceBookNumber(bookId);
            if (updateBookNumber <= 0) {
                logger.error("OUT_OF_STOCK " + bookId + ": " + updateBookNumber);
                throw new NoNumberException("OUT_OT_STOCK");
            } else {
                int insertResult = appointmentMapper.insertAppointment(bookId, studentId);
                if (insertResult <= 0) {
                    logger.error("REPEAT_APPOINT " + studentId + "-" + bookId);
                    int rollbackBookNumber = bookMapper.addBookNumber(bookId);
                    throw new RepeatAppointException("REPEAT_APPOINT");
                } else {
                    logger.info("APPOINT_SUCCESS " + studentId + ": " + bookId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS);
                }
            }
        } catch (NoNumberException | RepeatAppointException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            int rollbackBookNumber = bookMapper.addBookNumber(bookId);
            throw new AppointException("APPOINT INNER ERROR: " + e.getMessage());
        }
    }


}
















