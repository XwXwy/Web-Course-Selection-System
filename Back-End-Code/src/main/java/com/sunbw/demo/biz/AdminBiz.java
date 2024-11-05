package com.sunbw.demo.biz;

import com.sunbw.demo.entity.Course;
import com.sunbw.demo.entity.User;
import com.sunbw.demo.mapper.AdminMapper;
import com.sunbw.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBiz {


    @Autowired
    private AdminMapper mapper;

    public List<User> getStudentList(){
        return mapper.selectStudents();
    }

    public List<User> getTeacherList(){
        return mapper.selectTeachers();
    }

    public List<Course> getCourseList(){
        return mapper.selectCourses();
    }

    public boolean deleteStudent(int userid){


        return mapper.deleteStudentById(userid)>0;
    }

    public boolean deleteCourse(int courseid){

        return mapper.deleteCourseById(courseid)>0;
    }

    public boolean updateUser(int userid,String name,String userpwd){
        return mapper.updateUser(userid,name,userpwd)>0;
    }

    public boolean updateCourse(int courseid,String name,String describe){
        return mapper.updateCourse(courseid,name,describe)>0;
    }

    public List<Course> getCourseListAndNow(){
        return mapper.listCoursesWithCount();
    }

}
