package com.student;

import com.student_dao.Stu;
import com.student_dao.stuDao;
import com.student_dao.stuDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stu_register")
public class stu_register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        String message=null;
        try {
            stu.setUsername(new String(request.getParameter("username")));
            stu.setPassword(new String(request.getParameter("password")));
            boolean success=dao.stu_add_register(stu);
            if(success){
                message="<li>注册成功</li>";
            }
            else{
                message="<li>注册失败</li>";
            }
        }catch (Exception e){
            e.printStackTrace();
            message="<li>错误</li>";
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
