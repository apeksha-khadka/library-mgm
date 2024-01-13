package com.project.libraraymgm.manager.web;

import com.project.libraraymgm.manager.domain.Admin;
import com.project.libraraymgm.manager.domain.Book;
import com.project.libraraymgm.manager.service.AdminService;
import com.project.libraraymgm.manager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    private BookService bookService;
    private BookController bookController;

    private AdminController(AdminService adminService,
                            BookService bookService,
                            BookController bookController) {
        this.adminService = adminService;
        this.bookService = bookService;
        this.bookController = bookController;
    }

    @PostMapping()
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    //checked
    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    //checked
    @PutMapping("/update-book/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete-book")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBookById(id);
    }

    //checked
    @GetMapping("/search-book")
    public List<Book> searchBook(@RequestParam String author) {
        return bookService.searchBookByAuthor(author);

    }

}
