package com.sunbw.demo.controller;


import com.sunbw.demo.biz.AdminBiz;
import com.sunbw.demo.entity.Course;
import com.sunbw.demo.entity.User;
import com.sunbw.demo.request.UpdateCourseRequest;
import com.sunbw.demo.request.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminBiz biz;

    @RequestMapping("/listStu")
    public Map getStuList(){
        List<User> list=biz.getStudentList();

        Map map = new HashMap();
        map.put("isOk",true);
        map.put("students",list);
        map.put("msg","学生列表查询成功");
        return map;

    }

    @RequestMapping("/listTea")
    public Map getTeacherList(){
        List<User> list=biz.getTeacherList();

        Map map = new HashMap();
        map.put("isOk",true);
        map.put("teachers",list);
        map.put("msg","教师列表查询成功");
        return map;

    }


    @RequestMapping("/listCourse")
    public Map getCourseList(){
        List<Course> list=biz.getCourseListAndNow();

        Map map = new HashMap();
        map.put("isOk",true);
        map.put("courses",list);
        map.put("msg","课程列表查询成功");
        return map;

    }

    @RequestMapping("/del")
    public Map deleteStudent(@RequestParam("userid") int userid) {


        boolean isOk=biz.deleteStudent(userid);
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

    @RequestMapping("/update")
    public Map updateUser(@RequestBody UpdateRequest request){

        boolean isOk = biz.updateUser(request.getUserid(),request.getName(),request.getUserpwd());
        Map<String, Object> response = new HashMap<>();

        if (isOk){
            response.put("isOk", true);
            response.put("msg","用户信息修改成功");
        }else {
            response.put("isOk", false);
            response.put("msg","用户信息修改失败");
        }

        return response;
    }

    @RequestMapping("/updateCourse")
    public Map updateCourse(@RequestBody UpdateCourseRequest request, HttpSession session){

        boolean isOk = biz.updateCourse(request.getCourseid(),request.getName(),request.getDescribe());
        Map<String, Object> response = new HashMap<>();

        if (isOk){
            response.put("isOk", true);
            response.put("msg","课程信息修改成功");
        }else {
            response.put("isOk", false);
            response.put("msg","课程信息修改失败");
        }

        return response;

    }

    @RequestMapping("/delCourse")
    public Map deleteCourse(@RequestParam("courseId") int courseid) {


        boolean isOk=biz.deleteCourse(courseid);
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

}
