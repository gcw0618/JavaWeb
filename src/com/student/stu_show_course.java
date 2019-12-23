package com.student;

import com.admin_dao.Admin;
import com.admin_dao.DaoException;
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
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/stu_show_course")
public class stu_show_course extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        adminDAOImpl course=new adminDAOImpl();
        adminDAOImpl instructor=new adminDAOImpl();
        adminDAOImpl dept=new adminDAOImpl();
        String opt=request.getParameter("opt");
        try {
            ArrayList<Admin> course_id=course.updateshowALLcourse();
            request.setAttribute("course_list",course_id);
            if(opt.equals("s_que")) request.getRequestDispatcher("/stu_add_message.jsp").forward(request,response);
            else if(opt.equals("course")) {
                ArrayList<Admin> instructor_list=instructor.add_tid_showALLinstructor();
                ArrayList<Admin> dept_list=dept.showALLdepartment();
                request.setAttribute("instructor_list",instructor_list);
                request.setAttribute("dept_list",dept_list);
                request.getRequestDispatcher("/stu_show_course.jsp").forward(request, response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
