package com.example.courseApi.service;


import com.example.courseApi.modelEntity.Course;
import com.example.courseApi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service()
@Scope("prototype")
public class CourseService {

//    private List<Course> courses = new ArrayList<>(Arrays.asList(
//            new Course("java", "Java EE", "Java Springboot"),
//            new Course("cSharp", "Dot net", "Backend Developmet")
//    ));

    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getAllCourses() {
//        return this.courses;

        return this.courseRepository.findAll();
    }

    public Course getCourseByID(String id) {
        Optional<Course> course = this.courseRepository.findById(id);
        if (!course.isEmpty()) {
            com.example.courseApi.modelEntity.Course c = course.get(); //convert to generic type
            return c;
        }
//        boolean existed = this.courses.stream().anyMatch(c -> c.getId().equals(id));
//        if(existed){
//            return this.courses.stream().filter(c -> c.getId().equals(id)).findFirst().get();
//        }
        return null;
//        return new com.example.courseApi.modelEntity.Course();
    }

    public boolean postCourse(Course course) {
        boolean posted = false;
        if (!course.getId().isEmpty()) {
            Course courseExisted = this.getCourseByID(course.getId());
            if (!(courseExisted == null)) {
                return posted;
            }
            com.example.courseApi.modelEntity.Course c = this.courseRepository.save(course);
            if (c instanceof Course && !(c == null))
                posted = true;
        }
        return posted;
    }

    public boolean deleteCourse(String id) {
        Course course = this.getCourseByID(id);
        boolean deleted = false;
        if (!(course == null)) {
            this.courseRepository.deleteById(id);
            deleted = true;
        }
        return deleted;

//
//        boolean deleted = false;
//        for (int i =0; i<courses.size();i++){
//            if( courses.get(i).getId().equals(id) ){
//                return courses.remove(i);
//            }
//        }
//        return new Course();
    }

    public boolean updatedCourse(Course course) {
        boolean updated = false;
        Course getCourse = this.getCourseByID(course.getId());
        if (!(getCourse == null)) {
            if (!(course.getName() == null) && !getCourse.getName().equals(course.getName())) {
                if (!(course.getName().isBlank())) {
                    getCourse.setName(course.getName());
                    System.out.println("Name Updated");
                    updated = true;
                }

            }
            if (!(course.getDescription() == null) && !getCourse.getDescription().equals(course.getDescription())) {
                if (!course.getDescription().isBlank()) {
                    getCourse.setDescription(course.getDescription());
                    System.out.println("Description updated");
                    updated = true;
                }
            }
        }
        this.courseRepository.save(course);
        return updated;
    }
}

//    public boolean updateCourse(Course course){
//        boolean updated = false;
//        boolean existed = this.courses.stream().anyMatch(c -> c.getId().equals(course.getId()));
//        Course getCourse;
//        if(existed) {
//            getCourse = this.courses.stream().filter(c -> c.getId().equals(course.getId())).findFirst().get();
//        }
//        // SOLVED -> will solve it after dinner if the intance not found by id no instance return
//        else {
//            getCourse=null;
//        }
//        System.out.println(getCourse);
//        int courseIndex = this.courses.indexOf(getCourse);
//        if( !(getCourse == null)){
//            if( !(course.getName()==null) && !getCourse.getName().equals(course.getName())){
//                this.courses.get(courseIndex).setName(course.getName());
//                updated = true;
//            }
//            if( !(course.getDescription() == null) && !getCourse.getDescription().equals(course.getDescription())){
//                if(!course.getDescription().isBlank()){
//                    this.courses.get(courseIndex).setDescription(course.getDescription());
//                    updated = true;
//                }
//            }
//        }
//        return updated;
//    }

