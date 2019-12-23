package com.student_dao;

import com.page.PageModel;

import java.sql.*;
import java.util.ArrayList;

public class stuDaoImpl implements stuDao{
    //学生注册
    public boolean stu_add_register(Stu stu) throws DaoException {
        String sql="INSERT INTO studentlogin(username,password) SELECT ?,? FROM dual WHERE NOT EXISTS(SELECT * FROM studentlogin WHERE username=?)";
        try (Connection conn=getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,stu.getUsername());
            ps.setString(2,stu.getPassword());
            ps.setString(3,stu.getUsername());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //学生提出课程留言
    public boolean stu_add_message(Stu stu) throws DaoException {
        String sql1="INSERT INTO message(title,s_id,time,course_id) SELECT ?,?,?,? FROM dual WHERE NOT EXISTS(SELECT * FROM message WHERE title=? and s_id=?) ";
        String sql2="INSERT INTO community(title,s_id,s_que,s_read,s_pic,t_read) SELECT ?,?,?,?,?,? FROM dual WHERE NOT EXISTS(SELECT * FROM community WHERE title=? and s_id=?)";
        try (Connection conn=getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql1);
            ps.setString(1,stu.getTitle());
            ps.setString(2,stu.getUsername());
            ps.setString(3,stu.getTime());
            ps.setString(4,stu.getCourse_id());
            ps.setString(5,stu.getTitle());
            ps.setString(6,stu.getUsername());
            ps.executeUpdate();
            ps=conn.prepareStatement(sql2);
            ps.setString(1,stu.getTitle());
            ps.setString(2,stu.getUsername());
            ps.setString(3,stu.getS_que());
            ps.setString(4,"N");
            ps.setString(5,stu.getS_pic());
            ps.setString(6,"N");
            ps.setString(7,stu.getTitle());
            ps.setString(8,stu.getUsername());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //显示学生自己的留言
    public ArrayList<Stu> stu_showHISmessage(String username) throws DaoException {
        ArrayList<Stu> message_list=new ArrayList<Stu>();
        String sql="SELECT * FROM community WHERE s_id=?";
        try(
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1,username);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    Stu stu1=new Stu();
                    stu1.setTitle(rs.getString("title"));
                    stu1.setS_que(rs.getString("s_que"));
                    stu1.setS_pic(rs.getString("s_pic"));
                    message_list.add(stu1);
                }
                return message_list;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //更新学生自己留言
    public boolean stu_update_messgae(Stu stu,String old_title, String s_id) throws DaoException {
        String opt1=stu.getOpt1();
        String opt2=stu.getOpt2();
        try (Connection conn=getConnection()) {
            if(opt1.equals("yes")&&opt2.equals("yes")){
                String sql1="UPDATE message SET title=? , time=? WHERE s_id=? and title=?";
                String sql2="UPDATE community SET s_que=? , s_read=? , t_read=? WHERE s_id=? and title=?";
                PreparedStatement ps=conn.prepareStatement(sql1);
                ps.setString(1,stu.getTitle());
                ps.setString(2,stu.getTime());
                ps.setString(3,s_id);
                ps.setString(4,old_title);
                ps.executeUpdate();
                ps=conn.prepareStatement(sql2);
                ps.setString(1,stu.getS_que());
                ps.setString(2,"N");
                ps.setString(3,"N");
                ps.setString(4,s_id);
                ps.setString(5,stu.getTitle());
                ps.executeUpdate();
                return true;
             }
            else if(opt1.equals("yes")&&opt2.equals("no")){
                String sql1="UPDATE message SET title=? , time=? WHERE s_id=? and title=?";
                String sql2="UPDATE community SET s_read=? , t_read=?  WHERE s_id=? and title=?";
                PreparedStatement ps=conn.prepareStatement(sql1);
                ps.setString(1,stu.getTitle());
                ps.setString(2,stu.getTime());
                ps.setString(3,s_id);
                ps.setString(4,old_title);
                ps.executeUpdate();
                ps=conn.prepareStatement(sql2);
                ps.setString(1,"N");
                ps.setString(2,"N");
                ps.setString(3,s_id);
                ps.setString(4,old_title);
                return true;
            }
            else if(opt1.equals("no")&&opt2.equals("yes")){
                String sql1="UPDATE message SET time=? WHERE s_id=? and title=?";
                String sql2="UPDATE community SET s_que=? , s_read=? ,t_read=? WHERE s_id=? and title=?";
                PreparedStatement ps=conn.prepareStatement(sql1);
                ps.setString(1,stu.getTime());
                ps.setString(2,s_id);
                ps.setString(3,old_title);
                ps.executeUpdate();
                ps=conn.prepareStatement(sql2);
                ps.setString(1,stu.getS_que());
                ps.setString(2,"N");
                ps.setString(3,"N");
                ps.setString(4,s_id);
                ps.setString(5,old_title);
                ps.executeUpdate();
                return true;
            }

            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //删除学生留言
    public boolean stu_delete_message(Stu stu) throws DaoException {
        String sql="DELETE FROM message WHERE title=? and s_id=?";
        try (
                Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql))
            {
                ps.setString(1,stu.getTitle());
                ps.setString(2,stu.getUsername());
                ps.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //显示新的教师回答
    public ArrayList<Stu> stu_show_t_ans(String username) throws DaoException {
        ArrayList<Stu> que_list=new ArrayList<Stu>();
        String sql1="SELECT title,s_que,s_pic,t_ans,t_pic FROM community WHERE s_id=? and s_read=? and t_read=?";
        try (Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql1)){
            ps.setString(1,username);
            ps.setString(2,"N");
            ps.setString(3,"Y");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Stu stu=new Stu();
                String title=rs.getString("title");
                String s_que=rs.getString("s_que");
                String s_pic=rs.getString("s_pic");
                String t_ans=rs.getString("t_ans");
                String t_pic=rs.getString("t_pic");
                stu.setTitle(title);
                stu.setS_que(s_que);
                stu.setS_pic(s_pic);
                stu.setT_ans(t_ans);
                stu.setT_pic(t_pic);
                String sql2="UPDATE community SET s_read=? WHERE s_id=? and title=?";
                try (Connection conn2=getConnection();
                    PreparedStatement ps2=conn2.prepareStatement(sql2)){
                    ps2.setString(1,"Y");
                    ps2.setString(2,username);
                    ps2.setString(3,title);
                    ps2.executeUpdate();
                }
                que_list.add(stu);
            }
            return que_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示课程信息
    public ArrayList<Stu> stu_show_course(String course_id) throws DaoException {
        ArrayList<Stu> course_list=new ArrayList<Stu>();
        String sql1="SELECT * FROM course WHERE course_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql1)){
            ps.setString(1,course_id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Stu stu=new Stu();
                String description=rs.getString("description");
                String dept_name=rs.getString("dept_name");
                stu.setCourse_id(course_id);
                stu.setDescription(description);
                stu.setDept_name(dept_name);
                course_list.add(stu);
            }
            return course_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示属于该课程的留言
    public ArrayList<Stu> stu_message_of_course(String course_id) throws DaoException {
        ArrayList<Stu> message_list=new ArrayList<Stu>();
        String sql="select * from community where title in (select title from message where course_id=?)";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,course_id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Stu stu=new Stu();
                stu.setTitle(rs.getString("title"));
                stu.setS_id(rs.getString("s_id"));
                stu.setS_que(rs.getString("s_que"));
                stu.setT_id(rs.getString("t_id"));
                stu.setT_ans(rs.getString("t_ans"));
                message_list.add(stu);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return  null;
        }
    }
    //显示属于该教师的留言
    public ArrayList<Stu> stu_message_of_t_id(String t_id) throws DaoException {
        ArrayList<Stu> message_list=new ArrayList<Stu>();
        String sql="SELECT * FROM community WHERE t_id=?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,t_id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Stu stu=new Stu();
                stu.setTitle(rs.getString("title"));
                stu.setS_id(rs.getString("s_id"));
                stu.setS_que(rs.getString("s_que"));
                stu.setT_id(rs.getString("t_id"));
                stu.setT_ans(rs.getString("t_ans"));
                message_list.add(stu);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示属于该学院的留言
    public ArrayList<Stu> stu_message_of_dept(String dept_name) throws DaoException {
        ArrayList<Stu> message_list=new ArrayList<Stu>();
        String sql="SELECT community.* FROM community join message using(title,s_id) WHERE message.course_id in(SELECT course_id FROM course WHERE dept_name=?)";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,dept_name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Stu stu=new Stu();
                stu.setTitle(rs.getString("title"));
                stu.setS_id(rs.getString("s_id"));
                stu.setS_que(rs.getString("s_que"));
                stu.setT_id(rs.getString("t_id"));
                stu.setT_ans(rs.getString("t_ans"));
                message_list.add(stu);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示关键字的留言
    public ArrayList<Stu> stu_message_of_word(String word) throws DaoException {
        ArrayList<Stu> message_list=new ArrayList<Stu>();
        String sql="SELECT * FROM community WHERE 1=1 ";
        try (Connection conn=getConnection()){
            sql+="and title like '%"+word+"%'";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while ((rs.next())){
                Stu stu=new Stu();
                stu.setTitle(rs.getString("title"));
                stu.setS_id(rs.getString("s_id"));
                stu.setS_que(rs.getString("s_que"));
                stu.setT_id(rs.getString("t_id"));
                stu.setT_ans(rs.getString("t_ans"));
                message_list.add(stu);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //显示所有留言
    public ArrayList<Stu> stu_show_message(String username,String pageno,String pagesize) throws DaoException {
        ArrayList<Stu> message_list=new ArrayList<Stu>();
        //String sql="select community.*,message.course_id,admit.s_id from community join message  on community.s_id=message.s_id and community.title=message.title join admit  on community.t_id=admit.t_id and message.course_id=admit.course_id where admit.s_id=? or community.t_id=? limit ?,?";
        //String sql="select community.*,message.course_id,admit.s_id from community join message  on community.s_id=message.s_id and community.title=message.title join admit  on community.t_id=admit.t_id and message.course_id=admit.course_id where admit.s_id=?";
        String sql="select * from community join message using(title,s_id)\n" +
                "where community.t_id not in(select username from teacherlogin) or community.t_id=? or community.t_id is null or " +
                "(community.t_id,message.course_id) in(select t_id,course_id from admit where s_id=?) limit ?,?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,"");
            ps.setString(2,username);
            ps.setInt(3,(Integer.parseInt(pageno)-1)*Integer.parseInt(pagesize));
            ps.setInt(4,Integer.parseInt(pagesize));
            //ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Stu stu=new Stu();
                stu.setTitle(rs.getString("title"));
                stu.setS_id(rs.getString("s_id"));
                stu.setS_que(rs.getString("s_que"));
                stu.setCourse_id(rs.getString("course_id"));
                stu.setT_id(rs.getString("t_id"));
                stu.setT_ans(rs.getString("t_ans"));
                message_list.add(stu);
            }
            return message_list;
        }catch (SQLException e){
            e.printStackTrace();;
            return null;
        }
    }
    //显示所有留言条数
    public int stu_show_message_size(String username) throws DaoException {
        int size;
        //String sql="select community.*,message.course_id,admit.s_id from community join message  on community.s_id=message.s_id and community.title=message.title join admit  on community.t_id=admit.t_id and message.course_id=admit.course_id where admit.s_id=? or community.t_id=? limit ?,?";
        //String sql="select community.*,message.course_id,admit.s_id from community join message  on community.s_id=message.s_id and community.title=message.title join admit  on community.t_id=admit.t_id and message.course_id=admit.course_id where admit.s_id=?";
        String sql="select * from community join message using(title,s_id)\n" +
                "where community.t_id not in(select username from teacherlogin) or community.t_id=? or community.t_id is null or " +
                "(community.t_id,message.course_id) in(select t_id,course_id from admit where s_id=?)";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,"");
            ps.setString(2,username);
            
            ResultSet rs=ps.executeQuery();
            rs.last();
            size=rs.getRow();
           
            System.out.println(size);
            return size;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    //显示所有留言分页
    public PageModel<Stu> stu_show_message_page(String username,String pagesize,String pageno) throws DaoException {
        PageModel<Stu> pageModel=null;
        ArrayList<Stu> message_list=new ArrayList<Stu>();
        //String sql="SELECT * FROM community WHERE t_id and course_idin(SELECT t_id,course_id FROM admit WHERE s_id=?)";
        String sql="select  * from community limit ?,?";
        //String sql="select community.*,message.course_id,admit.s_id \n from community join message  on community.s_id=message.s_id and community.title=message.title join admit  on community.t_id=admit.t_id and message.course_id=admit.course_id where admit.s_id=? limit ?,?";
        try (Connection conn=getConnection();
             PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setInt(1,((Integer.parseInt(pageno)-1)*(Integer.parseInt(pagesize))));
            ps.setInt(2, Integer.parseInt(pagesize));
            /*
            ps.setString(1,username);
            ps.setInt(2,(pageModel.getPageNo()-1)*pageModel.getPageSize());
            ps.setInt(3,pageModel.getPageSize());
             */
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                 Stu stu=new Stu();
                 stu.setTitle(rs.getString("title"));
                 stu.setS_id(rs.getString("s_id"));
                 stu.setS_que(rs.getString("s_que"));
                 stu.setT_id(rs.getString("t_id"));
                 stu.setT_ans(rs.getString("t_ans"));
                 message_list.add(stu);
             }
             ResultSet rs2=ps.executeQuery("select count(*) from community");
             int total=0;
             if(rs2.next()) {
                 rs2.getInt(1);
             }
             pageModel=new PageModel<Stu>();
             pageModel.setPageNo(Integer.parseInt(pageno));
             pageModel.setPageSize(Integer.parseInt(pagesize));
             pageModel.setList(message_list);
             pageModel.setTotalRecords(total);
            return pageModel;
            //return message_list;
        }catch (SQLException e){
            e.printStackTrace();;
            return null;
        }
    }

}
