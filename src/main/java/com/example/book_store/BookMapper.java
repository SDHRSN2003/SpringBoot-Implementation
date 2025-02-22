package com.example.book_store;

import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public BookStore toBookStore(BookDto dto){
        var bookStore = new BookStore();
        bookStore.setBookName(dto.BookName());
        bookStore.setBookAuthor(dto.BookAuthor());
        bookStore.setBookPublishYear(dto.BookPublishYear());
        bookStore.setBookQr(dto.BookQr());
        return bookStore;
    }

    public BookResponseDto tobookResponseDto(BookStore bookStore){
        return new BookResponseDto(bookStore.getId(),bookStore.getBookName(), bookStore.getBookAuthor(), bookStore.getBookPublishYear());
    }
}
