package com.wyu.web;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.Zyb;
import com.wyu.service.ZYBServiceImpl;
import com.wyu.service.ZYBservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectZYBServlet")
public class SelectZYBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用select操作数据
        ZYBservice service = new ZYBServiceImpl();
        // 查询所有专业的方法
        List<Zyb> zys = service.selectZYAll();
        if(zys!=null){
            String listjson = JSON.toJSONString(zys);
            // layui前端要求是要封装成json数据，才可以解析，所以要将list集合解析成json格式的数据才可以
            String json = "{\"code\":0,\"msg\":\"\",\"count\":"+15+",\"data\":"+listjson+"}";
            System.out.println("json-->"+json);
            response.getWriter().append(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}