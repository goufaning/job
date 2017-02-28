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
 * Created by goufaning on 2016/11/19.
 */

public class PhotoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ResumeService service = new ResumeService();
        Resume resume = service.findResumeById(user.getResumeId());
        request.setAttribute("resume",resume);
        session.setAttribute("resume",resume);
        if (resume!=null) {
            request.setAttribute("resume",resume);
            session.setAttribute("resume",resume);
            request.getRequestDispatcher("/photo.jsp").forward(request,response);
        } else {
            request.setAttribute("massage","没有简历，请先添加简历");
            request.getRequestDispatcher("/addresume.jsp").forward(request,response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
