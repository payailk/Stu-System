package com.wyu.service;

import com.wyu.dao.XSBDao;
import com.wyu.dao.XSBDaoImpl;
import com.wyu.pojo.Xsb;

import java.util.List;

public class XSBServiceImpl implements XSBService {
    @Override
    public Xsb login(String xh, String mm) {
        // 调用dao的方法操作数据库
        XSBDao dao = new XSBDaoImpl();
        // 通过学号查询用户名
        Xsb xs = dao.findByXH(xh);
        if(xs!=null){
            // 比较密码
            if(mm.equals(xs.getMm())){
                return xs;
            }
        }
        return null;
    }

    @Override
    public Xsb register(String xh, String xm, String mm, String xb, String cssj, String zy_id, String zxf, String zp) {
        // 调用dao的方法操作数据库
        XSBDao dao = new XSBDaoImpl();
        // 通过学号查询用户名
        Xsb xs = dao.findByXH(xh);
        if(xs!=null){
            return xs;
        }
        xs = dao.registerXs(xh, xm, mm, xb, cssj, zy_id, zxf, zp);
        return xs;
    }

    @Override
    public List<Xsb> selectXSALL(String page, String limit) {
        Integer page1 = Integer.parseInt(page);
        Integer limit2 = Integer.parseInt(limit);
        // page=1, limit=10:问应该查询哪些数据:从0开始查询后面的10条
        // page=2, limit=10,应是查询第11条后面的10条数据
        XSBDao xs = new XSBDaoImpl();
        // 如果page是1, start应该是: 0
        // 如果page是2, start应该是: 10
        int start = (page1-1) * limit2;

        List<Xsb> list = xs.selectByXSBLimt(start,limit2);

        return list;
    }

    @Override
    public int selectXSBCount() {
        XSBDao kd = new XSBDaoImpl();
        return kd.selectXSBCount();
    }

    @Override
    public int deleteByXh(String xh) {
        XSBDao del = new XSBDaoImpl();
        return del.deleteByxh(xh);
    }
}
