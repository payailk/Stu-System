package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.Zyb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class ZYBDaoImpl implements ZYBDao {
    @Override
    public List<Zyb> selectZYBAll() {
        // 查询数据库
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * from zyb";
            BeanListHandler<Zyb> handler = new BeanListHandler(Zyb.class);
            List<Zyb> list = qr.query(ct, sql, handler);
            list.forEach(li -> System.out.println(li));
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return null;
    }
}
