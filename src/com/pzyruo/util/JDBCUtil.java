package com.pzyruo.util;

import java.sql.*;

/*
* JDBC工具类
* */
public class JDBCUtil {
    /*
     * 工具类中的构造方法都是私有的，直接调用，不需要new对象，直接采用类名调用
     */
    Connection coon = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public JDBCUtil() {
    }

    // 静态代码块
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
/*
* 获取数据库连接对象
* @return 连接对象
*
* */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/student",
                "root", "123456");
    }

    public PreparedStatement createStatement(String sql)  {

        try {
            ps =  getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return ps;

    }

    /*
    * 关闭资源
    * */
    public   void close(){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (coon != null) {
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
