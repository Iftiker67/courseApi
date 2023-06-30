package com.example.courseApi.service;


import com.example.courseApi.modelEntity.Student;
import com.example.courseApi.repository.StudentRepository;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

//    public Optional<Student> existStudent(Student student){
//
//    }

    public ResponseEntity<Student> postStudent(Student student){
        Optional<Student> studentExist = this.studentRepository.findById(student.getStudentId());
        ResponseEntity<Student> studentResponseEntity;
        System.out.println(student);
        System.out.println(studentExist.isEmpty());

        if(!studentExist.isEmpty()){
            Student studentFound = studentExist.get();
            studentResponseEntity = new ResponseEntity<>(studentFound, HttpStatus.BAD_REQUEST);
            System.out.println(studentResponseEntity);
            return studentResponseEntity;
        }
        System.out.println("Else Entering");
        Student saved = this.studentRepository.save(student);
        System.out.println(saved);
        studentResponseEntity= new ResponseEntity<>(saved,HttpStatus.CREATED);
        return  studentResponseEntity;
    }

    public ResponseEntity< List<Student> > getAllAdmittedStudents() {
        List<Student> students = this.studentRepository.findAll();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Created","created")
                .body(students);

    }
}
