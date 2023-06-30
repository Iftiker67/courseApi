package com.example.courseApi.repository;

import com.example.courseApi.modelEntity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, String> {

}
