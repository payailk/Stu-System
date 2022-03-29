package com.wyu.pojo;

public class XSKCB {
    private int xh;
    private int kch;

    public XSKCB() {
    }

    public XSKCB(int xh, int kch) {
        this.xh = xh;
        this.kch = kch;
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public int getKch() {
        return kch;
    }

    public void setKch(int kch) {
        this.kch = kch;
    }

    @Override
    public String toString() {
        return "XSKCB{" +
                "xh=" + xh +
                ", kch=" + kch +
                '}';
    }
}
