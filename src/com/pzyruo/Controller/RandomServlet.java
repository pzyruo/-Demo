package com.pzyruo.Controller;

import com.pzyruo.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class RandomServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List list = null;
        //一个系统只有登录验证的地方可以使用getSession(),别的地方都用getSession(false),别的地方无法判断。！！！
        HttpSession session = request.getSession(false);
        //1.调用Dao对象，随机从question表中拿去四道题目
        list = dao.findRandom();
        //2.将4道题目添加到request作为共享数据
        session.setAttribute("key",list);
        //3.请求转发，申请exam.jsp将四道题目写入到响应体
        request.getRequestDispatcher("/exam.jsp").forward(request,response);
    }
}
