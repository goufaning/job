package com.job.servlet;

import com.job.domain.User;
import com.job.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by goufaning on 2016/11/13.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("p");
        UserService service = new UserService();
        User user = service.findUser(username,password);
        if (user==null) {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('用户名或密码错误！');");
            out.println("history.back();");
            out.println("</script>");
        }else {
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
