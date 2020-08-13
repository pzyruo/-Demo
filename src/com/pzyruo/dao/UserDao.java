package com.pzyruo.dao;

import com.pzyruo.entity.Users;
import com.pzyruo.util.JDBCUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JDBCUtil util = new JDBCUtil();
    //添加用户
    public int add(Users user){
        String sql = "insert into users(userName,password,sex,email)"+"values(?,?,?,?)";
        int result = 0;
        PreparedStatement ps  = util.createStatement(sql);
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassWord());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
       return result;

    }
    //  查询用户
    public List findAll(){
        String SQL = "select * from users";
        PreparedStatement ps = util.createStatement(SQL);
        ResultSet rs = null;
        List userList = new ArrayList();

        try {
            rs =  ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex   = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userId,userName,password,sex,email);
                userList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
            return userList;

    }
    // 删除用户
    public int delete(String userID){
        String sql = "delete from users where userID = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result =0;
        try {
            ps.setInt(1,Integer.valueOf(userID));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    // 登陆验证
    public int login(String userName,String password){
        String sql  = "select count(*) from users where userName =? and password=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        System.out.println("我是"+result);
      return result;

    }
}
