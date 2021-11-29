package com.pro.service;

import com.pro.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User selectOne(Long id);

    User createUser(String user_name,String user_password,String user_nickname,int user_type);

    User checkLogin(String user_name,String user_password);

    User updatePassword(Long id,String oldpw,String newpw);

    User updateNickname(Long id,String nickname);

    List namecheck(String username,String colum);
}
