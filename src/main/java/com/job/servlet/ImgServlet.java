package com.job.servlet;

import com.job.domain.Resume;
import com.job.domain.User;
import com.job.service.ResumeService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by goufaning on 2016/11/19.
 */
@WebServlet(name = "ImgServlet")
public class ImgServlet extends HttpServlet {
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
            request.setAttribute("resume", resume);
            session.setAttribute("resume", resume);
        }
        String savefilename = null;
        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                if(!item.isFormField()){
                    String filename = item.getName();
                    savefilename = makeFileName(filename);//得到保存在硬盘的文件名
                    String savepath = this.getServletContext().getRealPath("/images");
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(savepath + "\\" + savefilename);
                    int len = 0;
                    byte buffer[] = new byte[1024];
                    while((len=in.read(buffer))>0){
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                }
            }
            boolean flag = service.addPhoto(user.getResumeId(),savefilename);
            if (flag) {
                request.setAttribute("massage", "上传成功");
            } else {
                request.setAttribute("massage", "上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("massage", "上传失败\r\n");
        }
        request.getRequestDispatcher("/massage.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public String makeFileName(String filename){
        String ext = filename.substring(filename.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;
    }
}
