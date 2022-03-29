<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/27
  Time: 10:52
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
<div class="layui-carousel" id="test1">
    <div carousel-item="">
        <div><img src="${pageContext.request.contextPath}/img/tp1.jpg" width="100%" height="1000px"></div>
        <div><img src="${pageContext.request.contextPath}/img/tp2.jpg" width="100%" height="1000px"></div>
        <div><img src="${pageContext.request.contextPath}/img/tp3.jpg" width="100%" height="1000px"></div>
        <div><img src="${pageContext.request.contextPath}/img/tp4.jpg" width="100%" height="1000px"></div>
    </div>
</div>

<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //图片轮播
        carousel.render({
            elem: '#test1'
            ,anim: 'fade'
            ,width: '100%'
            ,height: '1000px'
            ,interval: 3000
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });

        //其它示例
        $('.demoTest .layui-btn').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>
</body>
</html>
