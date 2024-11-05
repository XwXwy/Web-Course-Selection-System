package com.sunbw.demo.biz;

import com.sunbw.demo.entity.Course;
import com.sunbw.demo.mapper.AdminMapper;
import com.sunbw.demo.mapper.StuMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuBiz {

    @Autowired
    private StuMapper mapper;


    public boolean chooseCourse(String stuName,String courseName,String teacherName,int stuId,int courseId){
        return mapper.insertChoice(stuName,courseName,teacherName,stuId,courseId)>0;
    }

    public boolean deleteCourse(String stuName,int courseId,String teacherName){
        return mapper.deleteChoice(stuName,courseId,teacherName)>0;
    }

    public List<Course> getMyChoices(String studentName){
        return  mapper.listMyCourses(studentName);
    }

    public void setMapper(StuMapper mapper) {
        this.mapper = mapper;
    }
}
