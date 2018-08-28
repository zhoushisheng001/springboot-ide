package com.zhuguang.zhou;

import com.zhuguang.zhou.utils.ApplicationUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ServletComponentScan(basePackages={"com.zhuguang.zhou.file"})
public class SpringbootIdeApplication {

    public static void main(String[] args) {
       ApplicationContext applicationContext =   SpringApplication.run(SpringbootIdeApplication.class, args);
        ApplicationUtils.setApplicationContext(applicationContext);
    }
}
