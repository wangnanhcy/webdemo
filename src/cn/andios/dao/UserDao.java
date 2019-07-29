package cn.andios.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.*;

public class UserDao {
    static Connection conn = null;
    public static Connection getConn() throws SQLException {
        //创建数据库连接池对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        conn=cpds.getConnection();
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
