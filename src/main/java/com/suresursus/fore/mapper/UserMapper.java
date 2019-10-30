package com.suresursus.fore.mapper;

import com.suresursus.fore.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    public User getUser(String uname);
}
