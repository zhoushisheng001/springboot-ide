package com.zhuguang.zhou.incterp;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * 注解都需要是@()的形式
 * 如果是数组就@({})
 */
/*@Intercepts(value = {@Signature(type=Executor.class,method="",args={}),
         @Signature(type=Executor.class,method="",args={})})*/
@Intercepts(value = {@Signature(type=Executor.class,method="query",args={MappedStatement.class,
        Object.class,RowBounds.class,ResultHandler.class})})
public class MyBatisInter implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor) {
            target = Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
