package com.example.courseApi.controller;

import com.example.courseApi.modelEntity.Topic;
import com.example.courseApi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/course/topic")
    public List<Topic> getTopics(){
        return this.topicService.getTopics();
    }

    @GetMapping("/course/{courseid}/topic")
    public List<Topic> getTopicsByCourse(@PathVariable String courseid){
        return this.topicService.getTopicsByCourse(courseid);
    }

    @GetMapping("/course/{courseid}/topic/{topicName}")
    public ResponseEntity<Topic> getTopicByID(@PathVariable String courseid, @PathVariable String topicName){
        return this.topicService.getTopicByName(courseid,topicName);
    }

    @PostMapping("/course/{courseid}/topic")
    public boolean postTopic(@PathVariable String courseid, @RequestBody Topic topic){
        return this.topicService.postTopic(topic, courseid);
    }
}
