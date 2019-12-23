package com.teacher_dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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
