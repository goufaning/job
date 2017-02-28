package com.job.servlet;

import com.job.domain.User;
import com.job.service.ApplicationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by goufaning on 2016/11/21.
 */
@WebServlet(name = "ApplyJobServlet")
public class ApplyJobServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user==null) {
                request.setAttribute("massage","没有登陆，请登录！");
                request.getRequestDispatcher("/massage.jsp").forward(request,response);
            }
            int userId = user.getId();
            int jobId = 0;
            String _jobId = request.getParameter("jobid");
            if (_jobId != null) {
                jobId = Integer.parseInt(_jobId);
            }
            ApplicationService service = new ApplicationService();
            boolean flag = service.insert(userId,jobId);
            if (flag) {
                request.setAttribute("massage","申请成功");
            }else {
                request.setAttribute("massage","申请失败");
            }

        }catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("massage","申请失败\r\n" + e.getMessage() );
        }
        request.getRequestDispatcher("/massage.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
