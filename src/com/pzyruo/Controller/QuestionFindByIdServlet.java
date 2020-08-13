package com.pzyruo.Controller;

import com.pzyruo.dao.QuestionDao;
import com.pzyruo.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId;
        QuestionDao Dao = new QuestionDao();
        Question question =null;
        //1.调用请求对象对请求头中参数，得到试题编号
        questionId  = request.getParameter("questionId");
        //2.调用DAO同送查询命令得到这个试题编号的试题信息
        question = Dao.ByIdFind(questionId);
        //3.调用将信息写入响应体中
        request.setAttribute("key",question);
        request.getRequestDispatcher("/question_update.jsp").forward(request,response);
    }
}
