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

@WebServlet("/update_department")
public class update_department extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;
        String dept_name=request.getParameter("dept_name");
        String alter_dept_name=request.getParameter("alter_dept_name");
        try {
            admin.setDept_name(dept_name);
            admin.setNewdept_name(alter_dept_name);
            boolean success=dao.update_department(admin);
            if(success){
                message="<li>更新成功</li>";
            }
            else{
                message="<li>更新失败</li>";
            }
        }catch (Exception e){
            System.out.println(e);
            message="<li>更新错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("show_department?opt=2").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
