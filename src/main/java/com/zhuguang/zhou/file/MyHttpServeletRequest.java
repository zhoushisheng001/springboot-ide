package com.zhuguang.zhou.file;

import org.apache.catalina.connector.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyHttpServeletRequest extends HttpServletRequestWrapper {

            private HttpServletRequest request;

            private HttpServletResponse response;

        public MyHttpServeletRequest(HttpServletRequest request,HttpServletResponse response) {
                super(request);
                 this.request = request;
                 this.response = response;
        }

        @Override
        public HttpSession getSession() {
            return new MyHttpSesssion(request,response);
        }
}
