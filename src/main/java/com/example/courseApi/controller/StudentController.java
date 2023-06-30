package com.example.courseApi.controller;

import com.example.courseApi.modelEntity.Student;


import com.example.courseApi.service.StudentService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity< List<Student >> getAllAdmittedStudents(){
//        System.out.println("Headers"+authorie);
        return studentService.getAllAdmittedStudents();
    }

    @PostMapping("/student")
    public ResponseEntity<Student> admittedStudent(@RequestBody Student student){
//        System.out.println("Headers "+requestHeader);
        return studentService.postStudent(student);
    }
}
