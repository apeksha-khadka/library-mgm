package com.project.libraraymgm.manager.web;

import com.project.libraraymgm.manager.domain.Book;
import com.project.libraraymgm.manager.service.BookService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //add book
    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<Book>(savedBook, HttpStatusCode.valueOf(200));
    }

    //get book by ID
    @GetMapping("/{id}")
    public Optional<Book> existsBookById(@PathVariable int id) {

        return bookService.existsBookById(id);
    }

    //delete book by Id
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable int id) {

        bookService.deleteBookById(id);
    }

    // update book by Id
    @PutMapping("/update-book/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @GetMapping("/search-books")
    public List<Book> searchBooks(@RequestParam(required = false) String author) {
        List<Book> matchingBooks = new ArrayList<>();
        if (author != null) {
            matchingBooks.addAll(bookService.searchBookByAuthor(author));
        }
        return matchingBooks;
    }
//
//    @DeleteMapping("/{authorName}")
//    public ResponseEntity<Integer> deleteBookByAuthorName(@PathVariable String authorName){
//
//        int deletedBookCount =  bookService.deleteBookByAuthorName(authorName);
//        return ResponseEntity.ok(deletedBookCount);
//    }
}
