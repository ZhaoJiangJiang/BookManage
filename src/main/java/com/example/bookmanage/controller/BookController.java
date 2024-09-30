package com.example.bookmanage.controller;

import com.example.bookmanage.dto.AppointExecution;
import com.example.bookmanage.dto.Result;
import com.example.bookmanage.entity.Appointment;
import com.example.bookmanage.entity.Book;
import com.example.bookmanage.enums.AppointStateEnum;
import com.example.bookmanage.exception.NoNumberException;
import com.example.bookmanage.exception.RepeatAppointException;
import com.example.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/queryAllBooks")
    public List<Book> queryAllBooks() {
        return bookService.queryAllBooks();
    }

    @RequestMapping(value="queryBookById")
    public Book queryBookById(long bookId) {
        return bookService.queryByBookId(bookId);
    }

    @RequestMapping(value = "querySomeBook")
    public List<Book> getSomeBookList(String bookName) {
        return bookService.getSomeBookList(bookName);
    }

    @RequestMapping(value = "appointBook")
    public Result<AppointExecution> appointBook(long bookId, long studentId) {
        Result<AppointExecution> result;
        AppointExecution appointExecution = null;
        try {
            appointExecution = bookService.appointBook(bookId, studentId);
            result = new Result<AppointExecution>(true, appointExecution);
            return result;
        } catch (NoNumberException e1) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
            result = new Result<AppointExecution>(true, appointExecution);
            return result;
        } catch (RepeatAppointException e2) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
            result = new Result<AppointExecution>(true, appointExecution);
            return result;
        } catch (Exception e) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.SYSTEM_ERROR);
            result = new Result<AppointExecution>(true, appointExecution);
            return result;
        }
    }
}


















