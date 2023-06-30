package com.example.courseApi.repository;

import com.example.courseApi.modelEntity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {

    Optional<Topic> findByTopicName(String topicName);

    List<Topic> findAllByCourseId(String courseId);

    Topic findByTopicNameAndCourseId(String id, String courseID);
}
