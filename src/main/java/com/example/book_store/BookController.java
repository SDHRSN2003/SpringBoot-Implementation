package com.example.book_store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto createBook(
        @RequestBody BookDto bookDto
    ){
        return bookService.saveBookStore(bookDto);
    }

    @GetMapping("/{id}")
    public BookResponseDto getBookById(
            @PathVariable("id") Integer id
    ){
        return bookService.getBookById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookStore> updateBookDetails(
        @PathVariable int id, @RequestBody BookDto bookDto
    ){
        BookStore updatedBook = bookService.updateBookDetails(id, bookDto);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(
        @PathVariable int id
    ){
        try{
            bookService.deleteBookById(id);
            return ResponseEntity.ok("Book Deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public List<BookResponseDto> getAllBooks(){
        return bookService.getAllBooks();
    }

}
