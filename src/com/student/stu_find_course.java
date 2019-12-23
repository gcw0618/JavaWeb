package com.student;

import com.admin_dao.Admin;
import com.admin_dao.DaoException;
import com.admin_dao.adminDAOImpl;
import com.admin_dao.adminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/stu_find_course")
public class stu_find_course extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        adminDAOImpl dept=new adminDAOImpl();
        adminDAOImpl instructor=new adminDAOImpl();
        try {
            ArrayList<Admin> dept_id=dept.showALLdepartment();
            ArrayList<Admin> instructor_id=instructor.add_tid_showALLinstructor();
            request.setAttribute("dept_list",dept_id);
            request.setAttribute("instructor_list",instructor_id);
            request.getRequestDispatcher("/stu_find_course.jsp").forward(request,response);

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
