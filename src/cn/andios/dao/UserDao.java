package cn.andios.dao;

import java.sql.*;

public class UserDao {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "123456";
    private static String url = "jdbc:mysql://localhost/demo";

    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn, Statement st, ResultSet rs){
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }
    //释放资源
    public static void release(Connection conn, Statement st){
        closeSt(st);
        closeConn(conn);
    }

    private static void closeRs(ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            rs=null;
        }

    }
    private static void closeSt(Statement st){
        try {
            if(st!=null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            st=null;
        }

    }
    private static void closeConn(Connection conn){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn=null;
        }

    }
}
