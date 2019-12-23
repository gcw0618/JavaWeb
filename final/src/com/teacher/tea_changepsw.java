package com.teacher;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/tea_changepsw")
public class tea_changepsw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        teaDao dao=new teaDaoImpl();
        Teacher teacher=new Teacher();
        String message=null;

        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("nowusername");
        teacher.setT_id(username);
        try {
            teacher.setPassword(new String(request.getParameter("password1")));
            boolean success=dao.tea_changepsw(teacher);
            if(success){
                message="<li>修改成功</li>";
            } 
            else{
                message="<li>修改失败</li>";
            }
        }catch (Exception e){
            System.out.println(e);
            message="<li>修改错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("/tea_changepsw.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
