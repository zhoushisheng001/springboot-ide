package com.zhuguang.zhou;

import com.alibaba.fastjson.JSON;
import com.zhuguang.zhou.consont.AppliCationExceport;
import com.zhuguang.zhou.consont.JavaCode;
import com.zhuguang.zhou.model.User;
import com.zhuguang.zhou.model.UserDto;
import com.zhuguang.zhou.service.UserService01;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootIdeApplicationTests {

    @Autowired
    private UserService01 userService01;

    @Test
    public void contextLoads() {
/*        new AppliCationExceport(JavaCode.SUCCLE);
        JavaCode.SUCCLE.getCode();*/
        System.out.println("加载配置文件准备为mybatis...");
        List<UserDto> userInfo = userService01.getUserInfo("张小明");
        userInfo.forEach(user->{
            System.out.println("name:" + user.getUsername() + "："+ "生日:" + user.getBirthday());
        });
    }
}
