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

    @Test
    public void test003() {
        StudentInfo.StudentBuild st = new StudentInfo.StudentBuild();
        st.buildId("123");
        st.buildSex("男");
        st.buildName("张山");
        st.setAge(25);

        StudentInfo.StudentBuild st1 =   new StudentInfo.StudentBuild();
        st1.buildId("12312");
        st1.buildSex("男12");
        st1.buildName("张山12");
        st1.setAge(35);

        System.out.println(st);
        System.out.println(st1);
    }
}
