package com.wyu.test;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.Zyb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class CRUDTest {


    // 1.添加数据
    @Test
    public void insert(){
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "INSERT INTO zyb(zym, rs, fdy) VALUES (?,?,?);";
            //添加数据
            int i = qr.update(ct, sql, "计算机网络通信", 80, "李莫愁");
            if(i>0){
                System.out.println("成功添加"+i+"条数据");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
    }

    // 2.修改数据
    @Test
    public void updateTest(){
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "update zyb set rs=? where id = ?;";
            //添加数据
            int i = qr.update(ct, sql, 100, 5);
            if(i>0){
                System.out.println("成功修改"+i+"条数据");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
    }

    // 3.删除数据
    @Test
    public void deleteTest(){
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "delete from zyb where id = ?;";
            //添加数据
            int i = qr.update(ct, sql, 6);
            if(i>0){
                System.out.println("成功删除"+i+"条数据");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
    }

    // 4.查询数据-普通查询一条数据
    @Test
    public void selectTest1(){
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * from zyb where id = ?";
            MapHandler handler = new MapHandler();

            //添加数据
            Map<String, Object> map = qr.query(ct, sql, handler, 1);
//            map.forEach((k,v) -> System.out.print(k+":"+v+"     "));
            map.forEach((k,v) -> {
               if(k.equals("zym")){
                   System.out.println("专业名:"+v);
               }
            });

        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
    }

    // 4.查询数据-普通查询多条数据
    @Test
    public void selectTest2(){
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * from zyb";
            MapListHandler handler = new MapListHandler();

            //添加数据
            List<Map<String, Object>> list = qr.query(ct, sql, handler);
            list.forEach(li -> System.out.println(li));


        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
    }

    // 4.查询数据-普通查询单条数据用对象接收
    @Test
    public void selectTest3(){
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * from zyb where id = ?";
            BeanHandler<Zyb> handler = new BeanHandler(Zyb.class);
            Zyb zyb = qr.query(ct, sql, handler,1);
            System.out.println(zyb);
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
    }

    // 4.查询数据-普通查询多条数据用对象集合接收
    @Test
    public void selectTest4(){
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * from zyb";
            BeanListHandler<Zyb> handler = new BeanListHandler(Zyb.class);
            List<Zyb> list = qr.query(ct, sql, handler);
            list.forEach(li -> System.out.println(li));

        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
    }
}
