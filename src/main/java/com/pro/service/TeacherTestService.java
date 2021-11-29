package com.pro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pro.domain.TeacherTest;

import java.util.List;

public interface TeacherTestService {
    TeacherTest selectOne(Long test_id);

    TeacherTest createTest(Long user_id,String test_name,String endTime,int ans_num,String ans);

    TeacherTest updateAns(Long test_id,String ans);

    IPage<TeacherTest> pageing(Long user_id,int page,int rows);

    List reAnsStuList(Long test_id);
}
