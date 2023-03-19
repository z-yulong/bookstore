package com.zyl.bookstore.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/hello")
public class HelloServlet implements Servlet {
    public HelloServlet(){
        System.out.println("public HelloServlet()");
    }
    @Override
    public void init(ServletConfig config){
        System.out.println("public void init(ServletConfig config)");
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) {
        System.out.println("public void service(ServletRequest req, ServletResponse res)");
        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("msg" ,"哈哈哈");
    }
    @Override
    public void destroy() {
        System.out.println("public void destroy()");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public String getServletInfo() {
        return null;
    }
}
