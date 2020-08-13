package com.pzyruo.dao;

import com.pzyruo.entity.Question;
import com.pzyruo.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private JDBCUtil util = new JDBCUtil();
    public int add(Question question){
        // 新增试题

        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer)values(?,?,?,?,?,?)";
        int result = 0;
        //创建连接
        PreparedStatement ps =util.createStatement(sql);
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    public List find(){
        String SQL = "select * from question";
        int result = 0;
        PreparedStatement ps = util.createStatement(SQL);
        ResultSet rs = null;
        List list = new ArrayList();
        Question question = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
            return list ;
    }
    public int delete(String questionId){
        String SQL = "delete from question where questionId = ?";
        PreparedStatement ps = util.createStatement(SQL);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    public Question ByIdFind(String questionId){
        String SQL = "select * from question where questionId=?";
        PreparedStatement ps = util.createStatement(SQL);
        ResultSet rs = null;
        Question question = null;
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            rs = ps.executeQuery();
            while (rs.next()){
                Integer question2Id = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question = new Question(question2Id,title,optionA,optionB,optionC,optionD,answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return question ;
    }
    public int upDate(Question question){
        String SQL = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        int result = 0;
        //创建连接
        PreparedStatement ps =util.createStatement(SQL);
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getQuestionId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    public List findRandom() {
        String SQL = "select * from question order by rand() limit 0,4";
        PreparedStatement ps = util.createStatement(SQL);
        List list = new ArrayList();
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer question2Id = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question = new Question(question2Id, title, optionA, optionB, optionC, optionD, answer);
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return list;
    }
}
