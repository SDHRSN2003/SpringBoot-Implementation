package com.example.book_store;

import jakarta.validation.constraints.NotEmpty;

public record BookDto(
        @NotEmpty
        String BookName,
        String BookAuthor,
        String BookPublishYear,
        String BookQr
) {
}
