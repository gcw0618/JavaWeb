package com.student_dao;

import com.student_dao.DaoException;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public interface dao {
    public static DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/javawebDS");
        } catch (NamingException ne) {
            System.out.println("Exception:" + ne);
        }
        return dataSource;
    }
    public default Connection getConnection()throws DaoException {
        DataSource dataSource=getDataSource();
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        }catch (SQLException e){
            System.out.println(e);
        }
        return conn;
    }

}
