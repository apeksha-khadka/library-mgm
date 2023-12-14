package com.project.libraraymgm.manager.service;

import com.project.libraraymgm.manager.entity.User;
import com.project.libraraymgm.manager.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService implements ServiceInterface{

    private LibraryRepository libraryRepository;
    private LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository=libraryRepository;
    }




    public User saveUser(User user) {
        return libraryRepository.save(user) ;
    }


    public Optional<User> getUserById(long id) {
        return libraryRepository.findById(id);
    }

    

    @Override
    public List<User> getAllUser(User user) {
        return libraryRepository.findAll();
    }

    @Override
    public User updateUser(long id, User user) {
        User updatedUser= libraryRepository.findById(id).orElseThrow();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setSemester(user.getSemester());
        updatedUser.setFaculty(user.getFaculty());
        updatedUser.setMattNum(user.getMattNum());
        return libraryRepository.save(updatedUser);

    }

    @Override
    public void deleteUser(long id) {
        libraryRepository.deleteById(id);

    }


}
