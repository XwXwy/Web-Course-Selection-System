package com.sunbw.demo.entity;

public class User {

    private Integer userid;
    private String usernum;
    private String userpwd;
    private String name;
    private String role;

    public User(){

    }

    public User(Integer userid, String usernum, String userpwd, String name, String role) {
        this.userid = userid;
        this.usernum = usernum;
        this.userpwd = userpwd;
        this.name = name;
        this.role = role;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userid + '\'' +
                ", userNum='" + usernum + '\'' +
                ", userPwd='" + userpwd + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
