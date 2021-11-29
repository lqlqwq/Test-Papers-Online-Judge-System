package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pro.dao.StuMesDao;
import com.pro.domain.StuMes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuMesServiceImpl implements StuMesService {
    @Resource
    StuMesDao stuMesDao;
    @Override
    public StuMes selectOne(int id) {
        StuMes stuMes=new StuMes();
        stuMes=stuMesDao.selectById(id);
        return stuMes;
    }

    @Override
    public StuMes addNewMes(StuMes stuMes) {
        stuMesDao.insert(stuMes);
        return stuMes;
    }

    @Override
    public List findAllMes(Long testid, Long mes_num) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("test_id",testid);
        queryWrapper.eq("mes_num",mes_num);
        List list=stuMesDao.selectList(queryWrapper);
        return list;
    }
}
