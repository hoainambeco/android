package com.example.thoigianbieu;

import java.util.Date;

public class Ghichu {
    private String noidung;
    private String thoigian;
    private String title;

    public Ghichu() {
    }
    public Ghichu(String noidung, String thoigian, String title) {
        this.noidung = noidung;
        this.thoigian = thoigian;
        this.title = title;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getThoigian() {
        return thoigian;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
}
