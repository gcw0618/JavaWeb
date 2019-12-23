package com.admin_dao;

import java.util.ArrayList;

public interface adminDao extends dao {
    public boolean add_teacher_User(Admin admin) throws DaoException;//添加老师用户名密码
    public boolean update_admin_pwd(Admin admin) throws DaoException;//更改admin密码
    public boolean update_stu_pwd(Admin admin) throws DaoException;//更改stu密码

    public boolean add_instructor(Admin admin) throws  DaoException;//添加教师信息
    public ArrayList<Admin> add_tid_showALLinstructor() throws DaoException;//查询教师已注册
    public ArrayList<Admin> admin_showALLinstructor() throws DaoException;//查询教师信息(管理教师)
    public ArrayList<Admin> add_course_showALLinstructor() throws DaoException;//查询教师信息(添加课程)
    public boolean delete_instructor(Admin admin) throws DaoException;//删除教师信息
    public boolean update_instructor(Admin admin,String old_course_id) throws DaoException;//更新教师信息

    public boolean add_department(Admin admin) throws  DaoException;//添加dept
    public boolean update_department(Admin admin) throws DaoException;//更改dept
    public boolean delete_department(Admin admin) throws DaoException;//删除dept
    public ArrayList<Admin> showALLdepartment() throws DaoException;//查询所有学院
    
    public boolean add_course(Admin admin) throws  DaoException;//增加课程信息
    public boolean update_course(Admin admin) throws DaoException;//更新课程信息
    public ArrayList<Admin> showALLcourse() throws DaoException;//查询所有课程(有重复)
    public ArrayList<Admin> updateshowALLcourse() throws DaoException;//查询所有课程(无重复，用于更新)
    public boolean delete_instructor_course(Admin admin) throws DaoException;//删除一个老师课程
    public boolean delete_course(Admin admin) throws DaoException;//删除一整个课程
    public ArrayList<Admin> find_course_Bydept(String dept_name) throws DaoException;//根据学院查找课程
    public ArrayList<Admin> fing_course_Byt_id(String t_id) throws DaoException;//根据教师名字查找课程
    public ArrayList<Admin> show_message() throws DaoException;//显示所有留言
    
    //public Admin findBYID(int id) throws  DaoException;
    //public ArrayList<Admin> findALLUser() throws  DaoException;
}
