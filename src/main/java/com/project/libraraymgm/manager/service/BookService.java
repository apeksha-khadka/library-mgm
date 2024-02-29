package com.project.libraraymgm.manager.service;

import com.project.libraraymgm.manager.domain.Book;
import com.project.libraraymgm.manager.exception.StudentNotFoundException;
import com.project.libraraymgm.manager.infrastructure.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> existsBookById(int id) {
        return bookRepository.findById(id);
    }

    public void deleteBookById(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new StudentNotFoundException(id);
        }
    }


    public Book updateBook(int id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow();
        if (!(existingBook == null)) {
            existingBook.setBookName(book.getBookName());
            existingBook.setAuthorName(book.getAuthorName());
            return existingBook;
        } else {
            throw new RuntimeException("No such book with" + id + " found");
        }
    }

    public List<Book> searchBookByAuthor(String authorName) {
        return bookRepository.findBookByAuthorName(authorName);
    }

    public List<Book> searchBookByBookName(String bookName) {
        return bookRepository.findBooksByBookName(bookName);
    }
}