package com.student;

import com.admin_dao.Admin;
import com.admin_dao.adminDAOImpl;
import com.admin_dao.adminDao;
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

@WebServlet("/stu_search_course")
public class stu_search_course extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        adminDAOImpl course_Bydept=new adminDAOImpl();
        adminDAOImpl dept=new adminDAOImpl();
        adminDAOImpl instructor=new adminDAOImpl();
        String dept_name=request.getParameter("dept");
        String t_id=request.getParameter("instructor");
        try {
            if(!dept_name.equals("")) {
                ArrayList<Admin> course_list = course_Bydept.find_course_Bydept(dept_name);
                request.setAttribute("course_list",course_list);
            }
            else if(!t_id.equals("")){
                ArrayList<Admin> course_list=course_Bydept.fing_course_Byt_id(t_id);
                request.setAttribute("course_list",course_list);
            }
            ArrayList<Admin> dept_id=dept.showALLdepartment();
            ArrayList<Admin> instructor_id=instructor.add_tid_showALLinstructor();
            request.setAttribute("dept_list",dept_id);
            request.setAttribute("instructor_list",instructor_id);
            request.getRequestDispatcher("/stu_find_course.jsp").forward(request,response);
            //request.getRequestDispatcher("/stu_show_courseByfind.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
