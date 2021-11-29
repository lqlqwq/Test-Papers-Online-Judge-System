package com.pro.controller;

import com.pro.domain.User;
import com.pro.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class DataController {
    @Resource
    UserServiceImpl userService;

    @PostMapping("registet.data")
    @ResponseBody
    public Map regist(String username, String password, String nickname, String vc, int type, HttpServletRequest request){
        Map map=new HashMap();
        String verifyCode=(String)request.getSession().getAttribute("verifyCode");
        if (vc==null||verifyCode==null||!vc.equalsIgnoreCase(verifyCode)){
            map.put("code","err-vc");
            map.put("msg","验证码错误");
        }else{
            try {
                User user=userService.createUser(username,password,nickname,type);
                map.put("code","ok-vc");
                map.put("msg","注册成功！");
                map.put("user",user);
            }catch (ServiceException e){
                map.put("code",e.getCode());
                map.put("msg",e.getMsg());
            }
        }
        return map;
    }

    @PostMapping("login.data")
    @ResponseBody
    public Map checkLogin(String username, String password, String vc, HttpSession session){ //String checked
        Map map=new HashMap();
        String verifyCode=(String)session.getAttribute("verifyCode");
//        try {                                          //try catch防止checked空值报错
//            if (checked.equals("1")) {
//                session.setMaxInactiveInterval(-1);
//            }
//        } catch (Exception e){}
        if (vc==null||verifyCode==null||!vc.equalsIgnoreCase(verifyCode)){
            map.put("code","err-vc");
            map.put("msg","验证码错误");
        }else{
            try {
                User user=userService.checkLogin(username,password);
                session.setAttribute("loginUser",user);   //设置为null间接清除seeeion
                session.setMaxInactiveInterval(3600);          //一小时过期
                //session.setMaxInactiveInterval(0);   设置session最大保留时间，-1位永不过期
                //session.removeAttribute();   清除session
                map.put("code", "ok-vc");
                map.put("msg", "登录成功");
                map.put("usertype", user.getUser_type());
            }catch (ServiceException e){
                map.put("code",e.getCode());
                map.put("msg",e.getMsg());
            }
        }
        return map;
    }

    @PostMapping("logout.data")
    @ResponseBody
    public Map logout(HttpSession session){
        Map map=new HashMap();
        try {
            session.removeAttribute("loginUser");
            map.put("code","ok-logout");
            map.put("msg","退出登录成功！");
        }catch (ServiceException e){
            map.put("msg","退出登录失败");
        }
        return map;
    }

    @PostMapping("repassword.data")
    @ResponseBody
    public Map repassword(String oldpw,String newpw,HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser");
        Long id=user.getUser_id();
        try {
            userService.updatePassword(id,oldpw,newpw);
            session.removeAttribute("loginUser");
            map.put("code","ok-logout");
            map.put("msg","修改成功，请重新登录！");
        }catch (ServiceException e){
            map.put("msg",e.getMsg());
        }
        return map;
    }

    @PostMapping("renickname.data")
    @ResponseBody
    public Map renickname(String nickname,HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser");
        try {
            User newUser=userService.updateNickname(user.getUser_id(),nickname);
            session.setAttribute("loginUser",newUser);
            map.put("code","ok");
            map.put("msg","修改成功！");
        }catch (Exception e){
            map.put("msg","修改失败");
        }
        return map;
    }

    @PostMapping("username.data")
    @ResponseBody
    public Map username(String username){
        Map map=new HashMap();
        List list=userService.namecheck(username,"user_name");
        if (list.size()>0){
            map.put("code","no");
        }else {
            map.put("code","ok");
        }
        return map;
    }

    @PostMapping("nickname.data")
    @ResponseBody
    public Map nickname(String nickname){
        Map map=new HashMap();
        List list=userService.namecheck(nickname,"user_nickname");
        if (list.size()>0){
            map.put("code","no");
        }else {
            map.put("code","ok");
        }
        return map;
    }

//    @PostMapping("settest.data")
//    @ResponseBody
//    public Map settest(String name,int num,String date,String time,HttpServletRequest request,HttpSession session){
//        Map map=new HashMap();
//        List namelist=new List();
//        List anslist=new List();
//        User user=(User)session.getAttribute("loginUser");
//        String endTime=date+"-"+time;
////            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm");
////            Date setDate=sdf.parse(date+"-"+time);
////            Calendar calendar=Calendar.getInstance();
////            calendar.setTime(setDate);
//        StringBuffer ans=new StringBuffer();
//        for (int i=1;i<9;i++){
//            namelist.add("ansvalue"+i);
//            anslist.add(request.getParameter(namelist.getItem(i-1)));
//            ans.append(anslist.getItem(i-1));
//        }
//        if (ans.length()==num){
//            try {
//                teacherTestService.createTest(user.getUser_id(),name,endTime,num,ans.toString());
//                map.put("code","ok");
//                map.put("msg","创建成功！");
//            }catch (Exception e){
//                e.printStackTrace();
//                map.put("msg","创建失败");
//            }
//        }else {
//            map.put("msg","输入答案数量和题目数量不符！");
//        }
//        return map;
//    }
//
//    @PostMapping("searchtest.data")
//    @ResponseBody
//    public Map searchtest(Long testid,HttpSession session){
//        Map map=new HashMap();
//        User user=(User)session.getAttribute("loginUser");
//        try {
//            TeacherTest teacherTest =teacherTestService.selectOne(testid);
//            if (teacherTest.getUser_id()==user.getUser_id()){
//                map.put("code","ok");
//                map.put("msg","搜索成功！");
//                map.put("teacherTest",teacherTest);
//            }else {map.put("msg","搜索失败，请输入正确的考试ID！");}
//        }catch (Exception e){
//            e.printStackTrace();
//            map.put("msg","搜索失败，请输入正确的考试ID！");
//        }
//        return map;
//    }
}
