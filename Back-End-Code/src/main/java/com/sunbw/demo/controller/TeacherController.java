package com.sunbw.demo.controller;


import com.sunbw.demo.biz.StuBiz;
import com.sunbw.demo.biz.TeacherBiz;
import com.sunbw.demo.entity.Course;
import com.sunbw.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherBiz biz;


    @RequestMapping("/mylist")
    public Map getMyCourseList(@RequestBody Map request){
        String teacherName = (String) request.get("teacherName");
        List<Course> list=biz.getMyCourses(teacherName);

        Map map = new HashMap();

        map.put("isOk",true);
        map.put("courses",list);
        map.put("msg","课程列表查询成功");
        return map;

    }

    @RequestMapping("/del")
    public Map deleteCourse(@RequestBody Map request) {


        int courseId = (int) request.get("courseId");
        boolean isOk=biz.deleteMyCourse(courseId);
        Map<String, Object> response = new HashMap<>();
        if (isOk){

            response.put("isOk", true);
            response.put("msg", "删除成功");
        }else{
            response.put("isOk", false);
            response.put("msg", "删除失败");
        }


        return response;
    }


    @RequestMapping("/stulist")
    public Map getMyStuList(@RequestBody Map request){
        int courseId = (int) request.get("courseId");
        List<User> list=biz.getMyStudents(courseId);

        Map map = new HashMap();

        map.put("isOk",true);
        map.put("students",list);
        map.put("msg","选课列表查询成功");
        return map;

    }

    @RequestMapping("/addCourse")
    public Map addCourse(@RequestBody Map request){


        String teacherName = (String) request.get("teacherName");
        String courseName = (String) request.get("courseName");


        int size = Integer.parseInt((String) request.get("size"));
        String describe = (String) request.get("describe");

        Map map = new HashMap();

        if (biz.checkCourseExists(teacherName,courseName) > 0) {
            map.put("isOk", false);
            map.put("msg", "失败: " + "该课程名已存在！");
            return map;
        }

        try {

            biz.addMyCourse(courseName,size,teacherName,describe);
            map.put("isOk", true);
            map.put("msg", "成功!");
        } catch (Exception e) {
            map.put("isOk", false);
            map.put("msg", "失败!: " + e.getMessage());
        }

        return map;

    }
}
