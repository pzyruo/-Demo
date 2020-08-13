package com.pzyruo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class oneFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = null;
        String uri = request.getRequestURI();
        //1.拦截后，通过请求对象向Tomcat索要当前用户的HttpSession。
        //2.如果本次请求文件与登陆有关
        if (uri.indexOf("login")!=-1 || uri.equals("/myWeb/")){
            chain.doFilter(req,resp);
            return;
        }
        //3.如果是其他资源文件,得到用户在服务端的session
        session  = request.getSession(false);
        if (session!=null){
            chain.doFilter(req,resp);
        }else {
            //4.拒绝请求
            request.getRequestDispatcher("/login_error.html").forward(req,resp);
        }
        }

}
