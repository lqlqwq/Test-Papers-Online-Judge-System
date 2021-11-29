package com.pro.controller;

import com.pro.domain.StuMes;
import com.pro.domain.StuTest;
import com.pro.domain.TeacherTest;
import com.pro.domain.User;
import com.pro.service.StuMesServiceImpl;
import com.pro.service.StuTestServiceImpl;
import com.pro.service.TeacherTestServiceImpl;
import com.pro.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MesController {
    @Resource
    StuTestServiceImpl stuTestService;
    @Resource
    TeacherTestServiceImpl teacherTestService;
    @Resource
    UserServiceImpl userService;
    @Resource
    StuMesServiceImpl stuMesService;

    @PostMapping("addComment")
    @ResponseBody
    public Map addComment(String testid, String order, String text, HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser") ;
        TeacherTest teacherTest=teacherTestService.selectOne(Long.parseLong(testid));
        StuTest stuTest=stuTestService.searchTest(user.getUser_id(),Long.parseLong(testid));
        session.setAttribute("stuTest",stuTest);
        session.setAttribute("teacherTest",teacherTest);
        StuMes newMes=new StuMes();
        newMes.setUser_id(user.getUser_id());
        newMes.setUser_type(user.getUser_type());
        newMes.setTest_id(Long.parseLong(testid));
        newMes.setMes(text);
        newMes.setUser_nickname(user.getUser_nickname());
        newMes.setMes_num(Integer.parseInt(order));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        Date now=new Date();
        newMes.setMes_time(sdf.format(now));
        stuMesService.addNewMes(newMes);
        map.put("code","ok");
        return map;
    }

    @PostMapping("getMes")
    @ResponseBody
    public Map getMes(String testid,String order){
        List mesList=stuMesService.findAllMes(Long.parseLong(testid),Long.parseLong(order));
        Map map=new HashMap();
        map.put("code","ok");
        map.put("mesList",mesList);
        map.put("mesnum",mesList.size());
        return map;
    }
}
