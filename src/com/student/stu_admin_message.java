package com.student;

import com.student_dao.DaoException;
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
import java.util.ArrayList;

@WebServlet("/stu_admin_message")
public class stu_admin_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        String message=null;
        stuDaoImpl hismessage=new stuDaoImpl();
        try {
            ArrayList<Stu> message_list=hismessage.stu_showHISmessage((String)session.getAttribute("nowusername"));
            request.setAttribute("message_list",message_list);
            request.getRequestDispatcher("/stu_admin_His_message.jsp").forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
