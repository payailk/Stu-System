<%@ page import="com.wyu.service.XSBService" %>
<%@ page import="com.wyu.service.XSBServiceImpl" %>
<%@ page import="com.wyu.pojo.Xsb" %>
<%@ page import="com.wyu.util.MD5Util" %><%-- Created by IntelliJ IDEA. User: Robin Date: 2021-11-08 Time: 10:18 To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>登录界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <style> body {
        background-size: cover;
        margin-top: 30px;
    }

    #div1 {
        margin: 0 auto;
        background-color: #ffffff;
        width: 600px;
        height: 500px;
        border-radius: 10px;
        text-align: center;
    }

    #div1_div1 {
        height: 80px;
        line-height: 80px;
        font-size: 26px;
        color: #0074BB;
        font-weight: bold;
    }

    table {
        border-spacing: 5px 20px;
        border-collapse: inherit;
    }

    .input1 {
        width: 260px;
        height: 35px;
        border-radius: 3px;
        border: 1px #0074BB solid;
    }

    .sub {
        width: 90px;
        height: 40px;
        border: none;
        font-size: 16px;
        border-radius: 3px;
        transition: all 0.6s;
    }

    .sub:hover {
        transition: all 0.6s;
        border-radius: 0px;
    }</style>
</head>

<%
    //获取cookie
    Cookie[] cookies = request.getCookies();
    //取出cookie中的值
    String userNumber = "";
    String password = "";
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie: cookies) {
            String cookieName = cookie.getName();
            if ("xh".equalsIgnoreCase(cookieName)) {
                userNumber = cookie.getValue();
            }
            if ("mm".equalsIgnoreCase(cookieName)) {
                password = cookie.getValue();
            }
//    if (userNumber.equalsIgnoreCase(cookieName)){
//    request.getRequestDispatcher(index.jsp).forward(request, response);
//    }
        }
    }
    // 将用户名和密码提交给service完成业务逻辑处理
    XSBService XSBService = new XSBServiceImpl();
    // 调用登录的方法
    Xsb xs = XSBService.login(userNumber, MD5Util.code(password));
    if(xs!=null){
        // 保存学生到session中跳转到首页
        session.setAttribute("xs",xs);
        response.sendRedirect("index.jsp");
        // 置空登录信息
        session.setAttribute("loginMsg","");
        return;
    }
%>

<body>
<div id="div1" class="layui-bg-green">
    <div id="div1_div1">后台管理-登录</div>
    <form id="myForm" action="LoginServlet" method="post">
        <table style="margin: 0 auto;">
            <tr>
                <td>账号</td>
                <td><input type="text" name="xh" id="xh" class="input1"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="mm" id="mm" class="input1"></td>
            </tr>
            <%--<tr> <td>性别</td> <td> <input type="radio" name="sex" value="男"> 男<input type="radio" name="sex" value="女">女 </td> </tr> <tr> <td>爱好</td> <td> <input type="checkbox" name="like" value="lq">篮球 <input type="checkbox" name="like" value="pq">排球 <input type="checkbox" name="like" value="ppq">乒乓球 <input type="checkbox" name="like" value="ymq">羽毛球 </td> </tr> <tr> <td>城市</td> <td> <select name="city"> <option value="bj">北京</option> <option value="sh">上海</option> <option value="gz">广州</option> <option value="sz">深圳</option> </select> </td> </tr>--%>
            <tr>
                <td>验证码</td>
                <td style="position: relative;"><input type="text" name="checkcode" class="input1"
                                                       style="width: 100px;height: 37px;"><a href="javascript:(0)"
                                                                                             onclick="refresh()"> <img
                        id="checkcodeImg" src="${pageContext.request.contextPath}/CheckCodeUtil"
                        style="border: 1px #000 solid;position:absolute;left: 105px;border-radius: 3px"> </a><a
                        href="javascript:(0)" onclick="refresh()"
                        style="position:absolute;right: -70px;top: 7px;text-decoration: none">看不清，换一张</a></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="登&nbsp;&nbsp;录" class="sub">
                    <a href="register.jsp"><input type="button" value="注&nbsp;&nbsp;册" class="sub"></a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><span style="color: red;font-size: 12px;">${loginMsg}</span></td>
            </tr>
        </table>
    </form>
</div>
</body>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script> /* 刷新验证码的函数*/
$("#xh").val(<%=userNumber%>);
$("#mm").val(<%=password%>);
</script>

<script> /* 刷新验证码的函数*/
function refresh() {
    var checkcodeImg = document.getElementById("checkcodeImg");/* 修改img的src属性*/
    checkcodeImg.setAttribute("src", "${pageContext.request.contextPath}/CheckCodeUtil?" + new Date().getTime());
}/* 表单验证的操作*/
$(function () {
    $("#myForm").validate({
        rules: {
            xh: {required: true, digits: true, rangelength: [7, 10],},
            mm: {required: true,},
            checkcode: {required: true, rangelength: [4, 4],},
        },
        messages: {
            xh: {
                required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>学号不能为空</span>",
                digits: "&nbsp;&nbsp;<span style='color: red; font-size: 11px;'>学号只能是整数</span>",
                rangelength: "&nbsp;&nbsp;<span style='color: red; font-size: 11px;'>学号必需7-10位</span>",
            },
            mm: {required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>密码不能为空</span>",},
            checkcode: {
                required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;position: absolute;top: 40px;'>验证码不能为空</span>",
                rangelength: "&nbsp;&nbsp;<span style='color: red; font-size: 11px;position: absolute;top: 40px;'>验证码只能是4位</span>",
            },
        },
    })
})</script>
</html>
