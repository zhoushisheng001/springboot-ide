package com.zhuguang.zhou;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.function.Consumer;

public class Zhou001 {

    @Test
    public void test001(){
        Consumer con = System.out::print;
        con.accept("jiangxi");
        //Supplier
    }

    @Test
    public void test002() {
        UserInfo userInfo = (UserInfo) Proxy.newProxyInstance(UserInfo.class.getClassLoader(),
                new Class[]{UserInfo.class},new UserInvocation());
        userInfo.getUserInfo();
    }
}
