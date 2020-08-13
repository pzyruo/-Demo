package com.pzyruo.Controller;

import com.pzyruo.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionDeleteServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String questionId;
        QuestionDao dao = new QuestionDao();
        int result = 0;
        PrintWriter out = null;
        //1.调用请求头对象，读取请求头参数（用户编码）
        questionId = request.getParameter("questionId");
        //2.调用DAO推送删除命令
        result = dao.delete(questionId);
        request.setAttribute("key",result);
        request.getRequestDispatcher("/QuestionDelete.jsp").forward(request,response);
    }
}
