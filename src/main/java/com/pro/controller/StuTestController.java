package com.pro.controller;

import com.pro.domain.StuTest;
import com.pro.domain.TeacherTest;
import com.pro.domain.Test;
import com.pro.domain.User;
import com.pro.service.StuTestServiceImpl;
import com.pro.service.TeacherTestServiceImpl;
import com.pro.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StuTestController {
    @Resource
    StuTestServiceImpl stuTestService;
    @Resource
    TeacherTestServiceImpl teacherTestService;
    @Resource
    UserServiceImpl userService;

    @PostMapping("upload.data")
    @ResponseBody
    public Map upload(HttpServletRequest request, HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser");
        String testid=request.getParameter("testid");
        if (stuTestService.searchTest(user.getUser_id(),Long.parseLong(testid))==null){
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
            MultipartFile file = multipartHttpServletRequest.getFile("file");
            if (!file.isEmpty()){
                try {
                    FileOutputStream os=new FileOutputStream("C:/BisheIMG/"+file.getOriginalFilename());
                    InputStream in=file.getInputStream();
                    int b=0;
                    while ((b=in.read())!=-1){os.write(b);}
                    os.flush();
                    in.close();//关闭流
                    os.close();
                }catch (FileNotFoundException e){e.printStackTrace();}
                catch (IOException e){e.printStackTrace();}
                String url="C://BisheIMG//"+file.getOriginalFilename();
                try {
                    StuTest stuTest=stuTestService.createAns(user.getUser_id(),Long.parseLong(testid),url);
                    map.put("code","ok");
                    session.setAttribute("stuTest",stuTest);
                    File file1=new File(url);
                    file1.delete();
                }catch (Exception e) {
                    e.printStackTrace();
                    map.put("msg","请输入正确的考试ID！");
                }
            }
        }else {
            map.put("msg","你已经交过卷了你交锤子呢！");
        }
        return map;
    }

    @PostMapping("getTest.data")
    @ResponseBody
    public Map getData(HttpSession session){
        StuTest stuTest=(StuTest)session.getAttribute("stuTest");
        TeacherTest teacherTest=teacherTestService.selectOne(stuTest.getTest_id());
        String str=stuTest.getOriginal_ans();
        String str2=teacherTest.getOriginal_ans();
        Map map=new HashMap();
        for (int i = 1; i <= stuTest.getAns_num(); i++) {
            Test test=new Test();
            test.setOrder(i);
            if (Character.toString(str.charAt(i-1))!="1"){            //
                test.setYouAns(Character.toString(str.charAt(i-1)));
            }else test.setYouAns("未识别");
            test.setTeacherAns(Character.toString(str2.charAt(i-1)));
            if (test.getTeacherAns().equals(test.getYouAns())){
                test.setStatus("正确");
            }else test.setStatus("错误");
            map.put("num"+i,test);
        }
        map.put("num",stuTest.getAns_num());
        List list=stuTestService.selectTest(stuTest.getTest_id());
        map.put("fininshNum",list.size());
        Double avgScore=0.0;
        for (int i = 0; i <list.size() ; i++) {
            StuTest allTest=(StuTest)list.get(i);
            avgScore=avgScore+allTest.getScore();
        }
        avgScore=new BigDecimal(avgScore/list.size()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        map.put("avgScore",avgScore);
        map.put("testid",stuTest.getTest_id());
        return map;
    }

    @PostMapping("stuList.data")
    @ResponseBody
    public Map stuList(HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser");
        try {
            List list=stuTestService.stuList(user.getUser_id());
            if (list!=null){
                map.put("code","ok");
                map.put("ans",list);
            }else {map.put("msg","未查询到考试信息！");}
        }catch (Exception e){e.printStackTrace();}
        return map;
    }

    @PostMapping("/goScore")
    @ResponseBody
    public Map stuscore(String testid,HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser") ;
        StuTest stuTest=stuTestService.searchTest(user.getUser_id(),Long.parseLong(testid));
        session.setAttribute("stuTest",stuTest);
        map.put("code","ok");
        return map;
    }

    @PostMapping("charts.data")
    @ResponseBody
    public Map charts(int number,String testid){
        Map map=new HashMap();
        String teaAns=teacherTestService.selectOne(Long.parseLong(testid)).getOriginal_ans().substring(number-1,number);
        List stuList=stuTestService.selectTest(Long.parseLong(testid));
        int ansA=0,ansB=0,ansC=0,ansD=0,ansNull=0,ansRight=0;
        for (int i = 0; i <stuList.size() ; i++) {
            StuTest stuTest=(StuTest)stuList.get(i);
            String ans=stuTest.getOriginal_ans().substring(number-1,number);
            if (ans.equals("A")){ansA=ansA+1;}
            else if (ans.equals("B")){ansB=ansB+1;}
            else if (ans.equals("C")){ansC=ansC+1;}
            else if (ans.equals("D")){ansD=ansD+1;}
            else {ansNull=ansNull+1;}
        }
        if (teaAns.equals("A")){ansRight=ansA;}
        else if (teaAns.equals("B")){ansRight=ansB;}
        else if (teaAns.equals("C")){ansRight=ansC;}
        else if (teaAns.equals("D")){ansRight=ansD;}
        map.put("AA",ansA);
        map.put("BB",ansB);
        map.put("CC",ansC);
        map.put("DD",ansD);
        map.put("ansRight",ansRight);
        map.put("ansNull",ansNull);
        map.put("ansAll",stuList.size());
        return map;
    }

    @PostMapping("getStuTest.data")
    @ResponseBody
    public Map getStuTest(HttpSession session){
        TeacherTest teacherTest=(TeacherTest)session.getAttribute("teacherTest");
        List<StuTest> testList=stuTestService.selectTestASC(teacherTest.getTest_id());
        List nameList=new ArrayList();
        for (int i = 0; i < testList.size(); i++) {
           nameList.add(userService.selectOne(testList.get(i).getUser_id()).getUser_nickname());
        }
        Map map=new HashMap();
        map.put("lengthLong",testList.size());
        map.put("testList",testList);
        map.put("nameList",nameList);
        return map;
    }
}
