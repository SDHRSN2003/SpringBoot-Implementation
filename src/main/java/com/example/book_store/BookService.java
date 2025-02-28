package com.example.book_store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookResponseDto saveBookStore(BookDto dto){
        var bookStore = bookMapper.toBookStore(dto);
        var savedBookStore = bookRepository.save(bookStore);
        return bookMapper.tobookResponseDto(savedBookStore);
    }

    public BookResponseDto getBookById(Integer id){
        var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
        return bookMapper.tobookResponseDto(book);
    }

    public BookStore updateBookDetails(Integer id, BookDto bookDto){
        BookStore existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found"));
        existingBook.setBookName(bookDto.BookName());
        existingBook.setBookAuthor(bookDto.BookAuthor());
        existingBook.setBookPublishYear(bookDto.BookPublishYear());
        existingBook.setBookQr(bookDto.BookQr());
        return bookRepository.save(existingBook);
    }

    public List<BookResponseDto> getAllBooks(){
        var bookStore = bookRepository.findAll();
        return bookStore.stream()
                .map(bookMapper::tobookResponseDto)
                .collect(Collectors.toList());
    }

    public void deleteBookById(Integer id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new RuntimeException("No Book Available With This Id");
        }
    }
}
