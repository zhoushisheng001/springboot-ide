package com.zhuguang.zhou;

import com.zhuguang.zhou.service.OrderServiceImpl;
import com.zhuguang.zhou.service.OrderServiceImpl01;
import com.zhuguang.zhou.service.Userservice;
import org.junit.Test;

import java.lang.reflect.Method;
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

    @Test
    public void getInfo() {
        OrderServiceImpl01 order = new OrderServiceImpl01();
        order.scan();
    }

    @Test
    public void test005 () {
        try{
            Userservice oder = new OrderServiceImpl();
            Class<? extends Userservice> clazz = oder.getClass();
            Method method = clazz.getMethod("getInfo", String.class);
            Class<? extends Method> clzz1 = method.getClass();
            System.out.println("clzz1:" + clzz1);
            Class<?> clazz2 = method.getDeclaringClass();//或的该类的方法
            System.out.println("clazz2:" + clazz2);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
