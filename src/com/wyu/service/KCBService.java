package com.wyu.service;

import com.wyu.pojo.KCB;

import java.util.List;

public interface KCBService {
    // 分页查询课程表
    List<KCB> selectKCALL(String page, String limit);

    // 查询总记录数
    int selectKCBCount();

    // 查询个人课程信息
    List<KCB> PerSelLes(int xh, int page, int limit);

    // 查询个人课程的条数
    int selectCountByXh(int xh);
}
