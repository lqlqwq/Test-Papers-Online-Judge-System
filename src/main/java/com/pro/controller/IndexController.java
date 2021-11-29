package com.pro.controller;

import com.pro.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index1(){return "index";}

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/index")
    public String index(){return "index";}

    @GetMapping("/teacher-main")
    public String teachermain(){return "teacher-main";}

    @GetMapping("/stu-main")
    public String stumain(){return "stu-main";}

    @GetMapping("/teacher-info")
    public String teainfo(){return "teacher-info";}

    @GetMapping("/stu-info")
    public String stuinfo(){return "stu-info";}

    @GetMapping("/stu-score")
    public String stuscore(){return "stu-score";}

    @GetMapping("/teacher-create")
    public String teachercreate(){return "teacher-create";}

    @GetMapping("/stu-test")
    public String stutest(){return "stu-test";}

    @GetMapping("/teacher-stu")
    public String teacherstu(){return "teacher-stu";}

    @GetMapping("/teacher-status")
    public String teacherstatus(){return "teacher-status";}
}
