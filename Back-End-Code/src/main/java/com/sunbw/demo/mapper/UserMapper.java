package com.sunbw.demo.mapper;

import com.sunbw.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_users")
    List<User> selectUsers();

    @Select("select * from t_users where usernum=#{usernum}")
    User selectUsersByNum(String usernum);

    //@Insert("insert into t_users(null,usernum,userpwd,name,role) values (null,#{usernum},#{userpwd},#{name},#{role})")
    @Insert("insert into t_users values (null,#{usernum},#{userpwd},#{name},#{role})")
    int insertUser(User user);

    @Select("SELECT COUNT(*) FROM t_users WHERE usernum = #{usernum}")
    int checkUsernumExists(String usernum);
}
