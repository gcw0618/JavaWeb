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

@WebServlet("/tea_delete_ans")
public class tea_delete_ans extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        teaDao dao=new teaDaoImpl();
        Teacher teacher=new Teacher();
        String message=null;
        teaDaoImpl messages=new teaDaoImpl();

        String title=request.getParameter("title");
        String s_id=request.getParameter("s_id");
        try {
            teacher.setTitle(title);
            teacher.setS_id(s_id);
            boolean success=dao.delete_tea_message(teacher);
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
        request.getRequestDispatcher("tea_show_ans").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
