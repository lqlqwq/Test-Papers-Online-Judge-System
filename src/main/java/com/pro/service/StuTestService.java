package com.pro.service;

import com.pro.domain.StuTest;
import com.pro.domain.TeacherTest;

import java.util.List;

public interface StuTestService {
    StuTest selectOne(Long id);

    StuTest createAns(Long user_id,Long test_id,String url);

    StuTest searchTest(Long user_id,Long test_id);

    List stuList(Long user_id);

    List selectTest(Long test_id);

    List selectTestASC(Long test_id);
}
