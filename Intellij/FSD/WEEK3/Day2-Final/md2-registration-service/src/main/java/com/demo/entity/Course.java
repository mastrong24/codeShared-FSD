package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {

    @Id
    @Column(name = "CO_ID", nullable = false, length = 10)
    int courseId;

    @Column(name = "CO_NAME",nullable = false,length =255)
    String courseName;


    int au_id;

    public Course() {
        super();
    }

    public Course(int courseId, String courseName, int au_id) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.au_id = au_id;
    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAu_id() {
        return au_id;
    }

    public void setAu_id(int au_id) {
        this.au_id = au_id;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", au_id=" + au_id +
                '}';
    }
}
