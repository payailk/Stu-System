package com.wyu.pojo;

public class Xsb {
    private int xh;
    private String xm;
    private String mm;
    private String xb;
    private String cssj;
    private String  zym;
    private int zxf;
    private String bz;
    private String zp;

    public Xsb() {
    }

    public Xsb(int xh, String xm, String mm, String xb, String cssj, String zym, int zxf, String bz, String zp) {
        this.xh = xh;
        this.xm = xm;
        this.mm = mm;
        this.xb = xb;
        this.cssj = cssj;
        this.zym = zym;
        this.zxf = zxf;
        this.bz = bz;
        this.zp = zp;
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb.equals("1")?"男":"女";
    }

    public String getCssj() {
        return cssj;
    }

    public void setCssj(String cssj) {
        this.cssj = cssj;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public int getZxf() {
        return zxf;
    }

    public void setZxf(int zxf) {
        this.zxf = zxf;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    @Override
    public String toString() {
        return "Xsb{" +
                "xh=" + xh +
                ", xm='" + xm + '\'' +
                ", mm='" + mm + '\'' +
                ", xb='" + xb + '\'' +
                ", cssj='" + cssj + '\'' +
                ", zym='" + zym + '\'' +
                ", zxf=" + zxf +
                ", bz='" + bz + '\'' +
                ", zp='" + zp + '\'' +
                '}';
    }
}
