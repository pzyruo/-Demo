package com.pzyruo.Controller;

import com.pzyruo.dao.QuestionDao;
import com.pzyruo.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1.获取请求对象
        String title,optionA,optionB,optionC,optionD,answer,questionId;
        QuestionDao Dao = new QuestionDao();
        Question question = null;
        int result = 0;
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        questionId = request.getParameter("questionId");
        //2.调用DAO将更新命令执行
        question = new Question(Integer.valueOf(questionId),title,optionA,optionB,optionC,optionD,answer);
        result = Dao.upDate(question);
        if (result == 1){
           request.setAttribute("info","试题更新成功");
        }else {
            request.setAttribute("info","试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
