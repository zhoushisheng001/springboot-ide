package com.zhuguang.zhou.anotition;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ZhouService {

    String value () default "";
}
