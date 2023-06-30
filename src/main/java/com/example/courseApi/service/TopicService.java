package com.example.courseApi.service;

import com.example.courseApi.modelEntity.Course;
import com.example.courseApi.modelEntity.Topic;
import com.example.courseApi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseService courseService;

    public List<Topic> getTopics() {
        return this.topicRepository.findAll();
    }

    public Topic getTopicByName(String topicName){
        Optional<Topic> optional = this.topicRepository.findById(topicName);
        Topic existedTopic = optional.isPresent()? optional.get():null;
        if( !(existedTopic==null)){
            return existedTopic;
        }
        return new Topic();
    }
    public ResponseEntity<Topic> getTopicByName(String courseId, String topicName){
        ResponseEntity<Topic> topicResponseEntity;

        Topic topic = this.topicRepository.findByTopicNameAndCourseId(topicName,courseId);
        if(topic!=null){
            topicResponseEntity = new ResponseEntity<>(topic, HttpStatus.FOUND);
            return topicResponseEntity;
        }
        return new ResponseEntity<>(new Topic(),HttpStatus.NOT_FOUND);
    }

    //will solve it. save a coure topic and want to same topic in course but it shift
    public boolean postTopic( Topic topic, String courseId){
        boolean added = false;

        boolean existed = false;
        Course course = this.courseService.getCourseByID(courseId);
        if(topic==null || topic.getTopicName().isBlank()){
            return added;
        }
        if(course==null){
            return added;
        }
        System.out.println(course);
        List<Topic> topics = this.topicRepository.findAllByCourseId(courseId);

        if(!topics.isEmpty()){
            System.out.println(topics);
            existed = topics.stream().anyMatch(t-> t.getTopicName().equals(topic.getTopicName()));
            if(!existed){
                //topic.setCourseId(courseId);
                topic.setCourse(course);
                this.topicRepository.save(topic);
                added = true;
                System.out.println(topic);
                System.out.println("Not Existed ADDED");
                //return added;
            }
        }
        else{
            topic.setCourse(course);
            this.topicRepository.save(topic);
            added=true;
            System.out.println(topic);
            System.out.println("ELSE ADDED");
        }
        System.out.println(existed);
        return added;
    }

    public List<Topic> getTopicsByCourse(String courseid) {
        return this.topicRepository.findAllByCourseId(courseid);
    }
}
