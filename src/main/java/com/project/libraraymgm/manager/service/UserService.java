package com.project.libraraymgm.manager.service;

import com.project.libraraymgm.manager.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
     public User saveUser(User user);

     Optional<User> getUserById(long id);


    List<User> getAllUser();

    User updateUser(long id, User user);
      void deleteUser(long id);








}
