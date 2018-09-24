package com.zhuguang.zhou.service;

import com.zhuguang.zhou.mapper.UserInfoMapper;
import com.zhuguang.zhou.model.User;
import com.zhuguang.zhou.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService01 {

    @Autowired
    private UserInfoMapper userInfo;

    public List<UserDto> getUserInfo(String name) {
         return userInfo.getUserInfo(name);
    }

}
