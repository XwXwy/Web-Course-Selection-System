package com.sunbw.demo.biz;

import com.sunbw.demo.entity.Course;
import com.sunbw.demo.entity.User;
import com.sunbw.demo.mapper.StuMapper;
import com.sunbw.demo.mapper.TeacherMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherBiz {

    @Autowired
    private TeacherMapper mapper;


    public List<Course> getMyCourses(String teacherName){
        return  mapper.listMyCourses(teacherName);
    }

    public boolean deleteMyCourse(int courseId){
        return mapper.deleteCourse(courseId)>0;
    }

    public List<User> getMyStudents(int courseId){

        return  mapper.getUsersByCourseName(courseId);
    }

    public void setMapper(TeacherMapper mapper) {
        this.mapper = mapper;
    }

    public boolean addMyCourse(String coursename, int size, String teachername,String describe){
        return mapper.addCourse(coursename,size,teachername,describe)>0;
    }

    public int checkCourseExists(String teacherName,String coursename){
        return  mapper.checkCourseExists(teacherName,coursename);
    }
}
