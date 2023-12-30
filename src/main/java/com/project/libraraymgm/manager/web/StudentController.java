package com.project.libraraymgm.manager.web;

import com.project.libraraymgm.manager.exception.InvalidRequestBodyException;
import com.project.libraraymgm.manager.domain.Student;
import com.project.libraraymgm.manager.service.StudentService;
import com.project.libraraymgm.manager.web.servermodels.StudentCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    private StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody StudentCreateRequest studentReq) {

        if (!studentReq.validRequestBody()) {
            throw new InvalidRequestBodyException();
////            ErrorBody errorBody = new ErrorBody(
////                    "invalid request body"
////            );
//            return ResponseEntity.badRequest().body(errorBody);
        }

        Student responseStudent= studentService.saveStudent(mapStudentCreateRequestToDomain(studentReq));


 //       Student student = studentService.saveUser(studentReq);
//        return studentService.saveUser(studentReq);
        return new ResponseEntity<Student>(responseStudent,HttpStatusCode.valueOf(200));
    }
    private Student mapStudentCreateRequestToDomain(StudentCreateRequest studentReq) {
        Student student = new Student();
        student.setFirstName(studentReq.getFirstName());
        student.setLastName(studentReq.getLastName());
        student.setMatriculationNumber(studentReq.getMatriculationNumber());
        student.setEmailAddress(studentReq.getEmailAddress());

        return student;
    }

    @Data
    @AllArgsConstructor
    public class ErrorBody {
        String message;
    }
}
