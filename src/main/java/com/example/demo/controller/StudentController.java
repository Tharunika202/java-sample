package com.example.demo.controller;

import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/student")
    public StudentResponse getStudentData(@RequestBody StudentRequest studentRequest)
    {
         return studentService.getStudentNumber(studentRequest);
    }
}
