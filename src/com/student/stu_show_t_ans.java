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
import java.util.ArrayList;

@WebServlet("/stu_show_t_ans")
public class stu_show_t_ans extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String s_id=(String)session.getAttribute("nowusername");
        String message=null;
        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        stuDaoImpl que=new stuDaoImpl();
        try {
            ArrayList<Stu> que_list=que.stu_show_t_ans(s_id);
            request.setAttribute("que_list",que_list);
            request.getRequestDispatcher("/stu_show_t_ans.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
