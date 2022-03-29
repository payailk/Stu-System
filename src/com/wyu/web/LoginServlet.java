package com.wyu.web;

import com.wyu.pojo.Xsb;
import com.wyu.service.XSBService;
import com.wyu.service.XSBServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取输入的验证码
        String checkcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        // 获取session中的验证码
        String code = session.getAttribute("code") + "";
        // 判断验证码
        if(!code.equals(checkcode)){
            // 验证失败
            // 保存一个信息到session中由前端获取
            session.setAttribute("loginMsg","验证码错误");
            // 跳转到登录界面
            response.sendRedirect("login.jsp");
            return;
        }
        // 判断用户名和密码
        // 用三层架构完成代码编写
        // 获取学号和密码
        String xh = request.getParameter("xh");
        String mm = request.getParameter("mm");
        System.out.println("学号："+xh+",密码："+mm);
        // 将用户名和密码提交给service完成业务逻辑处理
        XSBService XSBService = new XSBServiceImpl();
        // 调用登录的方法
        Xsb xs = XSBService.login(xh,mm);
        if(xs!=null){
            // 保存学生到session中跳转到首页
            session.setAttribute("xs",xs);
            response.sendRedirect("index.jsp");
            // 置空登录信息
            session.setAttribute("loginMsg","");
            return;
        }
        // 用户名或密码错误
        // 保存提示信息
        // 保存一个信息到session中由前端获取
        session.setAttribute("loginMsg","用户名或密码错误");
        // 跳转到用户界面
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}