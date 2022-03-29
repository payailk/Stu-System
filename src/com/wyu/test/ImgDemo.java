package com.wyu.test;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

public class ImgDemo {
    public static void main(String[] args) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:/tupian.png");
        //获得随机后的验证码
        System.out.println("产生的验证码是："+lineCaptcha.getCode());
    }

}
