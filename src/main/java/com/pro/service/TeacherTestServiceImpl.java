package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pro.dao.TeacherTestDao;
import com.pro.domain.StuTest;
import com.pro.domain.TeacherTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TeacherTestServiceImpl implements TeacherTestService {
    @Resource
    TeacherTestDao teacherTestDao;
    @Resource
    StuTestServiceImpl stuTestService;
    @Override
    public TeacherTest selectOne(Long test_id) {
        TeacherTest teacherTest=new TeacherTest();
        teacherTest=teacherTestDao.selectById(test_id);
        return teacherTest;
    }

    @Override
    public TeacherTest createTest(Long user_id, String test_name, String endTime, int ans_num, String ans) {
        TeacherTest teacherTest=setAns(ans,ans_num);
        teacherTest.setUser_id(user_id);
        teacherTest.setTest_name(test_name);
        teacherTest.setEndtime(endTime);
        teacherTest.setStatus(1);
        Date date=new Date();
        date.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        teacherTest.setCreatetime(sdf.format(date));
        teacherTest.setOriginal_ans(ans);
        teacherTestDao.insert(teacherTest);
        return teacherTest;
    }

    @Override
    public TeacherTest updateAns(Long test_id, String ans) {
        TeacherTest original=teacherTestDao.selectById(test_id);
        TeacherTest teacherTest=setAns(ans,original.getAns_num());
        teacherTest.setOriginal_ans(ans);
        teacherTest.setTest_id(test_id);
        teacherTest.setStatus(1);
        teacherTest.setAns_num(original.getAns_num());
        System.out.println(ans);
        teacherTestDao.updateById(teacherTest);
        return null;
    }

    @Override
    public IPage<TeacherTest> pageing(Long user_id, int page, int rows) {
        Page<TeacherTest> p=new Page<>(page,rows);
        QueryWrapper<TeacherTest> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",user_id);
        queryWrapper.orderByDesc("test_id");
        IPage<TeacherTest> testIPage=teacherTestDao.selectPage(p,queryWrapper);
        return testIPage;
    }

    @Override
    public List reAnsStuList(Long test_id) {
        TeacherTest teacherTest=selectOne(test_id);
        List<StuTest> stuList=stuTestService.selectTest(test_id);
        String teacherAns=teacherTest.getOriginal_ans();
        int ans_num=teacherTest.getAns_num();
        for (int a = 0; a < stuList.size(); a++) {
            int score=0;
            double trueScore=0.0;
            StuTest stuTest=stuList.get(a);
            String str=stuTest.getOriginal_ans();
            for (int i = 1; i <= ans_num; i++){
                if (str.substring((i-1),i).equals(teacherAns.substring((i-1),i))){
                    score=score+1;
                }
            }
            if (score!=0){trueScore=new BigDecimal((float)score*100/ans_num).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();}   //round half up 四舍五入  setScale 保留一位小数 double  doubleValue结果转化为double
            stuTest.setScore(trueScore);
            stuTestService.update(stuTest);
        }
        return null;
    }


    public TeacherTest setAns(String ans,int num){
        TeacherTest teacherTest=new TeacherTest();          //优化写法见StuTestSI
        int a=40-num;
        StringBuffer sb=new StringBuffer(ans);
        for (int i=1;i<=a;i++){
            sb.append(2);
        }
        teacherTest.setAns_num(num);
        teacherTest.setAns1(sb.substring(0,1));
        teacherTest.setAns2(sb.substring(1,2));
        teacherTest.setAns3(sb.substring(2,3));
        teacherTest.setAns4(sb.substring(3,4));
        teacherTest.setAns5(sb.substring(4,5));
        teacherTest.setAns6(sb.substring(5,6));
        teacherTest.setAns7(sb.substring(6,7));
        teacherTest.setAns8(sb.substring(7,8));
        teacherTest.setAns9(sb.substring(8,9));
        teacherTest.setAns10(sb.substring(9,10));
        teacherTest.setAns11(sb.substring(10,11));
        teacherTest.setAns12(sb.substring(11,12));
        teacherTest.setAns13(sb.substring(12,13));
        teacherTest.setAns14(sb.substring(13,14));
        teacherTest.setAns15(sb.substring(14,15));
        teacherTest.setAns16(sb.substring(15,16));
        teacherTest.setAns17(sb.substring(16,17));
        teacherTest.setAns18(sb.substring(17,18));
        teacherTest.setAns19(sb.substring(18,19));
        teacherTest.setAns20(sb.substring(19,20));
        teacherTest.setAns21(sb.substring(20,21));
        teacherTest.setAns22(sb.substring(21,22));
        teacherTest.setAns23(sb.substring(22,23));
        teacherTest.setAns24(sb.substring(23,24));
        teacherTest.setAns25(sb.substring(24,25));
        teacherTest.setAns26(sb.substring(25,26));
        teacherTest.setAns27(sb.substring(26,27));
        teacherTest.setAns28(sb.substring(27,28));
        teacherTest.setAns29(sb.substring(28,29));
        teacherTest.setAns30(sb.substring(29,30));
        teacherTest.setAns31(sb.substring(30,31));
        teacherTest.setAns32(sb.substring(31,32));
        teacherTest.setAns33(sb.substring(32,33));
        teacherTest.setAns34(sb.substring(33,34));
        teacherTest.setAns35(sb.substring(34,35));
        teacherTest.setAns36(sb.substring(35,36));
        teacherTest.setAns37(sb.substring(36,37));
        teacherTest.setAns38(sb.substring(37,38));
        teacherTest.setAns39(sb.substring(38,39));
        teacherTest.setAns40(sb.substring(39,40));
        return teacherTest;
    }
}
