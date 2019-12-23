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

@WebServlet("/update_instructor")
public class update_instructor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String old_course_id=request.getParameter("course_id");
        String message=null;
        try {
            admin.setUsername(new String(request.getParameter("username"))) ;
            admin.setRank(new String(request.getParameter("update_instructor_rank")));
            admin.setCourse_id(new String(request.getParameter("update_instructor_course_id")));
            admin.setDescription(new String(request.getParameter("update_instructor_intro")));
            admin.setDept_name(new String(request.getParameter("dept_name2")));
            boolean success=dao.update_instructor(admin,old_course_id);
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
        request.getRequestDispatcher("show_instructor?opt=3").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
