package com.job.servlet;

import com.job.domain.User;
import com.job.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by goufaning on 2016/11/13.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new User();
            String username = request.getParameter("user");
            String password = request.getParameter("passwd");
            String email = request.getParameter("mail");
            user.setUsername(username);
            user.setPassword(password);
            user.setMail(email);
            UserService service = new UserService();
            boolean flag = service.register(user);
            if (flag) {
                request.setAttribute("massage","注册成功");
            }else {
                request.setAttribute("massage","注册失败");
            }

        }catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("massage","注册失败\r\n" + e.getMessage() );
        }
        request.getRequestDispatcher("/massage.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
