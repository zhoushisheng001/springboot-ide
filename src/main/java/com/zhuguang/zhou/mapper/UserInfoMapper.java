package com.zhuguang.zhou.mapper;


import com.zhuguang.zhou.model.User;
import com.zhuguang.zhou.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserDto> getUserInfo(@Param("name") String name);
}
