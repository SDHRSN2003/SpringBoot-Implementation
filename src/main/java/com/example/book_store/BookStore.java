package com.example.book_store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BookStore {
    @Id
    @GeneratedValue
    private Integer id;

    private String BookName;

    private String BookAuthor;

    private String BookPublishYear;

    private String BookQr;


    public BookStore(String bookName, String bookAuthor, String bookPublishYear, String BookQr) {
        BookName = bookName;
        BookAuthor = bookAuthor;
        BookPublishYear = bookPublishYear;
        BookQr = BookQr;
    }

    public BookStore() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public String getBookPublishYear() {
        return BookPublishYear;
    }

    public void setBookPublishYear(String bookPublishYear) {
        BookPublishYear = bookPublishYear;
    }

    public String getBookQr() {
        return BookQr;
    }

    public void setBookQr(String BookQr) {
        this.BookQr = BookQr;
    }
}
