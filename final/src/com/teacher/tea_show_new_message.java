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
import java.util.ArrayList;

@WebServlet("/tea_show_new_message")
public class tea_show_new_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();

        teaDao dao=new teaDaoImpl();
        Teacher tea=new Teacher();
        String message=null;
        teaDaoImpl newmessage=new teaDaoImpl();
        String t_id=(String)session.getAttribute("nowusername");
        try {
            ArrayList<Teacher> new_message_list=newmessage.show_new_message(t_id);
            request.setAttribute("message_list",new_message_list);
            request.getRequestDispatcher("/tea_show_new_message.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
