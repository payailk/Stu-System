package com.wyu.service;

import com.wyu.pojo.Xsb;

import java.util.List;

public interface XSBService {
    // 登录的抽象方法
    Xsb login(String xh, String mm);
    // 注册的抽象方法
    Xsb register(String xh, String xm, String mm, String xb, String cssj, String zy_id, String zxf, String zp);
    // 分页查询学生表
    List<Xsb> selectXSALL(String page, String limit);
    // 查询总记录数
    int selectXSBCount();
    // 通过学号删除学生
    int deleteByXh(String xh);

}
