package com.zhuguang.zhou.service;

public class MyBatisImple implements myBatis01 {
    @Override
    public <T> T selectOnes(String name) {
        try {
            System.out.println("已经进入了...");
             T t1 = (T)Class.forName(name).newInstance();
            return t1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
