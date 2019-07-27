package cn.andios.servlet;


import cn.andios.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            req.setCharacterEncoding("utf-8");
            UserService userService = new UserService();
            String pwd  = userService.getUserPwdByUsername(username);
            System.out.println("username：" + username);
            System.out.println("password：" + password);

            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");

            PrintWriter writer = resp.getWriter();
            if(password.equals(pwd)){
                writer.write("输入正确");
            }else{
                writer.write("输入错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
