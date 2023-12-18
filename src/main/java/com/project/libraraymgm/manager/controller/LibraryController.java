package com.project.libraraymgm.manager.controller;

import com.project.libraraymgm.manager.model.User;
import com.project.libraraymgm.manager.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/user")
public class LibraryController {
    private UserServiceImpl libraryService;

    private LibraryController(UserServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping()
    public User saveUser(@RequestBody User user) {
        return libraryService.saveUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable long id) {
        return libraryService.getUserById(id);
    }

    @GetMapping()
    public List<User> getAllUser() {
        return libraryService.getAllUser();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @PathVariable User user) {
        return libraryService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable long id){
        libraryService.deleteUser(id);
    }

}
