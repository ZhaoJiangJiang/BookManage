package com.example.bookmanage.mapper;

import com.example.bookmanage.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> queryAllBooks();

    Book queryByBookId(long bookId);

    List<Book> getSomeBookList(String bookName);

    int reduceBookNumber(long bookId);

    int addBookNumber(long bookId);
}
