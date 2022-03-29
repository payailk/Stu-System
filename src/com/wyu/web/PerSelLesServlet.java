package com.wyu.web;

import com.alibaba.fastjson.JSON;
import com.wyu.pojo.KCB;
import com.wyu.pojo.Xsb;
import com.wyu.service.KCBServiceImpl;
import com.wyu.service.XSBService;
import com.wyu.service.XSBServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/PerSelKCServlet")
public class PerSelLesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 处理分页问题
        // layui会每次请求是带两个参数到后台，得到这两个参数，就可以完成分页了
        // 这两个参数：分别是page，colmit
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println("page==" + page);
        System.out.println("limit==" + limit);

        // 获取学号
        HttpSession session = request.getSession();
        Xsb xs = (Xsb) session.getAttribute("xs");
        int xh = xs.getXh();

        // 去service层完成查询操作
        KCBServiceImpl kcb = new KCBServiceImpl();
        List<KCB> list = kcb.PerSelLes(xh,page,limit);

        // 判断总条数
        int count = kcb.selectCountByXh(xh);
        // 判断集合 != null
        if(list.size()>0){
            // 查询到数据了
            String listjson = JSON.toJSONString(list);
            // layui前端要求是要封装成json数据，才可以解析，所以要将list集合解析成json格式的数据才可以
            String json = "{\"code\":0,\"msg\":\"\",\"count\":"+count+",\"data\":"+listjson+"}";
            System.out.println("json-->"+json);
            response.getWriter().append(json);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
