package com.wyu.web;

import com.wyu.pojo.Xsb;
import com.wyu.service.XSBServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取输入的验证码
        String checkcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        // 获取session中的验证码
        String code = session.getAttribute("code") + "";
        // 判断验证码
        if(!checkcode.equals(code)){
            // 验证失败
            // 保存一个信息到session中由前端获取
            session.setAttribute("registerMsg","验证码错误！");
            // 跳转到注册界面
            response.sendRedirect("register.jsp");
            return;
        }
        // 判断用户是否存在
        // 用三层架构完成代码编写
        // 获取注册信息
        String xh = request.getParameter("xh");
        String xm = request.getParameter("xm");
        String mm = request.getParameter("mm");
        String xb = request.getParameter("xb");
        String cssj = request.getParameter("cssj");
        String zy_id = request.getParameter("zy_id");
        String zxf = request.getParameter("zxf");
        String zp = request.getParameter("zp");
        System.out.println("姓名："+xm+",学号："+xh+",密码："+mm+",性别："+xb+",出生时间："+cssj+",专业名称："+zy_id+",总学分："+zxf+",照片："+zp);
        // 将用户名和密码提交给service完成业务逻辑处理
        XSBServiceImpl xsbService = new XSBServiceImpl();
        // 调用注册方法
        Xsb xs = xsbService.register(xh, xm, mm, xb, cssj, zy_id, zxf, zp);
        if(xs!=null){
            session.setAttribute("registerMsg","用户已存在！");
            response.sendRedirect("register.jsp");
            return;
        }
        // 允许注册
        // 保存提示信息
        // 保存一个信息到session中由前端获取
        session.setAttribute("loginMsg","注册成功");
        // 跳转到登录界面
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}