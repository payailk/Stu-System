package com.wyu.pojo;

public class Zyb {
    private int id;
    private String zym;
    private String fdy;
    private int rs;

    public Zyb(int id, String zym, String fdy, int rs) {
        this.id = id;
        this.zym = zym;
        this.fdy = fdy;
        this.rs = rs;
    }

    public Zyb(){

    }

    @Override
    public String toString() {
        return "Zyb{" +
                "id=" + id +
                ", zym='" + zym + '\'' +
                ", fdy='" + fdy + '\'' +
                ", rs=" + rs +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public String getFdy() {
        return fdy;
    }

    public void setFdy(String fdy) {
        this.fdy = fdy;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }
}
