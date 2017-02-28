package com.job.servlet;

import com.job.domain.Resume;
import com.job.domain.User;
import com.job.service.ResumeService;
import com.job.service.UserService;
import com.job.utils.IdUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by goufaning on 2016/11/15.
 */
@WebServlet(name = "AddResumeServlet")
public class AddResumeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public String makeFileName(String filename) {
        String ext = filename.substring(filename.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String id = IdUtils.getUUID();
        ResumeService service = new ResumeService();
        try {
            Resume resume = new Resume();
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String education = request.getParameter("education");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));
            String evaluation = request.getParameter("evaluation");
            String major = request.getParameter("major");
            String projectexperience = request.getParameter("projectexperience");
            String telephone = request.getParameter("telephone");
            String university = request.getParameter("university");
            String workexperience = request.getParameter("workexperience");
            resume.setId(id);
            resume.setName(name);
            resume.setSex(sex);
            resume.setAge(age);
            resume.setEmail(email);
            resume.setEducation(education);
            resume.setEvaluation(evaluation);
            resume.setWorkexperience(workexperience);
            resume.setMajor(major);
            resume.setUniversity(university);
            resume.setTelephone(telephone);
            resume.setProjectexperience(projectexperience);
            boolean flag = service.addResume(resume);
            if (flag) {
                request.setAttribute("massage", "添加成功");
                UserService userService = new UserService();
                userService.setResume(user.getId(), id);
            } else {
                request.setAttribute("massage", "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("massage", "添加失败\r\n" + e.getMessage());
        }
        request.getRequestDispatcher("/massage.jsp").forward(request, response);
    }
}
