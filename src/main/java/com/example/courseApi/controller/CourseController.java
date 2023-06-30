package com.example.courseApi.controller;

import com.example.courseApi.modelEntity.Course;
import com.example.courseApi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

//    @CrossOrigin(origins = "*", exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
//    @GetMapping("/course")
    public List<Course> getAllCourse(){
        return this.courseService.getAllCourses();
    }


    @GetMapping("/course/{courseid}")
    public Course getCourseByID(@PathVariable("courseid") String id){
        return this.courseService.getCourseByID(id);
    }

    @PostMapping("/course")
    public boolean postCourse(@RequestBody com.example.courseApi.modelEntity.Course course){
        return this.courseService.postCourse(course);
    }

    @DeleteMapping("/course/{courseid}")
    public boolean deleteCourse(@PathVariable String courseid){
        return this.courseService.deleteCourse(courseid);
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
