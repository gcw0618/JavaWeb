package com.teacher_dao;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String title;
    private String s_id;
    private String s_que;
    private String s_pic;
    private String t_id;
    private String t_ans;
    private String t_pic;
    private String new_t_ans;
    private String course_id;
    private String password;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getS_id() { return s_id; }
    public void setS_id(String s_id) { this.s_id = s_id; }
    public String getS_que() { return s_que; }
    public void setS_que(String s_que) { this.s_que = s_que; }
    public String getT_id() { return t_id; }
    public void setT_id(String t_id) { this.t_id = t_id; }
    public String getT_ans() { return t_ans; }
    public void setT_ans(String t_ans) { this.t_ans = t_ans; }
    public String getNew_t_ans() { return new_t_ans; }
    public void setNew_t_ans(String new_t_ans) { this.new_t_ans = new_t_ans; }
    public String getCourse_id() { return course_id; }
    public void setCourse_id(String course_id) { this.course_id = course_id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getS_pic() { return s_pic; }
    public void setS_pic(String s_pic) { this.s_pic = s_pic; }
    public String getT_pic() { return t_pic; }
    public void setT_pic(String t_pic) { this.t_pic = t_pic; }
}
