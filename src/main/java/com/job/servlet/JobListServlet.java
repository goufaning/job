package com.job.servlet;

import com.job.domain.Job;
import com.job.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by goufaning on 2016/11/21.
 */
@WebServlet(name = "JobListServlet")
public class JobListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobService service = new JobService();
        List<Job> jobList = service.getData();
        HttpSession session = request.getSession();
        session.setAttribute("joblist",jobList);
        request.getRequestDispatcher("/readjob.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
