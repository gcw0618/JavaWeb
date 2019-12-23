package com.student;

import com.student_dao.Stu;
import com.student_dao.stuDao;
import com.student_dao.stuDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/stu_show_course_message")
public class stu_show_course_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String s_id=(String)session.getAttribute("nowusername");
        String message=null;
        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        stuDaoImpl messages=new stuDaoImpl();
        stuDaoImpl course=new stuDaoImpl();
        String course_id=request.getParameter("course_id");
        try {
            ArrayList<Stu> message_list=messages.stu_message_of_course(course_id);
            ArrayList<Stu> course_list=course.stu_show_course(course_id);
            request.setAttribute("message_list",message_list);
            request.setAttribute("course_info",course_list);
            request.getRequestDispatcher("/stu_show_course_message.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
