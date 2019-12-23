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

@WebServlet("/tea_manage_admit")
public class tea_manage_admit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        teaDao dao=new teaDaoImpl();
        Teacher teacher=new Teacher();
        String message=null;
        teaDaoImpl stu=new teaDaoImpl();
        teaDaoImpl course=new teaDaoImpl();
        teaDao admit=new teaDaoImpl();
        String t_id=(String)session.getAttribute("nowusername");
        String opt=request.getParameter("opt");
        try {
            ArrayList<Teacher> stu_list=stu.show_all_student();
            ArrayList<Teacher> course_list=course.show_his_course(t_id);
            ArrayList<Teacher> admit_stu=admit.show_admit_student(t_id);
            request.setAttribute("stu_list",stu_list);
            request.setAttribute("course_list",course_list);
            request.setAttribute("admit_stu",admit_stu);
            if(opt.equals("1")){
                request.getRequestDispatcher("/tea_add_admit.jsp").forward(request,response);
            }
            else if(opt.equals("2")){
                request.getRequestDispatcher("/tea_delete_admit.jsp").forward(request,response);
            }
            //request.getRequestDispatcher("/tea_manage_admit.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
