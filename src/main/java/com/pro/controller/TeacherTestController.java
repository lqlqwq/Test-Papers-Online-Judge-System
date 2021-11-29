package com.pro.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.StuTest;
import com.pro.domain.TeacherTest;
import com.pro.domain.Test;
import com.pro.domain.User;
import com.pro.service.StuTestServiceImpl;
import com.pro.service.TeacherTestServiceImpl;
import com.pro.util.MaxAndMin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TeacherTestController {
    @Resource
    TeacherTestServiceImpl teacherTestService;
    @Resource
    StuTestServiceImpl stuTestService;

    @PostMapping("settest.data")
    @ResponseBody
    public Map settest(String name, int num, String date, String time, HttpServletRequest request, HttpSession session){
        Map map=new HashMap();
        List namelist=new List();
        List anslist=new List();
        User user=(User)session.getAttribute("loginUser");
        String endTime=date+"-"+time;
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm");
//            Date setDate=sdf.parse(date+"-"+time);
//            Calendar calendar=Calendar.getInstance();
//            calendar.setTime(setDate);
        StringBuffer ans=new StringBuffer();
        for (int i=1;i<9;i++){
            namelist.add("ansvalue"+i);
            anslist.add(request.getParameter(namelist.getItem(i-1)));
            ans.append(anslist.getItem(i-1));
        }
        if (ans.length()==num){
            try {
                teacherTestService.createTest(user.getUser_id(),name,endTime,num,ans.toString());
                map.put("code","ok");
                map.put("msg","创建成功！");
            }catch (Exception e){
                e.printStackTrace();
                map.put("msg","创建失败");
            }
        }else {
            map.put("msg","输入答案数量和题目数量不符！");
        }
        return map;
    }

    @PostMapping("searchtest.data")
    @ResponseBody
    public Map searchtest(Long testid,HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser");
        try {
            TeacherTest teacherTest =teacherTestService.selectOne(testid);
            if (teacherTest.getUser_id()==user.getUser_id()){
                map.put("code","ok");
                map.put("msg","搜索成功！");
                map.put("teacherTest",teacherTest);
            }else {map.put("msg","搜索失败，请输入正确的考试ID！");}
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","搜索失败，请输入正确的考试ID！");
        }
        return map;
    }

    @PostMapping("revise.data")
    @ResponseBody
    public Map revise(Long hideid,HttpSession session,HttpServletRequest request){
        Map map=new HashMap();
        List namelist=new List();
        List anslist=new List();
        User user=(User)session.getAttribute("loginUser");
        StringBuffer ans=new StringBuffer();
        for (int i=1;i<9;i++){
            namelist.add("revisevalue"+i);
            anslist.add(request.getParameter(namelist.getItem(i-1)));
            ans.append(anslist.getItem(i-1));
        }
        if (teacherTestService.selectOne(hideid).getUser_id()==user.getUser_id()){
            try {
                teacherTestService.updateAns(hideid,ans.toString());
                teacherTestService.reAnsStuList(hideid);
                map.put("code","ok");
                map.put("msg","修改成功！");
            }catch (Exception e){
                e.printStackTrace();
                map.put("msg","修改失败！");
            }
        }else {map.put("msg","狗东西改数据是吧，别给我逮着了，不然有你好果汁吃");}
        return map;
    }

    @PostMapping("testList.data")
    @ResponseBody
    public Map TestList(int page,HttpSession session){
        Map map=new HashMap();
        User user=(User)session.getAttribute("loginUser");
        IPage<TeacherTest> testIPage=teacherTestService.pageing(user.getUser_id(),page,13);
        map.put("ans",testIPage);
        java.util.List<TeacherTest> ansList=testIPage.getRecords();
        java.util.List boxList=new ArrayList();
        for (int i = 0; i < ansList.size(); i++) {
            Test box=new Test();
            java.util.List stulist=stuTestService.selectTest(ansList.get(i).getTest_id());
            box.setFinishNum(stulist.size());
            Double avgScore=0.00;
            for (int a = 0; a <stulist.size() ; a++) {
                StuTest allTest=(StuTest)stulist.get(a);
                avgScore=avgScore+allTest.getScore();
            }
            if (avgScore!=0.00){avgScore=new BigDecimal(avgScore/stulist.size()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();}    //解决没人交卷的空值问题
            box.setAvgScore(avgScore);
            boxList.add(box);
        }
        map.put("info",boxList);
        return map;
    }

    @PostMapping("goTeacherStatus")
    @ResponseBody
    public Map goTeacherStatus(String testid,HttpSession session){
        //System.out.println("---------"+testid+"-----------");
        Map map=new HashMap();
        TeacherTest teacherTest=teacherTestService.selectOne(Long.parseLong(testid));
        session.setAttribute("teacherTest",teacherTest);
        map.put("code","ok");
        return map;
    }

    @PostMapping("getTeacherTest.data")
    @ResponseBody
    public Map getTeacherTestData(HttpSession session){
        Map map=new HashMap();
        TeacherTest teacherTest=(TeacherTest)session.getAttribute("teacherTest");
        String str=teacherTest.getOriginal_ans();
        java.util.List ansList=new ArrayList();
        java.util.List<StuTest> stuList=stuTestService.selectTest(teacherTest.getTest_id());
        Double maxScore=0.0,minScore=100.0,avgScore=0.0;
        for (int i = 0; i < stuList.size(); i++) {
            avgScore=avgScore+stuList.get(i).getScore();
            if (stuList.get(i).getScore()>maxScore){maxScore=stuList.get(i).getScore();}
            if (stuList.get(i).getScore()<minScore){minScore=stuList.get(i).getScore();}
        }
        avgScore=new BigDecimal(avgScore/stuList.size()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        map.put("finishNum",stuList.size());
        map.put("avgScore",avgScore);
        map.put("maxScore",maxScore);
        map.put("minScore",minScore);
        for (int i = 1; i <= teacherTest.getAns_num(); i++) {
            Test box=new Test();
            box.setOrder(i);
            String teaAns=Character.toString(str.charAt(i-1));
            box.setTeacherAns(teaAns);
            int ansA=0,ansB=0,ansC=0,ansD=0,ansRight=0,ansNull=0;
            for (int j = 0; j < stuList.size(); j++) {
                String ans=stuList.get(j).getOriginal_ans().substring(i-1,i);
                if (ans.equals("A")){ansA=ansA+1;}
                else if (ans.equals("B")){ansB=ansB+1;}
                else if (ans.equals("C")){ansC=ansC+1;}
                else if (ans.equals("D")){ansD=ansD+1;}
                else {ansNull=ansNull+1;}
            }
            if (teaAns.equals("A")){ansRight=ansA;int wrongNum[]={ansB,ansC,ansD};box.setWrongNum(MaxAndMin.getMaxNum(wrongNum));}
            else if (teaAns.equals("B")){ansRight=ansB;int wrongNum[]={ansA,ansC,ansD};box.setWrongNum(MaxAndMin.getMaxNum(wrongNum));}
            else if (teaAns.equals("C")){ansRight=ansC;int wrongNum[]={ansB,ansA,ansD};box.setWrongNum(MaxAndMin.getMaxNum(wrongNum));}
            else if (teaAns.equals("D")){ansRight=ansD;int wrongNum[]={ansB,ansC,ansA};box.setWrongNum(MaxAndMin.getMaxNum(wrongNum));}
            box.setAnsA(ansA);
            box.setAnsB(ansB);
            box.setAnsC(ansC);
            box.setAnsD(ansD);
            box.setAnsNull(ansNull);
            box.setAnsRight(ansRight);
            box.setTruePercent(new BigDecimal(ansRight*100/stuList.size()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
            box.setWrongNum(stuList.size()-ansRight);
            ansList.add(box);
        }
        map.put("num",teacherTest.getAns_num());
        map.put("ansList",ansList);
        map.put("testid",teacherTest.getTest_id());
        return map;
    }

    @PostMapping("stuDetail.data")
    @ResponseBody
    public Map goStuDetail(String stuid,String testid,HttpSession session){
        Map map=new HashMap();
        StuTest stuTest=stuTestService.searchTest(Long.parseLong(stuid),Long.parseLong(testid));
        session.setAttribute("stuTest",stuTest);
        map.put("code","ok");
        System.out.println("------------"+stuid+"---------------");
        return map;
    }
}
