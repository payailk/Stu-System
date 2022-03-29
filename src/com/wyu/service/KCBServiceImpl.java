package com.wyu.service;

import com.wyu.dao.KCBDao;
import com.wyu.dao.KCBDaoImpl;
import com.wyu.pojo.KCB;

import java.util.List;

public class KCBServiceImpl implements KCBService {
    KCBDao dao = new KCBDaoImpl();

    @Override
    public List<KCB> selectKCALL(String page, String limit) {
        Integer page1 = Integer.parseInt(page);
        Integer limit2 = Integer.parseInt(limit);
        // page=1, limit=10:问应该查询哪些数据:从0开始查询后面的10条
        // page=2, limit=10,应是查询第11条后面的10条数据
        //KCBDao kd = new KCBDaoImpl();
        // 如果page是1, start应该是: 0
        // 如果page是2, start应该是: 10
        int start = (page1-1) * limit2;

        List<KCB> list = dao.selectByKCBLimt(start,limit2);

        return list;
    }

    @Override
    public int selectKCBCount() {
/*        KCBDao kd = new KCBDaoImpl();*/
        return dao.selectKCBCount();
    }

    public List<KCB> PerSelLes(int xh, int page, int limit) {
        int start = (page-1)*limit;
        return dao.PerSelLes(xh,start,limit);
    }

    @Override
    public int selectCountByXh(int xh) {
        return dao.selectCountByXh(xh);
    }
}
