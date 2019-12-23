package com.admin;


import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.admin_dao.*;

@WebServlet("/show_instructor")
public class show_instructor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        adminDAOImpl instructor=new adminDAOImpl();
        adminDAOImpl dept=new adminDAOImpl();
        adminDAOImpl teacher=new adminDAOImpl();
        adminDAOImpl course=new adminDAOImpl();
        String opt=request.getParameter("opt");
        try {
            ArrayList<Admin> instructor_list=instructor.admin_showALLinstructor();
            ArrayList<Admin> dept_name=dept.showALLdepartment();
            ArrayList<Admin> teachers=teacher.add_tid_showALLinstructor();
            ArrayList<Admin> course_id=course.updateshowALLcourse();
            request.setAttribute("instructor_list",instructor_list);
            request.setAttribute("dept_name",dept_name);
            request.setAttribute("teachers",teachers);
            request.setAttribute("course",course_id);
            if(opt.equals("1")){
                request.getRequestDispatcher("/admin_add_instructor_login.jsp").forward(request,response);
            }
            else if(opt.equals("2")){
                request.getRequestDispatcher("/admin_add_instructor.jsp").forward(request,response);
            }
            else request.getRequestDispatcher("/admin_teacher.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
