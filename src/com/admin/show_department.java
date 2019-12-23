package com.admin;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.admin_dao.*;

@WebServlet("/show_department")
public class show_department extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        adminDAOImpl dept=new adminDAOImpl();
        String opt=request.getParameter("opt");
        try {
            ArrayList<Admin> dept_name=dept.showALLdepartment();
            request.setAttribute("dept_name",dept_name);
            if(opt.equals("1")) request.getRequestDispatcher("/admin_add_department.jsp").forward(request,response);
            request.getRequestDispatcher("/admin_department.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
