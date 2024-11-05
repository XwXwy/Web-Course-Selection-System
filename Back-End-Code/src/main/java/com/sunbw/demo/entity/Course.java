package com.sunbw.demo.entity;

public class Course {
    private Integer courseId;
    private String courseName;
    private String teacherName;
    private Integer size;
    private Integer now;
    private String describe;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNow() {
        return now;
    }

    public void setNow(Integer now) {
        this.now = now;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Course() {}

    public Course(Integer courseId, String courseName, String teacherName, Integer now, Integer size, String describe) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.now = now;
        this.size = size;
        this.describe = describe;
    }
}
