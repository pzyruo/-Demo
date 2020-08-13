<%--
  Created by IntelliJ IDEA.
  User: 我的电脑
  Date: 2020/7/9
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="update" method="get">
        <table border="1px">
            <tr>
                <th>题目编号</th>
                <td><input type="text" name="questionId" value="${key.questionId}" readonly></td>
            </tr>
            <tr>
                <td>题目</td>
                <td><input type="text" name="title" value="${key.title}"></td>
            </tr>
            <tr>
                <td>A</td>
                <td><input type="text" name="optionA" value="${key.optionA}"></td>
            </tr>
            <tr>
                <td>B</td>
                <td><input type="text" name="optionB" value="${key.optionB}"></td>
            </tr>
            <tr>
                <td>C</td>
                <td><input type="text" name="optionC" value="${key.optionC}"></td>
            </tr>
            <tr>
                <td>D</td>
                <td><input type="text" name="optionD" value="${key.optionD}"></td>
            </tr>
            <tr>
                <td>正确选项</td>
                <td>
                    <input type="radio" name="answer" value="A" ${"A".equals(key.answer)?"checked":""}>A
                    <input type="radio" name="answer" value="B" ${"B".equals(key.answer)?"checked":""}>B
                    <input type="radio" name="answer" value="C" ${"C".equals(key.answer)?"checked":""}>C
                    <input type="radio" name="answer" value="D" ${"D".equals(key.answer)?"checked":""}>D
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="更新试题" ></td>
                <td><input type="reset"></td>
            </tr>
        </table>
    </form>
</center>
</body>

</html>
