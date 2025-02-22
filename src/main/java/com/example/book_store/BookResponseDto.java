package com.example.book_store;

public record BookResponseDto(
        Integer id,
        String BookName,
        String AuthorName,
        String PublishYear
) {
}
