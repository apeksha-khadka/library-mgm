package com.project.libraraymgm.manager.web;

import com.project.libraraymgm.manager.domain.Student;
import com.project.libraraymgm.manager.service.StudentService;
import com.project.libraraymgm.manager.web.servermodels.StudentCreateRequest;
import com.project.libraraymgm.manager.web.servermodels.StudentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    private StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody StudentCreateRequest studentReq) {

        studentReq.validateRequestBody();

        Student responseStudent = studentService.saveStudent(mapStudentCreateRequestToDomain(studentReq));

        return new ResponseEntity<>(responseStudent, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        StudentResponse studentResponse = mapStudentDomainToStudentResponse(student);
        return ResponseEntity.ok(studentResponse);

    }


    @PostMapping("/updateStudentInfo/{id}")
    public Student updateStudentInfo(@PathVariable int id, @RequestBody Student student) {

        return studentService.updatedInfo(id, student);

    }

    private StudentResponse mapStudentDomainToStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setMatriculationNumber(student.getMatriculationNumber());
        studentResponse.setEmailAddress(student.getEmailAddress());
        return studentResponse;
    }


    private Student mapStudentCreateRequestToDomain(StudentCreateRequest studentReq) {
        Student student = new Student();
        student.setFirstName(studentReq.getFirstName());
        student.setLastName(studentReq.getLastName());
        student.setMatriculationNumber(studentReq.getMatriculationNumber());
        student.setEmailAddress(studentReq.getEmailAddress());
        //switch-case
        return student;
    }

    @Data
    @AllArgsConstructor
    public class ErrorBody {
        String message;
    }
}
