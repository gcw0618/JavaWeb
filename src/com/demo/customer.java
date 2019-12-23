package com.demo;

import java.io.Serializable;

public class customer implements Serializable {
    private String username;
    private String password;
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(){
        this.username=username;
    }
    public void setPassword(){
        this.password=password;
    }
}
