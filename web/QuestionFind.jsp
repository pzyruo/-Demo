<%@ page import="com.pzyruo.dao.UserDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pzyruo.entity.Question" %>
<%@ page import="com.pzyruo.dao.QuestionDao" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 我的电脑
  Date: 2020/7/7
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Question> list =(List) request.getAttribute("key");
%>
<table border="1px" align="center">
    <tr>
        <td>题目编号</td>
        <td>题目内容</td>
        <td>A选项</td>
        <td>B选项</td>
        <td>C选项</td>
        <td>D选项</td>
        <td>正确答案</td>
    </tr>
    <%
        for (Question question: list){
    %>
    <tr>
        <td><%=question.getQuestionId()%></td>
        <td><%=question.getTitle()%></td>
        <td><%=question.getOptionA()%></td>
        <td><%=question.getOptionB()%></td>
        <td><%=question.getOptionC()%></td>
        <td><%=question.getOptionD()%></td>
        <td><%=question.getAnswer()%></td>
        <td>
            <a href="/myWeb/question/delete?questionId=<%=question.getQuestionId()%>">删除试题</a>
            <a href="/myWeb/question/ByIDfind?questionId=<%=question.getQuestionId()%>">详细信息</a>
        </td>
    </tr>
      <%  }%>
