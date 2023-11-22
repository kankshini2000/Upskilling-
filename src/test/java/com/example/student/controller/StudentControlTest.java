package com.example.student.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentService;

@WebMvcTest(StudentControl.class)
class StudentControlTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private StudentService service;
    

    @Test
    @DisplayName("Get StdName")
    public void testByStdName() throws Exception {
        Student student = new Student();
        student.setId("11");
        student.setName("jadu");
        student.setAge(11);
        student.setSalary(1111.0);
        when(service.getByName("jadu")).thenReturn(student);
       
        mockmvc.perform(MockMvcRequestBuilders.get("/api/std/name/jadu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("jadu"));
    }
}
