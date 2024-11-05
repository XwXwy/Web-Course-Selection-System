package com.sunbw.demo.request;

public class UpdateCourseRequest {
    private Integer courseid;
    private String name;
    private String describe;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateCourseRequest(Integer courseid, String name, String describe) {
        this.courseid = courseid;
        this.name = name;
        this.describe = describe;
    }

    public UpdateCourseRequest() {}
}
