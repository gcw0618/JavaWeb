package com.admin;

import com.admin_dao.Admin;
import com.admin_dao.adminDAOImpl;
import com.admin_dao.adminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_course")
public class add_course extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        try {
            admin.setCourse_id(new String(request.getParameter("course_id")));
            admin.setUsername(new String(request.getParameter("t_id")));
            admin.setDescription(new String(request.getParameter("description")));
            admin.setDept_name(new String(request.getParameter("dept_name")));
            boolean success=dao.add_course(admin);
            if(success){
                message="<li>成功插入</li>";
            }
            else{
                message="<li>失败插入</li>";
            }
        }catch (Exception e){
            System.out.println(e);
            message="<li>插入错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("show_course?opt=1").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
