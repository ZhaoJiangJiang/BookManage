package com.example.bookmanage.entity;

import lombok.Data;

@Data
public class Book {
    private Long bookId;
    private String bookName;
    private String bookIntro;
    private Integer bookNumber;
}
