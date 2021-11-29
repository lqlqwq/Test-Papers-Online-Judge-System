package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pro.dao.StuTestDao;
import com.pro.dao.TeacherTestDao;
import com.pro.dao.UserDao;
import com.pro.domain.StuTest;
import com.pro.domain.TeacherTest;
import com.pro.opencv.OpenCV;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StuTestServiceImpl implements StuTestService {
    @Resource
    StuTestDao stuTestDao;
    @Resource    //也可以用Autowired
    TeacherTestDao teaTestDao;
    @Override
    public StuTest selectOne(Long id) {
        StuTest stuTest=new StuTest();
        stuTest=stuTestDao.selectById(id);
        return stuTest;
    }

    @Override
    public StuTest createAns(Long user_id, Long test_id, String url) {
        Map map= OpenCV.openCV(url);
        StuTest stuTest=new StuTest();
        stuTest.setUser_id(user_id);
        stuTest.setTest_id(test_id);
        Date date=new Date();
        date.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        stuTest.setCreatetime(sdf.format(date));
        TeacherTest teacherTest=teaTestDao.selectById(test_id);
        stuTest.setEndtime(teacherTest.getEndtime());
        stuTest.setTest_name(teacherTest.getTest_name());
        int ans_num=teacherTest.getAns_num();
        String teacherAns=teacherTest.getOriginal_ans();
        stuTest.setAns_num(ans_num);
        StringBuffer str = new StringBuffer();
        int score=0;
        double trueScore=0.0;
        for (int i = 1; i <= ans_num; i++) {
            if (map.get(i) == null) {
                str.append(1);
            } else {
                str.append(map.get(i));
            }
        }
        for (int i = 1; i <= ans_num; i++){
            if (str.substring((i-1),i).equals(teacherAns.substring((i-1),i))){
                score=score+1;
            }
        }
        if (score!=0){trueScore=new BigDecimal((float)score*100/ans_num).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();}   //round half up 四舍五入  setScale 保留一位小数 double  doubleValue结果转化为double
        stuTest.setOriginal_ans(str.toString());
        stuTest.setScore(trueScore);
        stuTestDao.insert(stuTest);
        return stuTest;
    }

    @Override
    public StuTest searchTest(Long user_id, Long test_id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",user_id);
        queryWrapper.eq("test_id",test_id);
        StuTest stuTest=stuTestDao.selectOne(queryWrapper);
        return stuTest;
    }

    @Override
    public List stuList(Long user_id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",user_id);
        queryWrapper.orderByDesc("id");
        List list=stuTestDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public List selectTest(Long test_id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("test_id",test_id);
        List list=stuTestDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public List selectTestASC(Long test_id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("test_id",test_id);
        queryWrapper.orderByAsc("id");
        List list=stuTestDao.selectList(queryWrapper);
        return list;
    }

    public void update(StuTest stuTest){
        stuTestDao.updateById(stuTest);
    }
}
