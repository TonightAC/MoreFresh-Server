package com.suresursus.fore.service.impl;

import com.suresursus.fore.mapper.UserMapper;
import com.suresursus.fore.pojo.User;
import com.suresursus.fore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper = null;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public String login(String uname, String pwd) {
        User user = userMapper.getUser(uname);
        if(user != null && user.getPwd() != null && user.getPwd().equals(pwd)){
            return String.valueOf(user.getUno());
        }else{
            return "error";
        }
    }
}
