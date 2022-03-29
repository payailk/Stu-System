<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/28
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form layui-form-pane" action="form.html">
    <div class="layui-form-item">
        <label class="layui-form-label">旧密码</label>
        <div class="layui-input-inline">
            <input type="text" name="password" lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-inline">
            <input type="text" name="NewPw" lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-inline">
            <input type="text" id="NewPw" name="ConfirmPw" lay-verify="required|checkPw" placeholder="确认密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="">确认修改</button>
    </div>
</form>

<script>
    layui.use(['form','layer','jquery'], function(){
        var form = layui.form
            ,$=layui.jquery
            ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            },
            checkPw: function(value){
                var pw = $('#NewPw').val();
                if(value!=pw){
                    return '密码不一致';
                }
            }
        });

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function(){
            var data = form.val('example');
            alert(JSON.stringify(data));
        });

    });
</script>
</body>
</html>
