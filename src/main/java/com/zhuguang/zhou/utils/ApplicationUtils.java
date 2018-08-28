package com.zhuguang.zhou.utils;

import org.springframework.context.ApplicationContext;

public class ApplicationUtils {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationUtils.applicationContext = applicationContext;
    }
}
