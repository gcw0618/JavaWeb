package com.teacher;

import com.teacher_dao.Teacher;
import com.teacher_dao.teaDao;
import com.teacher_dao.teaDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/tea_ans_message")
@MultipartConfig(location = "D:\\",fileSizeThreshold = 1024)
public class tea_ans_message extends HttpServlet {
    private String getFilename(Part part){
        String fname=null;
        String header=part.getHeader("content-disposition");
        fname=header.substring(header.lastIndexOf("=")+2,header.length()-1);
        return fname;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        teaDao dao=new teaDaoImpl();
        Teacher teacher=new Teacher();
        String message=null;
        
        String path=this.getServletContext().getRealPath("/");
        Part p=request.getPart("image");
        String image_message="";
        String fname="";

        if(p.getSize()>1024*1024){
            p.delete();
            image_message="文件太大，不能上传";
        }
        else if(p.getSize()!=0){
            path=path+"\\tea_pic";
            File f=new File(path);
            if(!f.exists()){
                f.mkdirs();
            } 
            fname=getFilename(p);
            p.write(path+"\\"+fname);
            image_message="文件上传成功";
        }
        
        String title=request.getParameter("title");
        String s_id=request.getParameter("s_id");
        String t_id=(String)session.getAttribute("nowusername");
        String t_ans=request.getParameter("t_ans");
        

        try {
            teacher.setTitle(title);
            teacher.setS_id(s_id);
            teacher.setT_id(t_id);
            teacher.setT_ans(t_ans);
            teacher.setT_pic(fname);
            boolean success=dao.ans_new_message(teacher);
            if(success){
                message="<li>回复成功</li>";
            }
            else{
                message="<li>回复失败</li>";
            }
        }catch (Exception e){
            e.printStackTrace();
            message="<li>回复错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("tea_show_new_message").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
