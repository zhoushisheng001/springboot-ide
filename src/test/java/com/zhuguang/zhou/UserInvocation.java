package com.zhuguang.zhou;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocation implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("nihao");
        System.out.println(method.getName() + "返回值类型：" + method.getReturnType());
        return "OK";
    }
}
