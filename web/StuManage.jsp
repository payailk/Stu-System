<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2021/11/27
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-btn-group demoTable">
    <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
    <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
    <button class="layui-btn" data-type="isAll">验证是否全选</button>
</div>
<button class="layui-btn" style="width: 200px">
    <a href="ExcelDownloadServlet?page=1&limit=200">下载</a>
</button>
<table class="layui-table" lay-data="{width: 1031.33, height:500, url:'${pageContext.request.contextPath}/SelectXCBServlet', page:true, id:'idTest'}" lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'xh', width:'11%', sort: true, fixed: true}">学号</th>
        <th lay-data="{field:'xm', width:'8.5%'}">姓名</th>
        <th lay-data="{field:'xb', width:'6%'}">性别</th>
        <th lay-data="{field:'cssj', width:'12%'}">生日</th>
        <th lay-data="{field:'zxf', width:'7.5%'}">总学分</th>
        <th lay-data="{field:'bz', width:'30%'}">备注</th>

        <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
    </tr>

    </thead>
</table>

<div style="display: none" class="add_show_div">
    <form class="layui-form layui-form-pane" action="form.html" id="myForm">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">原学号</label>
            <div class="layui-input-inline">
                <input type="text" id="oldUserId" name="id" placeholder="请输入原学号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学号</label>
            <div class="layui-input-inline">
                <input type="text" id="userId" name="id" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--<div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="radio" name="sex" value="1" title="男" checked="">
                <input type="radio" name="sex" value="0" title="女">
            </div>
        </div>--%>
        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="birth" name="birth" autocomplete="off" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">总学分</label>
            <div class="layui-input-inline">
                <input type="text" id="score" name="score" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text" id="tip" name="tip" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </form>
</div>

<script>

</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['laydate','table','jquery','layer'], function(){
        var table = layui.table;
        var $ = layui.jquery;
        var layer = layui.layer;



        table.render({
            request: {
                pageName: 'page' // 页码的参数名称，默认：page
                , limitName: 'size' //每页数据量的参数名，默认：limit
            },
        })

        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                //完成ajax就可以


                layer.msg('ID：'+' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除《'+data.xm+'》行么', function(index){
                    // 要去数据库删除学生
                    // 此处要处理ajax技术
                    var json = {"xh":data.xh};
                    $.post("DeleteXSServlet",json,function (data,code) {
                        if(data=="1"){
                            layer.msg('删除成功', {icon: 1});
                        }else{
                            layer.msg('删除失败', {icon: 5});
                        }
                    })

                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){

                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
                layer.open({
                    type: 1
                    ,title: '修改学生信息' //不显示标题栏
                    ,closebtn: false
                    ,area: '500px;'
                    ,shade: 0.8
                    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,btn: ['确定', '取消']
                    ,moveType: 1 //拖拽模式，0或者1
                    ,content: $('.add_show_div').html()
                    ,yes: function(index, layero){


                        var json = {
                            'username': layero.find("#username").val(),
                            'userId': layero.find("#userId").val(),
                            'sex': layero.find(".sex").val(),
                            'birth': layero.find("#birth").val(),
                            'score': layero.find("#score").val(),
                            'tip': layero.find("#tip").val(),
                        };
                        $.post("StuManageUpdateServlet",json,function (data,code) {
                            if(data=="1"){
                                layer.msg('删除成功', {icon: 1});
                            }else{
                                layer.msg('删除失败', {icon: 5});
                            }
                        })

                        obj.del();
                        layer.close(index);
                    }
                });
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>
