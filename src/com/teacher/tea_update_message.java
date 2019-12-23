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

@WebServlet("/tea_update_message")
public class tea_update_message extends HttpServlet {
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
        String s_que=request.getParameter("s_que");
        String t_ans=request.getParameter("t_ans");
        String new_t_ans=request.getParameter("new_t_ans");

        try {
            teacher.setTitle(title);
            teacher.setS_id(s_id);
            teacher.setS_que(s_que);
            teacher.setT_ans(t_ans);
            teacher.setNew_t_ans(new_t_ans);
            boolean success=dao.update_tea_message(teacher);
            if(success){
                message="<li>更新成功</li>";
            }
            else{
                message="<li>更新失败</li>";
            }
        }catch (Exception e){
            e.printStackTrace();
            message="<li>更新错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("tea_show_ans").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
