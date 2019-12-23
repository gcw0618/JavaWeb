package com.student;

import com.student_dao.Stu;
import com.student_dao.stuDao;
import com.student_dao.stuDaoImpl;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/stu_update_message")
public class stu_update_message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String message=null;
        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();

        String old_title=request.getParameter("old_title");
        String s_id=(String)session.getAttribute("nowusername");

        Date currentTime = new Date();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
        try {
            stu.setOpt1(new String(request.getParameter("opt1")));
            stu.setOpt2(new String(request.getParameter("opt2")));
            //stu.setTitle(now_title);
            //stu.setS_que(now_s_que);
            stu.setTitle(new String(request.getParameter("title")));
            stu.setS_que(new String(request.getParameter("s_que")));
            stu.setTime(new String(time));
            boolean success=dao.stu_update_messgae(stu,old_title,s_id);
            if(success){
                message="<li>更新成功</li>";
            }
            else{
                message="<li>更新失败</li>";
            }


        }catch (Exception e){
            e.printStackTrace();
            message="<li>更新错误</li>";
        }
        request.setAttribute("result",message);
        request.getRequestDispatcher("stu_admin_message").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
