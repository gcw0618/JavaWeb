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

@WebServlet("/add_department")
public class add_department extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        try {
            admin.setDept_name(new String(request.getParameter("dept_name")));
            boolean success=dao.add_department(admin);
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
        request.getRequestDispatcher("/admin_add_department.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
