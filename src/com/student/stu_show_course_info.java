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

@WebServlet("/stu_show_course_info")
public class stu_show_course_info extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();

        String course_id=request.getParameter("course_id");
        String t_id=request.getParameter("t_id");
        String dept_name=request.getParameter("dept_name");
        String word=request.getParameter("word");
        String message=null;
        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        stuDaoImpl course=new stuDaoImpl();
        try {
            ArrayList<Stu> course_info = course.stu_show_course(course_id);
            session.setAttribute("course_info", course_info);
            request.setAttribute("t_id",t_id);
            request.setAttribute("course_id", course_id);
            request.setAttribute("dept_name",dept_name);
            request.setAttribute("word",word);
            request.getRequestDispatcher("stu_message_of_course").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
