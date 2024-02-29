package com.project.libraraymgm.manager.service;

import com.project.libraraymgm.manager.domain.Student;
import com.project.libraraymgm.manager.exception.ResourceAlreadyExistsException;
import com.project.libraraymgm.manager.exception.StudentNotFoundException;
import com.project.libraraymgm.manager.infrastructure.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        Student existingStudent = studentRepository.findByEmailAddress(student.getEmailAddress());
        if (existingStudent != null) {
            throw new ResourceAlreadyExistsException(Student.class.getSimpleName());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        try {
            return studentRepository.findById(id).orElseThrow();
        } catch (Exception ex) {
            throw new StudentNotFoundException(id);
        }
    }

    public Student updatedInfo(int id, Student student) {
        Student updatedStudent = studentRepository.findById(id).orElseThrow();
        if (updatedStudent != null) {
            updatedStudent.setFirstName(student.getFirstName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setEmailAddress(student.getEmailAddress());
            updatedStudent.setMatriculationNumber(student.getMatriculationNumber());
            updatedStudent.setFaculty(student.getFaculty());
            return studentRepository.save(updatedStudent);

        } else {
            return null;
        }


    }


}
