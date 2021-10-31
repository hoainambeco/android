package com.example.loaiThuChi;

public class Ghichu {
    private int id;
    private String noidung;
    private String loaiThuChi;
    private String title;

    public Ghichu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ghichu(int id, String noidung, String loaiThuChi, String title) {
        this.id = id;
        this.noidung = noidung;
        this.loaiThuChi = loaiThuChi;
        this.title = title;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getLoaiThuChi() {
        return loaiThuChi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String setLoaiThuChi(String loaiThuChi) {
        this.loaiThuChi = loaiThuChi;
        return loaiThuChi;
    }
}
