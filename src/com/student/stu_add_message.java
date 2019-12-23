package com.student;

import com.mysql.cj.util.Base64Decoder;
import com.student_dao.Stu;
import com.student_dao.stuDao;
import com.student_dao.stuDaoImpl;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.beans.Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

@WebServlet("/stu_add_message")
@MultipartConfig(location = "D:\\",fileSizeThreshold = 1024)
public class stu_add_message extends HttpServlet {
    private String getFilename(Part part){
        String fname=null;
        String header=part.getHeader("content-disposition");
        fname=header.substring(header.lastIndexOf("=")+2,header.length()-1);
        return fname;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //String path;
        String path=this.getServletContext().getRealPath("/");
        Part p=request.getPart("image");
        String image_message="";
        String fname="";

        if(p.getSize()>1024*1024){
            p.delete();
            image_message="文件太大，不能上传";
        }
        else if(p.getSize()!=0){
            path=path+"\\stu_pic";
            //path=path+"\\stu\\"+request.getParameter("s_id");
            File f=new File(path);
            if(!f.exists()){
                f.mkdirs();
            }
            fname=getFilename(p);
            p.write(path+"\\"+fname);
            image_message="文件上传成功";
        }


        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        String message=null;
        Date currentTime = new Date();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
        try {
            stu.setTitle(new String(request.getParameter("title")));
            stu.setCourse_id(new String(request.getParameter("course_id")));
            stu.setUsername(new String(request.getParameter("s_id")));
            stu.setS_que(new String(request.getParameter("s_que")));
            stu.setS_pic(fname);
            stu.setTime(time);
            boolean success=dao.stu_add_message(stu);
            if(success){
                message="<li>成功插入</li>";
            }
            else{
                message="<li>失败插入</li>";
            }

        }catch (Exception e){
            e.printStackTrace();
            message="<li>插入错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("stu_show_course?opt=s_que").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
