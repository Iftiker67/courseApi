package com.example.courseApi.controller;

import com.example.courseApi.modelEntity.Course;
import com.example.courseApi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

//    @CrossOrigin(origins = "*", exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
    @GetMapping("/course")
    public ResponseEntity< List<Course> > getAllCourse(){
        ResponseEntity responseEntity;
        HttpHeaders httpHeaders = new HttpHeaders();
        if(!this.courseService.getAllCourses().isEmpty()){
            httpHeaders.set("Get course","Found");
            return ResponseEntity.ok(this.courseService.getAllCourses());
        }
        httpHeaders.set("Get course","Not Found");
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getAllCourses();
    }

    @GetMapping("/course/{courseid}")
    public ResponseEntity<Course> getCourseByID(@PathVariable("courseid") String id){
        Course course = this.courseService.getCourseByID(id);
        ResponseEntity<Course> courseResponseEntity;
        if(course==null){
            courseResponseEntity = new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else{
            courseResponseEntity = new ResponseEntity<>(course,HttpStatus.FOUND);
        }
        return courseResponseEntity;
    }

    @PostMapping("/course")
    public boolean postCourse(@RequestBody com.example.courseApi.modelEntity.Course course){
        return this.courseService.postCourse(course);
    }

    @DeleteMapping("/course/{courseid}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable String courseid){
        boolean deleted = this.courseService.deleteCourse(courseid);
        ResponseEntity<Boolean> deletedResponseEntity;
        if(deleted){
            deletedResponseEntity = new ResponseEntity<Boolean>(deleted,HttpStatus.OK);
        }
        else{
            deletedResponseEntity = new ResponseEntity<Boolean>(deleted,HttpStatus.BAD_REQUEST);
        }
        return deletedResponseEntity;
    }

    @PutMapping("/course")
    public boolean updateCourse(@RequestBody com.example.courseApi.modelEntity.Course course){
        return this.courseService.updatedCourse(course);
    }

//    get All courses
//    get individual course
//    update course
//    delete course

}
