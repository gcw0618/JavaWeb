package com.admin_dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public interface dao {
    /*
    public void insert(Admin user) throws Exception;
    public void delete(String username) throws Exception;
    public void update(Admin user) throws Exception;
    */
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
