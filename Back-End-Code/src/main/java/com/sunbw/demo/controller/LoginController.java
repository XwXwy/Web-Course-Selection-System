package com.sunbw.demo.controller;


import com.sunbw.demo.biz.UserBiz;
import com.sunbw.demo.entity.User;
import com.sunbw.demo.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {


    @Autowired
    private UserBiz biz;


    @RequestMapping("/login")
    public Map login(@RequestBody LoginRequest request, HttpSession session){
        List<User> list=biz.getUserList();

        String userNum=request.getUsernum();
        String userPwd=request.getPassword();
        String role = request.getRole();
        Map map = new HashMap();
        int loginFlag=0;
        for(User user:list){

            if (user.getUsernum().equals(userNum)&&user.getUserpwd().equals(userPwd)){

                map.put("isOk",true);
                map.put("user",userNum);
                map.put("role",user.getRole());
                map.put("msg","登录成功");
                loginFlag=1;
                session.setAttribute("userid",user.getUserid());
                session.setAttribute("usernum",userNum);
                session.setAttribute("name",user.getName());
                session.setAttribute("role",user.getRole());

                break;
            }

        }

        if (loginFlag==0){
            map.put("isOk",false);
            map.put("msg","您的账号或密码不正确，请重新输入！");
        }else{


        }
        System.out.println(userNum);


        return map;
    }


    @RequestMapping("/register")
    public Map register(@RequestBody User user){

        Map map = new HashMap();
        if (biz.checkUsernumExists(user.getUsernum()) > 0) {
            map.put("isOk", false);
            map.put("msg", "失败: " + "该教工号已注册！");
            return map;
        }


        try {
            biz.addUser(user);
            map.put("isOk", true);
            map.put("msg", "成功!");
        } catch (Exception e) {
            map.put("isOk", false);
            map.put("msg", "失败!: " + e.getMessage());
        }

        return map;

    }

    @CrossOrigin(origins = "http://127.0.0.1:8848", allowCredentials = "true")
    @RequestMapping("/info")
    public Map getUserInfo(HttpSession session){

        Map userInfo = new HashMap<>();


        // 从 HttpSession 中获取当前登录用户的信息
        String name = (String) session.getAttribute("name");
        String role = (String) session.getAttribute("role");
        int userid = (int) session.getAttribute("userid");
        System.out.println("======"+name+"--------"+role);
        // 如果用户未登录，则返回未授权错误
        if (name == null || role == null) {
            userInfo.put("error", "未登录！");
            return userInfo;
        }

        // 将用户信息放入 userInfo 中
        userInfo.put("name", name);
        userInfo.put("role", role);
        userInfo.put("userid", userid);

        return userInfo;

    }


    @RequestMapping("/exit")
    public Map logout(HttpSession session){
        session.invalidate();

        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","已退出登录！");
        return result;

    }


    public void setBiz(UserBiz biz) {
        this.biz = biz;
    }


}
