<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/27
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
</head>
<body>
    <div style="width: 350px;margin: 15px;border: #ccc 3px solid;border-radius: 5px">
        <center>
            <h1 style="color: #009688">个人信息</h1>
        </center>
    <form class="layui-form layui-form-pane" action="form.html">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="required" value="${xs.xm}" disabled = "disabled" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="required" value="${xs.xh}" disabled = "disabled" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="required" value="${xs.xb}" disabled = "disabled" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="required" value="${xs.cssj}" disabled = "disabled" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">总学分</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="required" value="${xs.zxf}" disabled = "disabled" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="required" value="${xs.bz}" disabled = "disabled" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">照片</label>
            <div class="layui-input-inline">
                <img src="${pageContext.request.contextPath}/img/${xs.zp}" style="width: 150px;height: 150px;" onerror="javascript:this.src='${pageContext.request.contextPath}/img/tx32.png'">
            </div>
        </div>
    </form>
    </div>

</body>
</html>
