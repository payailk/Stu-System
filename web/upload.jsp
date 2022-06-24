<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Servlet3.0实现文件上传</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="./layui/layui.js"></script>
</head>

<body>

<%--
todo
 表单文件上传必须指定的属性 enctype
 这里没有使用表单文件上传  所以需要再后台代码上加注解 @MultipartConfig
--%>
<div style="margin: 10px">
    <img id="userImg" style="width:160px;height:160px;margin: 0 130px"  onerror="javascript:this.src='${pageContext.request.contextPath}/img/tx32.png'"  title="点击图片换头像" alt="点击图片换头像" src="${pageContext.request.contextPath}/img/${xs.zp}"/><br><br>
    <button id="submitBtn" class="layui-btn" style="width: 200px">确认</button>
    <button class="layui-btn" style="width: 200px">
        <a href="DownloadServlet?userImg=${xs.zp}">下载</a>
    </button>
</div>


<script type="text/javascript">
    layui.use(['upload','layer','jquery'],function(){
        var upload = layui.upload;
        var layer = layui.layer;
        var $ = layui.jquery;
        //初始化文件上传组件
        upload.render({
            elem:"#userImg",//绑定图片上传的容器
            //url:"user.do?service=updateImg",// 图片上传的接口
            url:"UploadServlet",
            data:{'service':"doPost"},
            auto:false,// 取消自动提交
            bindAction:"#submitBtn",//确认上传按钮
            field:"userImg",//上传的图片part名称
            choose:function(obj){
                //实现图片预览
                obj.preview(function(index,file,base64){
                    $("#userImg").attr("src",base64);
                });
            },
            done:function(rs,index,upload){
                if(rs.code == 200){
                    layer.msg("修改成功");
                    // 修改main.jsp页面上的图片
                    var imgUrl = rs.data;
                    alert(imgUrl)
                    // $("#img").prop("src",imgUrl);
                    window.parent.document.getElementById("img").src=imgUrl;
                    return false;
                }
                layer.msg(rs.msg);
            },
            error:function(index, upload){
                layer.msg("修改图像成功！");
            }
        });
    });
</script>
</body>

</html>