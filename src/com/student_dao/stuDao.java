package com.student_dao;

import java.util.ArrayList;
import com.page.*;

public interface stuDao extends dao{
    public boolean stu_add_register(Stu stu) throws DaoException;//学生注册
    public boolean stu_add_message(Stu stu) throws DaoException;//学生提出留言
    public ArrayList<Stu> stu_showHISmessage(String uername) throws DaoException;//显示学生自己的留言
    public boolean stu_update_messgae(Stu stu,String old_title,String s_id) throws DaoException;//更新学生自己留言
    public boolean stu_delete_message(Stu stu) throws DaoException;//删除学生留言
    public ArrayList<Stu> stu_show_t_ans(String username) throws DaoException;//显示新的教师回答
    public ArrayList<Stu> stu_show_course(String course_id) throws DaoException;//显示课程信息
    public ArrayList<Stu> stu_message_of_course(String course_id) throws DaoException;//显示属于该课程的留言
    public ArrayList<Stu> stu_message_of_t_id(String t_id) throws DaoException;//显示属于该教师的留言
    public ArrayList<Stu> stu_message_of_dept(String dept_name) throws DaoException;//显示属于该学院的留言
    public ArrayList<Stu> stu_message_of_word(String word) throws DaoException;//显示关键字的查询
    public ArrayList<Stu> stu_show_message(String username,String pageno,String pagesize) throws DaoException;//显示所有留言
    public int stu_show_message_size(String username) throws DaoException;//显示所有留言条数
    public PageModel<Stu> stu_show_message_page(String username,String pagesize,String pageno) throws DaoException;//显示所有留言分页
}
