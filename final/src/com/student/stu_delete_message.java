package com.student;

import com.student_dao.Stu;
import com.student_dao.stuDao;
import com.student_dao.stuDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/stu_delete_message")
public class stu_delete_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String message=null;
        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        String old_title=request.getParameter("old_title");
        String s_id=(String)session.getAttribute("nowusername");

        try {
            stu.setTitle(old_title);
            stu.setUsername(s_id);
            boolean success=dao.stu_delete_message(stu);
            if(success){
                message="<li>删除成功</li>";
            }
            else{
                message="<li>删除失败</li>";
            }

        }catch (Exception e){
            e.printStackTrace();
            message="<li>删除错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("stu_admin_message").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
