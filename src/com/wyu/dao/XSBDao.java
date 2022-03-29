package com.wyu.dao;

import com.wyu.pojo.Xsb;

import java.util.List;

public interface XSBDao {
    // 1.通过学号查询学生
    Xsb findByXH(String xh);
    // 2.学生注册
    Xsb registerXs(String xh, String xm, String mm, String xb, String cssj, String zy_id, String zxf, String zp);

    List<Xsb> selectByXSBLimt(int start, Integer limit2);

    int selectXSBCount();

    int deleteByxh(String xh);
}
