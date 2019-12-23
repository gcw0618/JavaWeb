package com.teacher_dao;

import javax.servlet.http.Part;
import java.sql.*;
import java.util.ArrayList;

public class teaDaoImpl implements teaDao{
    //教师更新密码
    public boolean tea_changepsw(Teacher teacher) throws DaoException {
        String sql="UPDATE teacherlogin set password=? where username=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, teacher.getPassword());
            ps.setString(2, teacher.getT_id());
            ps.executeUpdate();
            return true;
        }catch(SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //显示未回复的留言
    public ArrayList<Teacher> show_new_message(String t_id) throws DaoException {
        ArrayList<Teacher> message_list=new ArrayList<Teacher>();
        String sql1="SELECT course_id FROM teaches WHERE t_id=?";
        String sql2="SELECT title,s_id,s_que,s_pic FROM community WHERE t_read=? and title in(SELECT title FROM message WHERE course_id=?);";
        try (Connection conn=getConnection();
             PreparedStatement ps1=conn.prepareStatement(sql1);
             PreparedStatement ps2=conn.prepareStatement(sql2)){
            ps1.setString(1,t_id);
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next()){
                String course_id=rs1.getString("course_id");
                ps2.setString(1,"N");
                ps2.setString(2,course_id);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next()){
                    Teacher teacher=new Teacher();
                    teacher.setTitle(rs2.getString("title"));
                    teacher.setS_id(rs2.getString("s_id"));
                    teacher.setS_que(rs2.getString("s_que"));
                    teacher.setS_pic(rs2.getString("s_pic"));
                    teacher.setCourse_id(course_id);
                    message_list.add(teacher);
                }
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示教师自己的所有留言
    public ArrayList<Teacher> show_all_message(String username) throws DaoException {
        ArrayList<Teacher> message_list=new ArrayList<Teacher>();
        String sql="SELECT * FROM community WHERE t_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Teacher teacher=new Teacher();
                teacher.setTitle(rs.getString("title"));
                teacher.setS_id(rs.getString("s_id"));
                teacher.setS_que(rs.getString("s_que"));
                teacher.setT_ans(rs.getString("t_ans"));
                message_list.add(teacher);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //回复未回复的留言
    public boolean ans_new_message(Teacher teacher) throws DaoException {
        String sql="UPDATE community SET t_id=?,t_ans=?,s_read=?,t_pic=?,t_read=? WHERE title=? and s_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,teacher.getT_id());
            ps.setString(2,teacher.getT_ans());
            ps.setString(3,"N");
            ps.setString(4,teacher.getT_pic());
            ps.setString(5,"Y");
            ps.setString(6,teacher.getTitle());
            ps.setString(7,teacher.getS_id());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }
    }
    //显示所教的课程
    public ArrayList<Teacher> show_his_course(String t_id) throws DaoException {
        ArrayList<Teacher> course_list=new ArrayList<Teacher>();
        String sql="SELECT course_id FROM teaches WHERE t_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,t_id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Teacher teacher=new Teacher();
                teacher.setCourse_id(rs.getString("course_id"));
                course_list.add(teacher);
            }
            return course_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示该课程下的所有留言
    public ArrayList<Teacher> show_all_message_of_course(String course_id) throws DaoException {
        ArrayList<Teacher> message_list=new ArrayList<Teacher>();
        String sql="SELECT * FROM community WHERE title in(SELECT title FROM message WHERE course_id=? and t_read=?)";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,course_id);
            ps.setString(2,"N");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Teacher teacher=new Teacher();
                teacher.setTitle(rs.getString("title"));
                teacher.setS_id(rs.getString("s_id"));
                teacher.setS_que(rs.getString("s_que"));
                message_list.add(teacher);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return  null;
        }
    }
    //显示所有的学生
    public ArrayList<Teacher> show_all_student() throws DaoException {
        ArrayList stu_list=new ArrayList<Teacher>();
        String sql="SELECT username FROM studentlogin";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Teacher teacher=new Teacher();
                teacher.setS_id(rs.getString("username"));
                stu_list.add(teacher);
            }
            return stu_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示已被限制的学生
    public ArrayList<Teacher> show_admit_student(String t_id) throws DaoException {
        ArrayList<Teacher> stu_list=new ArrayList<Teacher>();
        String sql="SELECT s_id,course_id FROM admit WHERE t_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,t_id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Teacher teacher=new Teacher();
                teacher.setS_id(rs.getString("s_id"));
                teacher.setCourse_id(rs.getString("course_id"));
                stu_list.add(teacher);
            }
            return stu_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //增加被限制的学生
    public boolean add_admit(Teacher teacher) throws DaoException {
        String sql="INSERT INTO admit values(?,?,?)";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,teacher.getT_id());
            ps.setString(2,teacher.getCourse_id());
            ps.setString(3,teacher.getS_id());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //删除被限制的学生
    public boolean delete_admit(Teacher teacher) throws DaoException {
        String sql="DELETE FROM admit WHERE t_id=? and course_id=? and s_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,teacher.getT_id());
            ps.setString(2,teacher.getCourse_id());
            ps.setString(3,teacher.getS_id());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //显示所有留言
    public ArrayList<Teacher> show_all_student_message() throws DaoException {
        ArrayList<Teacher> message_list=new ArrayList<Teacher>();
        String sql="SELECT * FROM community";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Teacher teacher=new Teacher();
                teacher.setTitle(rs.getString("title"));
                teacher.setS_id(rs.getString("s_id"));
                teacher.setS_que(rs.getString("s_que"));
                teacher.setT_id(rs.getString("t_id"));
                teacher.setT_ans(rs.getString("t_ans"));
                message_list.add(teacher);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //删除留言
    public boolean delete_message(Teacher teacher) throws DaoException {
        String sql="DELETE FROM message WHERE title=? and s_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,teacher.getTitle());
            ps.setString(2,teacher.getS_id());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //删除教师自己的留言
    public boolean delete_tea_message(Teacher teacher) throws DaoException {
        String sql="UPDATE community SET t_id=?,t_ans=?,t_read=? WHERE title=? and s_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,null);
            ps.setString(2,null);
            ps.setString(3,"N");
            ps.setString(4,teacher.getTitle());
            ps.setString(5,teacher.getS_id());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //更新教师自己的留言
    public boolean update_tea_message(Teacher teacher) throws DaoException {
        String sql="UPDATE community SET t_ans=? , s_read=? ,t_read=? WHERE title=? and s_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,teacher.getNew_t_ans());
            ps.setString(2,"N");
            ps.setString(3,"N");
            ps.setString(4,teacher.getTitle());
            ps.setString(5,teacher.getS_id());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
