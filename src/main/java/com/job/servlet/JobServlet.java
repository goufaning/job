package com.job.servlet;

import com.job.domain.Job;
import com.job.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by goufaning on 2016/11/21.
 */
@WebServlet(name = "JobServlet")
public class JobServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = 0;
        String _id = request.getParameter("jobid");
        if (_id != null) {
            jobId = Integer.parseInt(_id);
        }
        JobService service = new JobService();
        Job job = service.find(jobId);
        request.setAttribute("job",job);
        request.getRequestDispatcher("/job.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
