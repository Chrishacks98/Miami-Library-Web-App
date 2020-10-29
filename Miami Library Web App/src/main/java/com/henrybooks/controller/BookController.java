package com.henrybooks.controller;

import com.henrybooks.model.Book;
import com.henrybooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        /*uses an EntityManager to persist the book entity to the database
        see https://github.com/spring-projects/spring-data-jpa/blob/master/
        src/main/java/org/springframework/data/jpa/repository/support/
        SimpleJpaRepository.java for the implementation*/
        if (bookRepo.findOne(book.getBookCode()) == null){
            int status = bookRepo.createOne(book.getBookCode(), book.getTitle(), book.getPublisherCode(),
                    book.getType(), book.getPaperback());
            if (status == 1){
                return ResponseEntity.ok(book);
            }
        }
        //book already exists
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") String bookCode) {
        Book book = bookRepo.findOne(bookCode);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/book-stats/{title}")
    public List getBookStats (@PathVariable("title") String title){
        return bookRepo.getBookStatsByTitle(title);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable(value = "id") String bookCode, @RequestBody Book bookDetails) {
        Book book = bookRepo.findOne(bookCode);
        if (book == null){
            return ResponseEntity.notFound().build();
        }

        int status = bookRepo.updateOne(bookCode, bookDetails.getTitle(), bookDetails.getPublisherCode(),
                bookDetails.getType(), bookDetails.getPaperback());
        if (status == 1){
            bookDetails.setBookCode(bookCode);
            return ResponseEntity.ok(bookDetails);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") String bookCode) {
        if (bookRepo.findOne(bookCode) == null){
            return ResponseEntity.notFound().build();
        }

        bookRepo.deleteOne(bookCode);
        return ResponseEntity.ok().build();
    }

}
