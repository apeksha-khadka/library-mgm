package com.project.libraraymgm.manager.service;

import com.project.libraraymgm.manager.infrastructure.StudentRepository;
import com.project.libraraymgm.manager.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        try{
             Student savedStudent= studentRepository.save(student);
            return savedStudent;
        }
        catch(Exception ex){
            System.out.println("ekchin ko lagi ");
            throw ex;
        }

    }

//    public Optional<Student> getUserById(long id) {
//        return studentRepository.findById(id);
//    }
//
//    public List<Student> getAllUser() {
//        return studentRepository.findAll();
//    }
//
//    public Student updateUser(long id, Student student) {
//        Student updatedStudent = studentRepository.findById(id).orElseThrow();
//        updatedStudent.setFirstName(student.getFirstName());
//        updatedStudent.setLastName(student.getLastName());
//        updatedStudent.setSemester(student.getSemester());
//        updatedStudent.setFaculty(student.getFaculty());
//        updatedStudent.setMattNum(student.getMattNum());
//
//        return studentRepository.save(updatedStudent);
//    }
//
//    public void deleteUser(long id) {
//        studentRepository.deleteById(id);
//    }
}
