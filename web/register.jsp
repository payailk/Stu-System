<%-- Created by IntelliJ IDEA. User: Robin Date: 2021-11-12 Time: 11:27 To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>注册</title>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <link rel="stylesheet" href="./layui/css/layui.css" media="all">
    <script src="./layui/layui.js" charset="utf-8"></script>
    <style> body {
        background-size: cover;
        background-color: #aaa;
        margin-top: 30px;
    }

    #div1 {
        margin: 0 auto;
        background-color: #ffffff;
        width: 600px;
        height: 650px;
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
<body >
<div id="div1">
    <div id="div1_div1">后台管理-注册</div>
    <form id="myForm" action="RegisterServlet" method="post">
        <table style="margin: 0 auto;">
            <tr>
                <td>姓名</td>
                <td><input type="text" name="xm" class="input1"></td>
            </tr>
            <tr>
                <td>账号</td>
                <td><input type="text" name="xh" class="input1"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="mm" class="input1"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="radio" name="xb" value="1"> 男 <input type="radio" name="xb" value="0"> 女</td>
            </tr>
            <tr>
                <td>出生时间</td>
                <td><input type="date" name="cssj" class="input1"></td>
            </tr>
            <tr>
                <td>专业名称</td>
                <td><%--<input
                        type="radio" name="zy_id" value="1"> 软件工程 <input
                        type="radio" name="zy_id" value="2"> 通信工程 <input
                        type="radio" name="zy_id" value="3"> 计算机科学与技术 <input
                        type="radio" name="zy_id" value="4"> 物联网工程 <input
                        type="radio" name="zy_id" value="5"> 工商管理--%>
                    <select name="zy_id" id="">
                        <option name="zy_id" value="1">软件工程</option>
                        <option name="zy_id" value="2">通信工程</option>
                        <option name="zy_id" value="3">计算机科学与技术</option>
                        <option name="zy_id" value="4">物联网工程</option>
                        <option name="zy_id" value="5">工商管理</option>
                    </select>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td>总学分</td>--%>
<%--                <td><input type="text" name="zxf" class="input1"></td>--%>
<%--            </tr>--%>
<%--            <tr>
                <td>照片</td>
                <td><input type="text" name="zp" class="input1"></td>
            </tr>--%>
            <tr>
                <td>验证码</td>
                <td style="position: relative;"><input type="text" name="checkcode" class="input1"
                                                       style="width: 100px;height: 37px;"><a href="javascript:(0)"
                                                                                             onclick="refresh()"> <img
                        id="checkcodeImg" src="CheckCodeUtil"
                        style="border: 1px #000 solid;position:absolute;left: 105px;border-radius: 3px"> </a><a
                        href="javascript:(0)" onclick="refresh()"
                        style="position:absolute;right: -70px;top: 7px;text-decoration: none">看不清，换一张</a></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="注&nbsp;&nbsp;册" class="sub">
                </td>
            </tr>
            <tr>
                <td></td>
                <td><span style="color: red;font-size: 12px;">${registerMsg}</span></td>
            </tr>
        </table>
    </form>
</div>
</body>
<script> /* 刷新验证码的函数*/
function refresh() {
    var checkcodeImg = document.getElementById("checkcodeImg");/* 修改img的src属性*/
    checkcodeImg.setAttribute("src", "CheckCodeUtil?" + new Date().getTime());
}/* 表单验证的操作*/
$(function () {
    $("#myForm").validate({
        rules: {
            xm: {required:true},
            xh: {required: true, digits: true, rangelength: [7, 10],},
            mm: {required: true, rangelength: [1, 8]},
            xb: "required",
            cssj: "required",
            zy_id: "required",
            // zxf: {required: true, rangelength:[0,3]},
            // zp: "required",
            checkcode: {required: true, rangelength: [4, 4],},
        },
        messages: {
            xm: {
                required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>姓名不能为空</span>",
            },
            xh: {
                required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>学号不能为空</span>",
                digits: "&nbsp;&nbsp;<span style='color: red; font-size: 11px;'>学号只能是整数</span>",
                rangelength: "&nbsp;&nbsp;<span style='color: red; font-size: 11px;'>学号必需7-10位</span>",
            },
            mm: {
                required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>密码不能为空</span>",
                rangelength: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>密码需为1-8位之间</span>"
            },
/*            zxf: {
                required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>学分不能为空</span>",
                rangelength: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;'>需为0-3位之间</span>",
            },*/
            checkcode: {
                required: "&nbsp;&nbsp;<span style='color: #ff0000; font-size: 11px;position: absolute;top: 40px;'>验证码不能为空</span>",
                rangelength: "&nbsp;&nbsp;<span style='color: red; font-size: 11px;position: absolute;top: 40px;'>验证码只能是4位</span>",
            },
        },
    })
})</script>
</html>
