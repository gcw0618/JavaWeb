package com.demo;

import com.student_dao.Stu;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/checklogin")
public class checklogin extends HttpServlet {
    private static final long serialVersionUID=1L;
    Connection conn=null;
    Statement stmt=null;
    ResultSet rst=null;
    DataSource dataSource;
    PreparedStatement ps=null;

    public void init(){
        try{
            Context context=new InitialContext();
            dataSource=(DataSource)context.lookup("java:comp/env/jdbc/javawebDS");
            conn=dataSource.getConnection();
            if(conn!=null){
                System.out.println("数据库连接成功");
            }
            else{
                System.out.println("出锅了");
            }
        }catch (NamingException ne){
            System.out.println("Exception:"+ne);
        }catch (SQLException se){
            System.out.println("Exception:"+se);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String job=request.getParameter("job");

        if(username==null||password==null){
            request.setAttribute("userror","请输入正确用户名或密码");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

        session.setAttribute("nowusername", username);
        session.setAttribute("nowpassword", password);
        session.setAttribute("nowjob", job);
        if(job.equals("administrator")){
            try{
                Connection conn=dataSource.getConnection();
                String sql = "SELECT *FROM administratorlogin WHERE username=? and password=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rst = ps.executeQuery();
                if (rst.next()) {

                    request.getRequestDispatcher("/admin_manage.jsp").forward(request,response);
                } else {
                    request.setAttribute("userror","请输入正确用户名或密码");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(conn!=null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        else if(job.equals("teacher")){
            try{
                Connection conn=dataSource.getConnection();
                String sql = "SELECT *FROM teacherlogin WHERE username=? and password=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rst = ps.executeQuery();
                if (rst.next()) {
                    request.getRequestDispatcher("/tea_manage.jsp").forward(request,response);
                } else {
                    request.setAttribute("userror","请输入正确用户名或密码");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(conn!=null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        else if(job.equals("student")){
            try{
                Connection conn=dataSource.getConnection();
                String sql = "SELECT *FROM studentlogin WHERE username=? and password=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rst = ps.executeQuery();
                if (rst.next()) {
                    request.getRequestDispatcher("/stu_inter.jsp").forward(request,response);
                } else {
                    request.getRequestDispatcher("/stu_register.jsp").forward(request,response);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if(conn!=null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
