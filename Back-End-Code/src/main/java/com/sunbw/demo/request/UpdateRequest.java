package com.sunbw.demo.request;

public class UpdateRequest {

    private Integer userid;
    private String name;
    private String userpwd;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public UpdateRequest(Integer userid, String name, String userpwd) {
        this.userid = userid;
        this.name = name;
        this.userpwd = userpwd;
    }

    public UpdateRequest() {

    }
}
