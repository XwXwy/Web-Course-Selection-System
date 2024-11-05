package com.sunbw.demo.mapper;

import com.sunbw.demo.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StuMapper {

    @Insert("INSERT INTO t_choices (stuname,coursename,teachername,stuid,courseid) VALUES (#{studentName}, #{courseName},#{teacherName},#{stuId},#{courseId})")
    int insertChoice(@Param("studentName") String stuName, @Param("courseName") String courseName,@Param("teacherName") String teacherName,@Param("stuId") int stuId,@Param("courseId") int courseId);

    @Delete("DELETE FROM t_choices WHERE courseid = #{courseId} AND stuname = #{studentName}")
    int deleteChoice(@Param("studentName") String stuName, @Param("courseId") int courseId,@Param("teacherName") String teacherName);

    @Select("SELECT c.courseid, c.coursename, c.teachername, c.size, c.describe, IFNULL(s.student_count, 0) AS now " +
            "FROM (SELECT DISTINCT courseid FROM t_choices WHERE stuName = #{studentName}) AS choices " +
            "INNER JOIN t_courses c ON choices.courseid = c.courseid " +
            "LEFT JOIN (SELECT courseid, COUNT(*) AS student_count FROM t_choices GROUP BY courseid) s " +
            "ON c.courseid = s.courseid")
    List<Course> listMyCourses(@Param("studentName") String studentName);
}
