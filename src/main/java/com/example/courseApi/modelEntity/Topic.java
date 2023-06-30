package com.example.courseApi.modelEntity;

import jakarta.persistence.*;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long topicID;
    private String topicName;

    private String topicDesc;

    @ManyToOne
    private Course course;

    public long getTopicID() {
        return topicID;
    }

    public void setTopicID(long topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Topic(){

    }

    public Topic(long topicID, String topicName) {
        this.topicID = topicID;
        this.topicName = topicName;
    }

    public Topic(long topicID, String topicName, Course course) {
        this.topicID = topicID;
        this.topicName = topicName;
        this.course = course;
    }

    public Topic(long topicID, String topicName, String topicDesc, Course course) {
        this.topicID = topicID;
        this.topicName = topicName;
        this.topicDesc = topicDesc;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicID='" + topicID + '\'' +
                ", topicName='" + topicName + '\'' +
                ", topicDesc='" + topicDesc + '\'' +
                ", course=" + course +
                '}';
    }
}
