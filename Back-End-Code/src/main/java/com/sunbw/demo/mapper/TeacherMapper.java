package com.sunbw.demo.mapper;

import com.sunbw.demo.entity.Course;
import com.sunbw.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper {

//    @Select("SELECT c.courseid, c.coursename, c.teachername, c.size, c.describe, IFNULL(s.student_count, 0) AS now " +
//            "FROM (SELECT * FROM t_courses WHERE teachername = #{teacherName}) AS c " +
//            "LEFT JOIN (SELECT courseName, COUNT(*) AS student_count FROM t_choices GROUP BY courseName) s " +
//            "ON c.coursename = s.courseName")
//    List<Course> listMyCourses(@Param("teacherName") String teacherName);

    @Select("SELECT c.courseid, c.coursename, c.teachername, c.size, c.describe, IFNULL(s.student_count, 0) AS now " +
            "FROM (SELECT * FROM t_courses WHERE teachername = #{teacherName}) AS c " +
            "LEFT JOIN (SELECT courseid, COUNT(*) AS student_count FROM t_choices GROUP BY courseid) s " +
            "ON c.courseid = s.courseid")
    List<Course> listMyCourses(@Param("teacherName") String teacherName);

    @Delete("DELETE FROM t_courses WHERE courseid = #{courseId}")
    int deleteCourse(@Param("courseId") int courseId);

    @Select("SELECT u.userid, u.usernum, u.`name`, u.role " +
            "FROM t_choices c " +
            "JOIN t_users u ON c.stuid = u.userid " +
            "WHERE c.courseId = #{courseId}")
    List<User> getUsersByCourseName(@Param("courseId") int courseId);

    @Insert("INSERT INTO t_courses (coursename, teachername, size, `describe`) " +
            "VALUES (#{coursename}, #{teachername}, #{size}, #{describe})")
    int addCourse(@Param("coursename") String coursename,@Param("size") int size,@Param("teachername") String teachername,@Param("describe") String describe);


    @Select("SELECT COUNT(*) FROM t_courses WHERE teachername = #{teacherName} AND coursename = #{coursename}")
    int checkCourseExists(@Param("teacherName") String teacherName, @Param("coursename") String coursename);
}
