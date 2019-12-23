package com.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(filterName="LoginFilter ")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest resquest, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest)resquest;
        HttpServletResponse hresponse = (HttpServletResponse)response;
        //设置统一编码格式
        hrequest.setCharacterEncoding("UTF-8");
        //无需登录过滤就能浏览的界面，像登录界面、注册界面、还有一些保存图片的路径，把它们单抽取出来
        if(hrequest.getServletPath().endsWith("login.jsp")|| 
           hrequest.getServletPath().endsWith("stu_register.jsp")||
           hrequest.getServletPath().endsWith("checklogin")||
           hrequest.getServletPath().endsWith("checkregister")||
           hrequest.getServletPath().endsWith("img.jsp")||
           hrequest.getServletPath().endsWith("CSS.css")||
                hrequest.getServletPath().endsWith("/image/mainPageImg.jpg")||
                hrequest.getServletPath().endsWith("test.jsp")){
            chain.doFilter(resquest,response);
        }else{
            //获取登录过后，全局共享数据
            Object name =hrequest.getSession().getAttribute("nowusername");
            if(name!=null){
                // 已经登陆,继续此次请求
                chain.doFilter(resquest, response);
            }else{
                //如果没有取到用户信息,非法访问，没有登陆，跳转到登陆页面
                hresponse.sendRedirect("login.jsp");//重定向到登录界面
            }
        }
    }
}

