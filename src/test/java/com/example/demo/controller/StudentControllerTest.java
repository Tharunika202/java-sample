package com.example.demo.controller;

import com.example.demo.request.StudentRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class StudentControllerTest {
    private StudentController subject;
    @MockBean
    private StudentService mockStudentService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStudentData_whenValidRequestIsProvided_shouldReturnStudentDetails() throws Exception {
        StudentRequest studentRequest = StudentRequest.builder().rollNo(22).build();
//        when(mockStudentService.getStudentNumber(studentRequest)).thenReturn(StudentResponse.builder().name("ravi").age(22).build());
        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("http://localhost:/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(studentRequest));
        this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());

    }
}
