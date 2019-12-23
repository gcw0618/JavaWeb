package com.student;

import com.student_dao.Stu;
import com.student_dao.stuDao;
import com.student_dao.stuDaoImpl;
import com.page.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/stu_message_of_course")
public class stu_message_of_course extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();

        stuDao dao=new stuDaoImpl();
        Stu stu=new Stu();
        stuDaoImpl message=new stuDaoImpl();
        ArrayList<Stu> course_info=(ArrayList<Stu>)session.getAttribute("course_info");
        String course_id=request.getParameter("course_id");
        String t_id=request.getParameter("t_id");
        String dept_name=request.getParameter("dept_name");
        String word=request.getParameter("word");

        String pagesize=request.getParameter("pagesize");
        String pageno=request.getParameter("pageno");
        if(pagesize==null) pagesize="5";
        if(pageno==null||pageno=="") pageno="1";

        session.setAttribute("course_info",course_info);
        try {
            if((course_id==""&&t_id==""&&dept_name==""&&word=="")||(course_id==null)){
                //PageModel<Stu> message_list=message.stu_show_message_page((String)session.getAttribute("nowusername"),pagesize,pageno);
                ArrayList<Stu> message_list=message.stu_show_message((String)session.getAttribute("nowusername"),pageno,pagesize);
                double num=message.stu_show_message_size((String)session.getAttribute("nowusername"));
                double p=Double.parseDouble(pagesize);
                request.setAttribute("message_list",message_list);
                request.setAttribute("pagetotal",Math.ceil(num/p));
                request.setAttribute("pageno",pageno);
                request.setAttribute("message_num",(int)num);
                request.getRequestDispatcher("/stu_show_course_message_page.jsp").forward(request,response);
            }
            else if(course_id!=""&&course_id!=null) {
                ArrayList<Stu> message_list = message.stu_message_of_course(course_id);
                request.setAttribute("message_list", message_list);
                request.setAttribute("course_info", course_info);
                request.getRequestDispatcher("/stu_show_course_message.jsp").forward(request,response);
            }
            else if(t_id!=""&&t_id!=null){
                ArrayList<Stu> message_list=message.stu_message_of_t_id(t_id);
                request.setAttribute("message_list",message_list);
                request.getRequestDispatcher("/stu_show_course_message.jsp").forward(request,response);
            }
            else if(dept_name!=""&&dept_name!=null){
                ArrayList<Stu> message_list=message.stu_message_of_dept(dept_name);
                request.setAttribute("message_list",message_list);
                request.getRequestDispatcher("/stu_show_course_message.jsp").forward(request,response);
            }
            else if(word!=""&&word!=null){
                ArrayList<Stu> message_list=message.stu_message_of_word(word);
                request.setAttribute("message_list",message_list);
                request.getRequestDispatcher("/stu_show_course_message.jsp").forward(request,response);
            }
           //request.getRequestDispatcher("/stu_show_course_message.jsp").forward(request,response);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
