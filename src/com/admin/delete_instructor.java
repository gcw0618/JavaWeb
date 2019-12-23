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

@WebServlet("/delete_instructor")
public class delete_instructor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        try {
            admin.setUsername(new String(request.getParameter("username")));
            admin.setCourse_id(new String(request.getParameter("course_id")));
            boolean success=dao.delete_instructor(admin);
            if(success){
                message="<li>删除成功</li>";
            }
            else{
                message="<li>删除失败</li>";
            }
        }catch (Exception e){
            System.out.println(e);
            message="<li>删除错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("show_instructor?opt=3").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
