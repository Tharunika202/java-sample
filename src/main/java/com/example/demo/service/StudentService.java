package com.example.demo.service;

import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponse getStudentNumber(StudentRequest studentRequest) {
        return StudentResponse.builder().build();
    }
}
