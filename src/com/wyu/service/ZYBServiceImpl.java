package com.wyu.service;

import com.wyu.dao.ZYBDao;
import com.wyu.dao.ZYBDaoImpl;
import com.wyu.pojo.Zyb;

import java.util.List;

public class ZYBServiceImpl implements ZYBservice {
    @Override
    public List<Zyb> selectZYAll() {
        // 去dao层查询数据
        ZYBDao dao = new ZYBDaoImpl();
        // 查询数据
        List<Zyb> list = dao.selectZYBAll();
        return list;
    }
}
