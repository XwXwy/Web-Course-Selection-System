package com.sunbw.demo.mapper;

import com.sunbw.demo.entity.Course;
import com.sunbw.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from t_users where role='student'")
    List<User> selectStudents();


    @Select("select * from t_users where role='teacher'")
    List<User> selectTeachers();

    @Select("select * from t_courses")
    List<Course> selectCourses();

    @Delete("delete from t_users where userid=#{userid}")
    int deleteStudentById(int userid);

    @Delete("delete from t_courses where courseid=#{courseid}")
    int deleteCourseById(int courseid);

    @Update("Update t_users set name = #{name},userpwd = #{userpwd} where userid = #{userid}")
    int updateUser(@Param("userid") int userid,@Param("name") String name,@Param("userpwd") String userpwd);


    @Update("Update t_courses set coursename = #{name},`describe` = #{describe} where courseid = #{courseid}")
    int updateCourse(@Param("courseid") int courseid,@Param("name") String name,@Param("describe") String describe);

//    @Select("SELECT c.courseid, c.coursename, c.teachername, c.size, c.describe, IFNULL(s.student_count, 0) AS now FROM t_courses c LEFT JOIN (SELECT coursename, COUNT(*) AS student_count FROM t_choices GROUP BY coursename) s ON c.coursename = s.coursename")
//    List<Course> listCoursesWithCount();

    @Select("SELECT c.courseid, c.coursename, c.teachername, c.size, c.describe, IFNULL(s.student_count, 0) AS now FROM t_courses c LEFT JOIN (SELECT courseid, COUNT(*) AS student_count FROM t_choices GROUP BY courseid) s ON c.courseid = s.courseid")
    List<Course> listCoursesWithCount();

}
