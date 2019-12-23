package com.demo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/checkregister")
public class checkregister extends HttpServlet {
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");

        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        String sql="select * from studentlogin where username=?";
        try {
            Connection conn=dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                out.write("NO");
            }else{
                out.write("OK");
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        
    }
}
