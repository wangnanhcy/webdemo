package cn.andios.service;

import cn.andios.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
    public String getUserPwdByUsername(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String password = null;
        try {
            connection = UserDao.getConn();
            String sql = "select * from user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                password = resultSet.getString("password");
            }
            return password;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
