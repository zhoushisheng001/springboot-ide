package com.zhuguang.zhou.service;

public class OrderServiceImpl01 extends OrderServiceImpl {

    public String getInfo() {
        System.out.println("daol...");
        return "nihao";
    }

    @Override
    public String sayName(String name) {
        //super.sayName(name);
        System.out.println("进入...");
        return "OK";
    }


}
