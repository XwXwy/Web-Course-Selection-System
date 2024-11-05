package com.sunbw.demo.controller;

import com.sunbw.demo.biz.StuBiz;
import com.sunbw.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuBiz biz;


    @RequestMapping("/chooseCourse")
    public Map chooseCourse(@RequestBody Map request) {

        String stuName = (String) request.get("studentName");
        String courseName = (String) request.get("courseName");
        String teacherName = (String) request.get("teacherName");

        int stuId = (int) request.get("stuId");
        int courseId = (int) request.get("courseId");
        boolean isOk = biz.chooseCourse(stuName, courseName, teacherName,stuId,courseId);
        Map response = new HashMap<>();
        response.put("isOk", isOk);
        response.put("msg", isOk ? "选课成功" : "选课失败");
        return response;
    }

    @RequestMapping("/mylist")
    public Map getMyCourseList(@RequestBody Map request){
        String studentName = (String) request.get("studentName");
        List<Course> list=biz.getMyChoices(studentName);

        Map map = new HashMap();

        map.put("isOk",true);
        map.put("courses",list);
        map.put("msg","选课列表查询成功");
        return map;

    }

    @PostMapping("/deleteChoice")
    public Map deleteChoice(@RequestBody Map request) {

        String stuName = (String) request.get("studentName");
        int courseId = (int) request.get("courseId");
        String teacherName = (String) request.get("teacherName");
        boolean isOk = biz.deleteCourse(stuName, courseId, teacherName);
        Map response = new HashMap<>();
        response.put("isOk", isOk);
        response.put("msg", isOk ? "退课成功" : "退课失败");
        return response;
    }

}
