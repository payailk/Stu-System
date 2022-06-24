package com.wyu.dao;

import com.wyu.pojo.Xsb;

import java.util.List;

public interface XSBDao {
    // 1.通过学号查询学生
    Xsb findByXH(String xh);
    // 2.学生注册
    Xsb registerXs(String xh, String xm, String mm, String xb, String cssj, String zy_id);

    List<Xsb> selectByXSBLimt(int start, Integer limit2);

    int selectXSBCount();

    int deleteByxh(String xh);

    int updateZp(String imgUrl, int xh);

    int updateUser(String username, String birth, String score, String tip, String userId);
}
