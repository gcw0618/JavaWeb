package com.admin_dao;
import java.sql.*;
import java.util.ArrayList;

public class adminDAOImpl implements adminDao {
    //添加老师姓名、密码
    public boolean add_teacher_User(Admin admin) throws DaoException {
        String sql="INSERT INTO teacherlogin(username,password) values(?,?)";
        try (Connection conn= getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ps.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        }
    }
    //更改管理员密码
    public boolean update_admin_pwd(Admin admin) throws DaoException {
        String sql="UPDATE administratorlogin set password=? where username=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, admin.getPassword());
            ps.setString(2, admin.getUsername());
            ps.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更改学生密码
    public boolean update_stu_pwd(Admin admin) throws DaoException {
        String sql="UPDATE studentlogin set password=? where username=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, admin.getPassword());
            ps.setString(2, admin.getUsername());
            ps.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }

    //添加学院
    public boolean add_department(Admin admin) throws DaoException {
        String sql="INSERT INTO department(dept_name) values(?)";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, admin.getDept_name());
            ps.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更新学院
    public boolean update_department(Admin admin) throws DaoException {
        String sql="UPDATE department set dept_name=? where dept_name=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, admin.getNewdept_name());
            ps.setString(2, admin.getDept_name());

            ps.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //删除学院
    public boolean delete_department(Admin admin) throws DaoException {
        String sql="DELETE FROM department WHERE dept_name=?";
        try (
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, admin.getDept_name());
            ps.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //查询所有学院
    public ArrayList<Admin> showALLdepartment() throws DaoException {
        ArrayList<Admin> dept_list=new ArrayList<Admin>();
        String sql="SELECT * FROM department";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rst=ps.executeQuery()){
            while(rst.next()){
                Admin admin =new Admin();
                admin.setDept_name(rst.getString("dept_name"));
                dept_list.add(admin);
            }
            return dept_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //增加课程信息
    public boolean add_course(Admin admin) throws DaoException {
        String sql1="INSERT INTO course values(?,?,?)";
        String sql2="INSERT INTO instructor(t_id) SELECT ? FROM dual WHERE NOT EXISTS (SELECT *FROM instructor WHERE t_id=?)";
        String sql3="INSERT INTO teaches(t_id,course_id) SELECT ?,? FROM dual WHERE NOT EXISTS (SELECT * FROM teaches WHERE t_id=?)";
        try(
                Connection conn=getConnection()) {
            PreparedStatement ps=conn.prepareStatement(sql1);
            ps.setString(1, admin.getCourse_id());
            ps.setString(2, admin.getDescription());
            ps.setString(3, admin.getDept_name());
            ps.executeUpdate();
            ps=conn.prepareStatement(sql2);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getUsername());
            ps.executeUpdate();
            ps=conn.prepareStatement(sql3);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getCourse_id());
            ps.setString(3, admin.getUsername());
            ps.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更新课程信息
    public boolean update_course(Admin admin) throws DaoException {
        String sql1="UPDATE course set description=?,dept_name=? WHERE course_id=?";
        try(
                Connection conn1=getConnection();
                PreparedStatement ps1=conn1.prepareStatement(sql1))
        {
            ps1.setString(1, admin.getDescription());
            ps1.setString(2, admin.getDept_name());
            ps1.setString(3, admin.getCourse_id());
            ps1.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //查询所有课程信息(course_id有重复)
    public ArrayList<Admin> showALLcourse() throws DaoException {
        ArrayList<Admin> course_list=new ArrayList<Admin>();
        String sql1="SELECT * FROM course";
        String sql2="SELECT t_id FROM teaches WHERE course_id=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ResultSet rst1=ps1.executeQuery()){
                while(rst1.next()){
                    try(
                        Connection conn1=getConnection();
                        PreparedStatement ps2=conn1.prepareStatement(sql2))
                    {
                        ps2.setString(1,rst1.getString("course_id"));
                        ResultSet rst2=ps2.executeQuery();
                        if(!rst2.next()){
                            Admin admin1 =new Admin();
                            admin1.setCourse_id(rst1.getString("course_id"));
                            admin1.setDescription(rst1.getString("description"));
                            admin1.setDept_name(rst1.getString("dept_name"));
                            course_list.add(admin1);
                        }
                        else{
                            rst2.previous();
                            while(rst2.next()){
                                Admin admin =new Admin();
                                admin.setCourse_id(rst1.getString("course_id"));
                                admin.setUsername(rst2.getString("t_id"));
                                admin.setDescription(rst1.getString("description"));
                                admin.setDept_name(rst1.getString("dept_name"));
                                course_list.add(admin);
                            }
                        }
                    }catch (SQLException SE){
                        SE.printStackTrace();
                    }
                }
                return course_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //查询所有课程(无重复，用于更新)
    public ArrayList<Admin> updateshowALLcourse() throws DaoException {
        ArrayList<Admin> course_list=new ArrayList<Admin>();
        String sql="SELECT course_id,description,dept_name FROM course";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rst=ps.executeQuery()){
            while(rst.next()){
                Admin admin =new Admin();
                admin.setCourse_id(rst.getString("course_id"));
                admin.setDescription(rst.getString("description"));
                admin.setDept_name(rst.getString("dept_name"));
                course_list.add(admin);
            }
            return course_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //删除该课程的教师
    public boolean delete_instructor_course(Admin admin) throws DaoException {
        String sql1="DELETE FROM teaches WHERE t_id=? and course_id=?";
        String sql2="SELECT t_id FROM teaches WHERE course_id=?";
        String sql3="DELETE FROM course WHERE course_id=?";
        try (
                Connection conn=getConnection())
        {
            PreparedStatement ps=conn.prepareStatement(sql1);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getCourse_id());
            ps.executeUpdate();
            try(
                    Connection conn1=getConnection();
                    PreparedStatement ps1=conn1.prepareStatement(sql2))
                {
                    ps1.setString(1, admin.getCourse_id());
                    ResultSet rst=ps1.executeQuery();
                    if(!rst.next()){
                        try(
                                Connection conn2=getConnection();
                                PreparedStatement ps2=conn2.prepareStatement(sql3))
                        {
                            ps2.setString(1, admin.getCourse_id());
                            ps2.executeUpdate();
                            return true;
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                    return true;
                }catch (SQLException e){
                    e.printStackTrace();
                }
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //删除一整个课程
    public boolean delete_course(Admin admin) throws DaoException {
        String sql1="DELETE FROM course WHERE course_id=?";
        String sql2="DELETE FROM teaches WHERE course_id=?";
        try (
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql1))
        {
            ps.setString(1, admin.getCourse_id());
            ps.executeUpdate();
            try(
                    Connection conn1=getConnection();
                    PreparedStatement ps1=conn1.prepareStatement(sql2)){
                ps1.setString(1, admin.getCourse_id());
                ps1.executeUpdate();
                return true;
            }catch (SQLException e){
                e.printStackTrace();
            }
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据学院查找课程
    public ArrayList<Admin> find_course_Bydept(String dept_name) throws DaoException {
        ArrayList<Admin> course_list=new ArrayList<Admin>();
        String sql="SELECT course_id FROM course WHERE dept_name=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,dept_name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Admin admin=new Admin();
                admin.setCourse_id(rs.getString("course_id"));
                course_list.add(admin);
            }
            return course_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //根据教师名字查找课程
    public ArrayList<Admin> fing_course_Byt_id(String t_id) throws DaoException {
        ArrayList<Admin> course_list=new ArrayList<Admin>();
        String sql="SELECT course_id FROM teaches WHERE t_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,t_id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Admin admin=new Admin();
                admin.setCourse_id(rs.getString("course_id"));
                course_list.add(admin);
            }
            return course_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    //添加教师信息
    public boolean add_instructor(Admin admin) throws DaoException {
       String sql1="INSERT INTO instructor(t_id,t_rank,intro,dept_name) SELECT ?,?,?,? FROM dual WHERE NOT EXISTS(SELECT * FROM instructor WHERE t_id=?)";
       String sql2="INSERT INTO teaches(t_id,course_id) SELECT ?,? FROM dual WHERE NOT EXISTS(SELECT t_id FROM teaches WHERE t_id=? and course_id=?)";
       try (
               Connection conn=getConnection()){
           PreparedStatement ps1=conn.prepareStatement(sql1);
           ps1.setString(1, admin.getUsername());
           ps1.setString(2, admin.getRank());
           ps1.setString(3, admin.getDescription());
           ps1.setString(4, admin.getDept_name());
           ps1.setString(5, admin.getUsername());
           ps1.executeUpdate();
           ps1=conn.prepareStatement(sql2);
           ps1.setString(1, admin.getUsername());
           ps1.setString(2, admin.getCourse_id());
           ps1.setString(3, admin.getUsername());
           ps1.setString(4, admin.getCourse_id());
           ps1.executeUpdate();
           return true;
       }catch (SQLException e){
           e.printStackTrace();
           return false;
       }
    }
    //查询教师信息(管理教师)
    public ArrayList<Admin> admin_showALLinstructor() throws DaoException {
        ArrayList<Admin> instructor_list=new ArrayList<Admin>();
        String sql1="SELECT * FROM instructor";
        String sql2="SELECT course_id FROM teaches WHERE t_id=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ResultSet rst1=ps1.executeQuery()){
                while(rst1.next()){
                    try(
                        Connection conn1=getConnection();
                        PreparedStatement ps2=conn.prepareStatement(sql2)){
                        ps2.setString(1,rst1.getString("t_id"));
                        ResultSet rst2=ps2.executeQuery();
                        if(!rst2.next()){
                            Admin admin =new Admin();
                            admin.setUsername(rst1.getString("t_id"));
                            admin.setRank(rst1.getString("t_rank"));
                            admin.setDescription(rst1.getString("intro"));
                            admin.setDept_name(rst1.getString("dept_name"));
                            instructor_list.add(admin);
                        }
                        else{
                            rst2.previous();
                            while(rst2.next()){
                                //admin=new Admin();
                                Admin admin =new Admin();
                                admin.setUsername(rst1.getString("t_id"));
                                admin.setCourse_id(rst2.getString("course_id"));
                                admin.setRank(rst1.getString("t_rank"));
                                admin.setDescription(rst1.getString("intro"));
                                admin.setDept_name(rst1.getString("dept_name"));
                                instructor_list.add(admin);
                            }
                        }
                }catch (SQLException SE){
                        SE.printStackTrace();
                }
            }
            return instructor_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //查询教师信息(添加课程)
    public ArrayList<Admin> add_course_showALLinstructor() throws DaoException {
        ArrayList<Admin> instructor_list=new ArrayList<Admin>();
        String sql="SELECT t_id FROM instructor";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rst=ps.executeQuery()){
            while(rst.next()){
                Admin admin =new Admin();
                admin.setUsername(rst.getString("t_id"));
                instructor_list.add(admin);
            }
            return instructor_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //查询教师(已存在)
    public ArrayList<Admin> add_tid_showALLinstructor() throws DaoException {
        ArrayList<Admin> instructor_list=new ArrayList<Admin>();
        String sql="SELECT username FROM teacherlogin";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql);
                ResultSet rst=ps.executeQuery()){
            while(rst.next()){
                Admin admin =new Admin();
                admin.setUsername(rst.getString("username"));
                instructor_list.add(admin);
            }
            return instructor_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //删除教师信息
    public boolean delete_instructor(Admin admin) throws DaoException {
        String sql1="DELETE FROM teaches WHERE t_id=? and course_id=?";
        String sql2="SELECT course_id FROM teaches WHERE t_id=?";
        String sql3="DELETE FROM instructor WHERE t_id=?";
        try (
                Connection conn=getConnection();
                PreparedStatement ps1=conn.prepareStatement(sql1))
        {
            ps1.setString(1, admin.getUsername());
            ps1.setString(2, admin.getCourse_id());
            ps1.executeUpdate();
            try(
                    Connection conn1=getConnection();
                    PreparedStatement ps2=conn1.prepareStatement(sql2)){
                    ps2.setString(1, admin.getUsername());
                    ResultSet rst2=ps2.executeQuery();
                if(!rst2.next()){
                    try(
                            Connection conn2=getConnection();
                            PreparedStatement ps3=conn2.prepareStatement(sql3)) {
                            ps3.setString(1, admin.getUsername());
                            ps3.executeUpdate();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更新教师信息
    public boolean update_instructor(Admin admin,String old_course_id) throws DaoException {
        String sql1="UPDATE instructor set t_rank=?,intro=?,dept_name=? where t_id=?";
        String sql2="UPDATE teaches set course_id=? WHERE t_id=? and course_id=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps1=conn.prepareStatement(sql1);
                PreparedStatement ps2=conn.prepareStatement(sql2))
        {
            ps1.setString(1, admin.getRank());
            ps1.setString(2, admin.getDescription());
            ps1.setString(3, admin.getDept_name());
            ps1.setString(4, admin.getUsername());
            ps1.executeUpdate();
            ps2.setString(1, admin.getCourse_id());
            ps2.setString(2, admin.getUsername());
            ps2.setString(3,old_course_id);
            ps2.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    
    //显示所有留言
    public ArrayList<Admin> show_message() throws DaoException {
        ArrayList<Admin> message_list=new ArrayList<Admin>();
        String sql="SELECT * FROM community";
        try (Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Admin admin=new Admin();
                admin.setTitle(rs.getString("title"));
                admin.setS_id(rs.getString("s_id"));
                admin.setS_que(rs.getString("s_que"));
                admin.setS_pic(rs.getString("s_pic"));
                admin.setT_id(rs.getString("t_id"));
                admin.setT_ans(rs.getString("t_ans"));
                admin.setT_pic(rs.getString("t_pic"));
                message_list.add(admin);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
