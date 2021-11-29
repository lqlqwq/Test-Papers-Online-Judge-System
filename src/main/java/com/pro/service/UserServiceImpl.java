package com.pro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pro.dao.UserDao;
import com.pro.domain.User;
import com.pro.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource    //也可以用Autowired
    UserDao userDao;
    @Override
    public User selectOne(Long id) {
        User user=userDao.selectById(id);
        return user;
    }

    @Override
    public User createUser(String user_name, String user_password, String user_nickname, int user_type) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_name",user_name);

        List<User> userList=userDao.selectList(queryWrapper);      //通过查找用户名集合  判断返回值大于0则已经有重复
        if (userList.size()>0){
            throw new ServiceException("666","憨批，用户名被人注册了");
        }
        User user=new User();
        user.setUser_name(user_name);
        user.setUser_nickname(user_nickname);
        user.setUser_type(user_type);
        String md5= MD5Util.MD5Digest(user_password);
        user.setUser_password(md5);
        userDao.insert(user);
        return user;
    }

    @Override
    public User checkLogin(String user_name, String user_password) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_name",user_name);

        User user=userDao.selectOne(queryWrapper);
        if (user==null){
            throw new ServiceException("666","用户名输错了，傻狗");
        }//可以走到这说明有这个用户
        String Md5=MD5Util.MD5Digest(user_password);
        if (!Md5.equalsIgnoreCase(user.getUser_password())){
            throw new ServiceException("777","盗号Dog，密码错了");
        }//走到这里说明用户名密码都正确
        return user;
    }

    @Override
    public User updatePassword(Long id, String oldpw, String newpw) {
        String oldpwMd5=MD5Util.MD5Digest(oldpw);
        User user=selectOne(id);
        String truepw=user.getUser_password();
        if (oldpwMd5.equals(truepw)){
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("user_id",user.getUser_id());
            String newpwMd5=MD5Util.MD5Digest(newpw);
            user.setUser_password(newpwMd5);
            userDao.updateById(user);
        }else throw new ServiceException("233","笨比,密码忘了你怎么上来的???");
        return null;
    }

    @Override
    public User updateNickname(Long id,String nickname) {
        User user=selectOne(id);
        user.setUser_nickname(nickname);
        userDao.updateById(user);
        return user;
    }

    @Override
    public List namecheck(String name, String colum) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq(colum,name);
        List list=userDao.selectList(queryWrapper);
        return list;
    }

}
