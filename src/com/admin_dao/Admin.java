package com.admin_dao;

import javax.print.DocFlavor;
import java.io.Serializable;
import java.util.ArrayList;

public class Admin implements Serializable {
    private String username;
    private String password;
    private String dept_name;
    private String newdept_name;
    private String course_id;
    private String description;
    private String rank;
    private String title;
    private String s_id;
    private String s_que;
    private String s_pic;
    private String t_id;
    private String t_ans;
    private String t_pic;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public void setDept_name(String dept_name) { this.dept_name = dept_name; }
    public String getDept_name() { return dept_name; }
    public String getCourse_id() { return course_id; }
    public void setCourse_id(String course_id) { this.course_id = course_id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }
    public String getNewdept_name() { return newdept_name; }
    public void setNewdept_name(String newdept_name) { this.newdept_name = newdept_name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getS_id() { return s_id; }
    public void setS_id(String s_id) { this.s_id = s_id; }
    public String getS_que() { return s_que; }
    public void setS_que(String s_que) { this.s_que = s_que; }

    public String getS_pic() { return s_pic; }
    public void setS_pic(String s_pic) { this.s_pic = s_pic; }
    public String getT_id() { return t_id; }
    public void setT_id(String t_id) { this.t_id = t_id; }
    public String getT_ans() { return t_ans; }
    public void setT_ans(String t_ans) { this.t_ans = t_ans; }
    public String getT_pic() { return t_pic; }
    public void setT_pic(String t_pic) { this.t_pic = t_pic; }
}
