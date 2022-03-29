package com.wyu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
// 封装的一个获得连接的工具类, 此处是配置的数据源
public class CtUtil {
    public static Connection getConnection() throws Exception {
        JdbcUtils.createDriver("com.mysql.jdbc.Driver");

        //创建一个Properties类，用来读取配置文件
        Properties per = new Properties();//是map集合下的一个子集合，是唯一可持久化集合
        //得到配置文件的输入流
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        InputStream is = CtUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        //将流装载到配置文件类中
        per.load(is);
        //获取DataSource数据资源对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(per);
        //获得数据库连接
        Connection connection = dataSource.getConnection();

        // jdbc的步骤包括：
        // 1.加载驱动
        // 2.获得连接

        // 注意:数据库连接池仅仅是处理的数据库jdbc中连接之前的操作,对数据库增删改查是无关的
        // 如果对数据库增删改查可以用jdbc,第三方工具类,框架:mybatis
        // 这三种方式和配置数据源无关, 也就是说这三种方式去操作数据库都可以配置数据库连接池

        // 3.获得发送sql语句对象
        // 4.发送sql语句
        // 5.获得结果
        // 6.关闭资源
        return connection;
    }
}
