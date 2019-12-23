package com.student_dao;

import java.io.Serializable;

public class Stu implements Serializable {
    private String username;
    private String password;
    private String course_id;
    private String description;
    private String dept_name;
    private String title;
    private String old_title;
    private String s_id;
    private String s_que;
    private String t_id;
    private String t_ans;
    private String time;
    private int num;
    private String opt1;
    private String opt2;
    private String s_pic;
    private String t_pic;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCourse_id() { return course_id; }
    public void setCourse_id(String course_id) { this.course_id = course_id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDept_name() { return dept_name; }
    public void setDept_name(String dept_name) { this.dept_name = dept_name; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getOld_title() { return old_title; }
    public void setOld_title(String old_title) { this.old_title = old_title; }
    public String getS_id() { return s_id; }
    public void setS_id(String s_id) { this.s_id = s_id; }
    public String getS_que() { return s_que; }
    public void setS_que(String s_que) { this.s_que = s_que; }
    public String getT_id() { return t_id; }
    public void setT_id(String t_id) { this.t_id = t_id; }
    public String getT_ans() { return t_ans; }
    public void setT_ans(String t_ans) { this.t_ans = t_ans; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public int getNum() { return num; }
    public void setNum(int num) { this.num = num; }
    public void setOpt1(String opt1) { this.opt1 = opt1; }
    public String getOpt1() { return opt1; }
    public void setOpt2(String opt2) { this.opt2 = opt2; }
    public String getOpt2() { return opt2; }
    public String getS_pic() { return s_pic; }
    public void setS_pic(String s_pic) { this.s_pic = s_pic; }
    public String getT_pic() { return t_pic; }
    public void setT_pic(String t_pic) { this.t_pic = t_pic; }
}
