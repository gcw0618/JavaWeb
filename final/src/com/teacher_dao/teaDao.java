package com.teacher_dao;

import java.util.ArrayList;

public interface teaDao extends dao{
    public boolean tea_changepsw(Teacher teacher) throws DaoException;//教师更新密码
    public ArrayList<Teacher> show_new_message(String username) throws DaoException;//显示未回复的留言
    public ArrayList<Teacher> show_all_message(String username) throws DaoException;//显示教师自己的所有留言
    public boolean ans_new_message(Teacher teacher) throws DaoException;//回复未回复的留言
    public ArrayList<Teacher> show_his_course(String username) throws DaoException;//显示所教的课程
    public ArrayList<Teacher> show_all_message_of_course(String course_id) throws DaoException;//显示该课程下的所有留言
    public ArrayList<Teacher> show_all_student() throws DaoException;//显示所有的学生
    public ArrayList<Teacher> show_admit_student(String t_id) throws DaoException;//显示已被限制的学生
    public boolean add_admit(Teacher teacher) throws DaoException;//增加被限制的学生
    public boolean delete_admit(Teacher teacher) throws DaoException;//删除被限制的学生
    public ArrayList<Teacher> show_all_student_message() throws DaoException;//显示所有留言
    public boolean delete_message(Teacher teacher) throws DaoException;//删除留言
    public boolean delete_tea_message(Teacher teacher) throws DaoException;//删除教师自己的留言
    public boolean update_tea_message(Teacher teacher) throws DaoException;//更新教师自己的留言
}
