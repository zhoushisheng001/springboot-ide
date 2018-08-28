package com.zhuguang.zhou.file;

import com.alibaba.fastjson.JSONObject;
import com.zhuguang.zhou.utils.ApplicationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public class MyHttpSesssion implements HttpSession {

    private HttpServletRequest request;

    private HttpServletResponse response;

    private RedisTemplate redisTemplate;

    private ThreadLocal<String> thread = new ThreadLocal<>();

    public MyHttpSesssion(HttpServletRequest request, HttpServletResponse response) {
          this.request = request;
          this.response = response;
          ApplicationContext applicationContext = ApplicationUtils.getApplicationContext();
          redisTemplate = applicationContext.getBean("redisTemplate",RedisTemplate.class);
    }


    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
           //request.getSession().getAttribute(name)
        String sessionId = getSessionCookId();
        List<JSONObject> strList = redisTemplate.opsForList().range(sessionId,0,-1);
        for (JSONObject json : strList) {
            // JSONObject json = JSON.parseObject(str);
             if (json.containsKey(name)) return json.get(name);
        }
        return null;
    }

    @Override
    public Object getValue(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String name, Object value) {
        String sessionId = this.getSessionCookId();
        if (sessionId == null) {
            sessionId = thread.get();
            if (sessionId == null) {
                 sessionId = "zhou01" + UUID.randomUUID();
                 writeCookId(sessionId);
                 thread.set(sessionId);
            }
        }
        request.getSession().setAttribute(name,value);
        JSONObject json = new JSONObject();
        json.put(name,value);
        redisTemplate.opsForList().leftPush(sessionId,json);
    }

    private void writeCookId (String sessionId) {
           Cookie cookie = new Cookie("sessionId",sessionId);
           cookie.setPath("/");//在任何访问路径下面都可以访问的到
           response.addCookie(cookie);
    }

    private String getSessionCookId() {
        //HttpHeaders httpHeaders = new HttpHeaders();
        //RestTemplate restTemplate = new RestTemplate(httpHeaders);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
             if ("sessionId".equals(cookie.getName())){
                  return cookie.getValue();
             }
        }
        return null;
    }

    @Override
    public void putValue(String name, Object value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public void removeValue(String name) {

    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }
}
