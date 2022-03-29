package com.wyu.dao;

import com.wyu.pojo.KCB;

import java.util.List;

public interface KCBDao {
    // 分页查询
    List<KCB> selectByKCBLimt(int start, Integer limit2);

    // 总记录数
    int selectKCBCount();

    List<KCB> PerSelLes(int xh, int start, int limit);

    int selectCountByXh(int xh);
}
