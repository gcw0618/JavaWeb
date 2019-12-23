package com.student;

import com.admin_dao.Admin;
import com.admin_dao.adminDAOImpl;
import com.admin_dao.adminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/stu_changepsw")
public class stu_changepsw extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        adminDao dao=new adminDAOImpl();
        Admin admin =new Admin();
        String message=null;

        HttpSession session=request.getSession(true);
        String username=(String)session.getAttribute("nowusername");
        admin.setUsername(username);
        try {
            admin.setPassword(new String(request.getParameter("password1")));
            boolean success=dao.update_stu_pwd(admin);
            if(success){
                message="<li>更改成功</li>";
            }
            else{
                message="<li>更改失败</li>";
            }
        }catch (Exception e){
            System.out.println(e);
            message="<li>错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("/stu_changepsw.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
