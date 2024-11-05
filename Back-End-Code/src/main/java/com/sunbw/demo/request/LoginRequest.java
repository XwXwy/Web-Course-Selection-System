package com.sunbw.demo.request;

public class LoginRequest {

    private String usernum;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String username) {
        this.usernum = username;
    }

    public LoginRequest(String username, String password,String role) {
        this.usernum = username;
        this.password = password;
        this.role = role;
    }

    public LoginRequest() {}
}
