package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.KCB;
import com.wyu.pojo.Zyb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class KCBDaoImpl implements KCBDao {
    @Override
    public List<KCB> selectByKCBLimt(int start, Integer limit2) {
        // 查询数据库
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * from kcb limit ?,?";
            BeanListHandler<KCB> handler = new BeanListHandler(KCB.class);
            List<KCB> list = qr.query(ct, sql, handler, start, limit2);
            list.forEach(li -> System.out.println(li));
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return null;
    }

    @Override
    public int selectKCBCount() {
        // 查询数据库
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select count(*) count from kcb";
            return ((Long)qr.query(ct, sql, new ScalarHandler())).intValue();
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }

    @Override
    public List<KCB> PerSelLes(int xh, int start, int limit) {
        // 查询数据库
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select k.* from kcb k,xskcb x where k.kch = x.kch and x.xh = ? limit ?,?";
            BeanListHandler<KCB> handler = new BeanListHandler(KCB.class);
            List<KCB> list = qr.query(ct, sql, handler, xh, start, limit);
            list.forEach(li -> System.out.println(li));
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return null;
    }

    @Override
    public int selectCountByXh(int xh) {
        // 查询数据库
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select count(*) count from kcb k, xskcb x where k.kch = x.kch and x.xh = ?";
            return ((Long)qr.query(ct, sql, new ScalarHandler(),xh)).intValue();
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }
}
