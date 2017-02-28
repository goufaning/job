package com.job.servlet;

import com.job.domain.Resume;
import com.job.domain.User;
import com.job.service.ResumeService;
import com.job.service.UserService;
import com.job.utils.IdUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by goufaning on 2016/11/19.
 */

public class UpdateResumeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ResumeService service = new ResumeService();
        Resume resume = service.findResumeById(user.getResumeId());
        String oldId = resume.getId();
        String id = IdUtils.getUUID();
        String url = resume.getImgurl();
        try {
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
                request.setAttribute("massage", "更改成功");
                UserService userService = new UserService();
                userService.setResume(user.getId(), id);
                service.addPhoto(id,url);
                service.deleteResume(oldId);
                user = userService.findUser(user.getUsername(),user.getPassword());
                session.setAttribute("user",user);
                request.setAttribute("user",user);
            } else {
                request.setAttribute("massage", "更改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("massage", "更改失败\r\n" + e.getMessage());
        }
        request.getRequestDispatcher("/massage.jsp").forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
