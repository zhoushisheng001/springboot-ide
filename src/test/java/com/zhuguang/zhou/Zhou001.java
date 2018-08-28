package com.zhuguang.zhou;

import org.junit.Test;

import java.util.function.Consumer;

public class Zhou001 {

    @Test
    public void test001(){
        Consumer con = System.out::print;
        con.accept("jiangxi");
        //Supplier
    }
}
