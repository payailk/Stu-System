package com.wyu.pojo;

public class KCB {
    private int  kch;
    private String  kcm;
    private String  kxxq;
    private int  xs;
    private int  xf;

    public KCB(int kch, String kcm, String kxxq, int xs, int xf) {
        this.kch = kch;
        this.kcm = kcm;
        this.kxxq = kxxq;
        this.xs = xs;
        this.xf = xf;
    }

    public KCB() {
    }

    public int getKch() {
        return kch;
    }

    public void setKch(int kch) {
        this.kch = kch;
    }

    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm;
    }

    public String getKxxq() {
        return kxxq;
    }

    public void setKxxq(String kxxq) {
        this.kxxq = kxxq;
    }

    public int getXs() {
        return xs;
    }

    public void setXs(int xs) {
        this.xs = xs;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    @Override
    public String toString() {
        return "KCB{" +
                "kch=" + kch +
                ", kcm='" + kcm + '\'' +
                ", kxxq='" + kxxq + '\'' +
                ", xs=" + xs +
                ", xf=" + xf +
                '}';
    }
}
