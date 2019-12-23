package com.admin;

import com.admin_dao.Admin;
import com.admin_dao.DaoException;
import com.admin_dao.adminDAOImpl;
import com.admin_dao.adminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/show_course")
public class show_course extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        adminDAOImpl course=new adminDAOImpl();
        adminDAOImpl dept=new adminDAOImpl();
        adminDAOImpl teacher=new adminDAOImpl();
        adminDAOImpl courses=new adminDAOImpl();
        String opt=request.getParameter("opt");
        try {
            ArrayList<Admin> course_id=course.showALLcourse();
            ArrayList<Admin> dept_name=dept.showALLdepartment();
            ArrayList<Admin> instructor=teacher.add_tid_showALLinstructor();
            ArrayList<Admin> update_course_id=courses.updateshowALLcourse();
            request.setAttribute("course_list",course_id);
            request.setAttribute("dept_name",dept_name);
            request.setAttribute("instructor",instructor);
            request.setAttribute("course",update_course_id);
            if(opt.equals("1")) request.getRequestDispatcher("/admin_add_course.jsp").forward(request,response);
            else request.getRequestDispatcher("/admin_course.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
