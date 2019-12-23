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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin_ans_message")
public class admin_ans_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        teaDao dao=new teaDaoImpl();
        Teacher teacher=new Teacher();
        String message=null;
        adminDAOImpl messages=new adminDAOImpl();

        String title=request.getParameter("title");
        String s_id=request.getParameter("s_id");
        String t_id=(String)session.getAttribute("nowusername");
        String t_ans=request.getParameter("t_ans");

        try {
            teacher.setTitle(title);
            teacher.setS_id(s_id);
            teacher.setT_id(t_id);
            teacher.setT_ans(t_ans);
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
        request.getRequestDispatcher("show_message").forward(request,response);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
