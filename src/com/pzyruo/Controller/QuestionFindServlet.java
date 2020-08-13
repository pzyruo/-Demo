package com.pzyruo.Controller;

import com.pzyruo.dao.QuestionDao;
import com.pzyruo.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List<Question> list = dao.find();
        request.setAttribute("key",list);
        request.getRequestDispatcher("/QuestionFind.jsp").forward(request,response);

    }
}
