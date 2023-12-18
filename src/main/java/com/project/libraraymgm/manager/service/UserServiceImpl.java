package com.project.libraraymgm.manager.service;

import com.project.libraraymgm.manager.model.User;
import com.project.libraraymgm.manager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }




    public User saveUser(User user) {
        return userRepository.save(user) ;
    }


    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(long id, User user) {
        User updatedUser= userRepository.findById(id).orElseThrow();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setSemester(user.getSemester());
        updatedUser.setFaculty(user.getFaculty());
        updatedUser.setMattNum(user.getMattNum());
        return userRepository.save(updatedUser);

    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }


}
