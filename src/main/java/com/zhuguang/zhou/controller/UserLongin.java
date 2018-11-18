package com.zhuguang.zhou.controller;

import com.sun.deploy.net.HttpResponse;
import com.zhuguang.zhou.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserLongin {

    private final Logger logger = LoggerFactory.getLogger(UserLongin.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        logger.info("name:" + name + "password:" + password);
        session.setAttribute("name", name);
        session.setAttribute("password", password);
        return "ok";
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        logger.info("=======" + "name:" + name + "password:" + password + "======");
        String url = "http://localhost:8082/user/getUserInfo";
        User user = new User();
        user.setName("nihao");
        restTemplate.postForObject(url, user, String.class);
        return "ok";
    }
}