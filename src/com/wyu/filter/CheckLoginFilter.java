/*
package com.wyu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckLoginFilter", value = "/*")
public class CheckLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 思路：
        // 1.得到用户操作的url,判断这个url,如果是login.jsp则可以放行,因为登录界面是不过滤的,注意,如果有些系统注册是需要个人注册的
        // 则注册页面也不用过滤,我们这个系统账号是不用自己注册,所以是管理员操作,没有注册页面的
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response =  (HttpServletResponse)resp;
        String contextPath = request.getContextPath();
        System.out.println("路径是:"+contextPath);
        String requestURI = request.getRequestURI();
        System.out.println("路径是2:"+requestURI);

        // 如果是登录界面就放行
        if(requestURI.indexOf("login.jsp") != -1 || requestURI.indexOf("CheckCodeUtil") != -1 || requestURI.indexOf("LoginServlet") != -1 || requestURI.indexOf("SelectZYBServlet") != -1 || requestURI.indexOf("RegisterServlet") != -1){
            chain.doFilter(req,resp);
            return;
        }else{
            // 如果不是登录界面
            // 判断用户是否登录
            // 得到session中的xs,判断其是否为空,如果为空说明是没有登录的,如果不为空则放行,说明登录了
            HttpSession session = request.getSession();
            Object xs = session.getAttribute("xs");
            if(xs == null) {
                // 表示输入的是登录界面
                response.sendRedirect("login.jsp");
                System.out.println("用户未登录");
            }else{
                // 放行
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
*/
