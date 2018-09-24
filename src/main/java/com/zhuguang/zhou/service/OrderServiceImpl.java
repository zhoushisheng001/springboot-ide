package com.zhuguang.zhou.service;

public class OrderServiceImpl implements Userservice {

    public String sayName(String name) {
         System.out.println("nihao" + name);
         return "ok12";
    }

    public void scan() {
        sayName("121");
    }

    @Override
    public void getInfo(String name) {
         System.out.println("哈哈...");
    }
}
