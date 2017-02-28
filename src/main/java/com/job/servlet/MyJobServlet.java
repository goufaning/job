package com.job.servlet;

import com.job.domain.Application;
import com.job.domain.Job;
import com.job.domain.User;
import com.job.service.ApplicationService;
import com.job.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by goufaning on 2016/11/22.
 */
public class MyJobServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null) {
            request.setAttribute("massage","没有登陆，请登录！");
            request.getRequestDispatcher("/massage.jsp").forward(request,response);
        }
        int userId = user.getId();
        ApplicationService service = new ApplicationService();
        List<Application> applications = service.getApplications(userId);
        JobService jobService = new JobService();
        List<Job> joblist = new LinkedList<>();
        for (Application app : applications) {
            int jobid = app.getJobId();
            Job job = jobService.find(jobid);
            joblist.add(job);
        }
        if (applications != null) {
            request.setAttribute("applications",joblist);
            request.getRequestDispatcher("/readmyjob.jsp").forward(request,response);
        } else {
            request.setAttribute("massage","您还没有申请工作");
            request.getRequestDispatcher("/readmyjob.jsp").forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
