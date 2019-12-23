package com.teacher;

import com.teacher_dao.Teacher;
import com.teacher_dao.teaDao;
import com.teacher_dao.teaDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/tea_add_admit")
public class tea_add_admit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        teaDao dao=new teaDaoImpl();
        Teacher teacher=new Teacher();
        String message=null;

        String s_id=request.getParameter("s_id");
        String course_id=request.getParameter("course_id");
        String t_id=(String)session.getAttribute("nowusername");

        try {
            teacher.setS_id(s_id);
            teacher.setCourse_id(course_id);
            teacher.setT_id(t_id);
            boolean success=dao.add_admit(teacher);
            if(success){
                message="<li>增加成功</li>";
            }
            else{
                message="<li>增加失败</li>";
            }
        }catch (Exception e){
            e.printStackTrace();
            message="<li>增加错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("tea_manage_admit?opt=1").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
