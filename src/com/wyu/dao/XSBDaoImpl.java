package com.wyu.dao;

import com.alibaba.druid.util.JdbcUtils;
import com.wyu.pojo.Xsb;
import com.wyu.util.CtUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class XSBDaoImpl implements XSBDao {
    @Override
    public Xsb findByXH(String xh) {
        // 查询学生
        Connection ct = null;
        // 获得连接
        try {
            QueryRunner qr = new QueryRunner();

            ct = CtUtil.getConnection();
            String sql = "select x.xh,x.xm,x.mm,x.xb,x.cssj,x.zxf,z.zym,x.bz,x.zp from xsb x ,zyb z where x.zy_id = z.id and x.xh=? ";
            BeanHandler<Xsb> handler = new BeanHandler(Xsb.class);
            Xsb xs = qr.query(ct, sql, handler, xh);
            System.out.println(xs);
            return xs;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(ct);
        }
        return null;
    }

    @Override
    public Xsb registerXs(String xh, String xm, String mm, String xb, String cssj, String zy_id) {
        Connection ct = null;
        // 获得连接
        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "INSERT INTO xsb(xh, xm, mm, xb, cssj, zy_id) VALUES (?,?,?,?,?,?);";
            //添加数据
            int i = qr.update(ct, sql, xh, xm, mm, xb, cssj, zy_id);
            if (i > 0) {
                System.out.println("成功添加" + i + "条数据");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(ct);
        }
        return null;
    }

    @Override
    public List<Xsb> selectByXSBLimt(int start, Integer limit2) {
        // 查询数据库
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select * from xsb limit ?,?";
            BeanListHandler<Xsb> handler = new BeanListHandler(Xsb.class);
            List<Xsb> list = qr.query(ct, sql, handler, start, limit2);
            list.forEach(li -> System.out.println(li));
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(ct);
        }
        return null;
    }

    @Override
    public int selectXSBCount() {
        // 查询数据库
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "select count(*) count from xsb";
            return ((Long) qr.query(ct, sql, new ScalarHandler())).intValue();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }

    @Override
    public int deleteByxh(String xh) {
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "delete from xsb where xh = ?;";
            //添加数据
            qr.update(ct, "SET foreign_key_checks = 0");
            int i = qr.update(ct, sql, xh);
            qr.update(ct, "SET foreign_key_checks = 1");
            return i;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }

    @Override
    public int updateZp(String imgUrl, int xh) {
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "update xsb set zp=? where xh = ?;";
            //添加数据
            int i = qr.update(ct, sql, imgUrl, xh);
            if (i > 0) {
                System.out.println("成功修改" + i + "条数据");
                return i;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(ct);
        }
        return 0;
    }

    @Override
    public int updateUser(String username, String birth, String score, String tip, String userId) {
        Connection ct = null;
        // 获得连接

        try {
            QueryRunner qr = new QueryRunner();
            ct = CtUtil.getConnection();
            String sql = "update xsb set xm=?, cssj=?, zxf=?, bz=? where xh = ?;";
            //添加数据
            int i = qr.update(ct, sql, username, birth, score, tip, userId);
            if (i > 0) {
                System.out.println("成功修改" + i + "条数据");
                return i;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            JdbcUtils.close(ct);
        }
        return 1;
    }
}
