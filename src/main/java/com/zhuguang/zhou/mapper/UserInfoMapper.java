package com.zhuguang.zhou.mapper;


import com.zhuguang.zhou.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<User> getUserInfo(String name);
}
