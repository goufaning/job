package com.job.servlet;

import com.job.domain.Resume;
import com.job.domain.User;
import com.job.service.ResumeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by goufaning on 2016/11/16.
 */
public class ReadResumeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null) {
            request.setAttribute("massage","没有登陆，请登录！");
            request.getRequestDispatcher("/massage.jsp").forward(request,response);
        }
        ResumeService service = new ResumeService();
        Resume resume = service.findResumeById(user.getResumeId());
        if (resume!=null) {
            request.setAttribute("resume",resume);
            session.setAttribute("resume",resume);
            request.getRequestDispatcher("/readresume.jsp").forward(request,response);
        } else {
            request.setAttribute("massage","没有简历，请先添加简历");
            request.getRequestDispatcher("/addresume.jsp").forward(request,response);
        }
    }
}
