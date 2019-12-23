package com.admin;

import com.admin_dao.Admin;
import com.admin_dao.adminDAOImpl;
import com.admin_dao.adminDao;
import com.teacher_dao.Teacher;
import com.teacher_dao.teaDao;
import com.teacher_dao.teaDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin_delete_message")
public class admin_delete_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        teaDao dao=new teaDaoImpl();
        Teacher teacher=new Teacher();
        String message=null;
        adminDAOImpl messages=new adminDAOImpl();

        String title=request.getParameter("title");
        String s_id=request.getParameter("s_id");
        try {
            teacher.setTitle(title);
            teacher.setS_id(s_id);
            boolean success=dao.delete_message(teacher);
            if(success){
                message="<li>删除成功</li>";
            }
            else{
                message="<li>删除失败</li>";
            }
        }catch (Exception e){
            e.printStackTrace();
            message="<li>删除错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("show_message").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
