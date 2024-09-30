package com.example.bookmanage.service;

import com.example.bookmanage.dto.AppointExecution;
import com.example.bookmanage.entity.Appointment;
import com.example.bookmanage.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> queryAllBooks();

    Book queryByBookId(long bookId);

    List<Book> getSomeBookList(String bookName);

    // 预约图书
    AppointExecution appointBook(long bookId, long StudentId);
}
