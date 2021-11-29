package com.pro.service;

import com.pro.domain.StuMes;

import java.util.List;

public interface StuMesService {
    StuMes selectOne(int id);
    StuMes addNewMes(StuMes stuMes);
    List findAllMes(Long testid,Long mes_num);
}
