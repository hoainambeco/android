package com.example.namhoainguyen;

public class DoiTuong {
    public String TieuDe;
    public String NoiDung;
    public String ThoiGian;
    public int id;

    public DoiTuong(String tieuDe, String noiDung, String thoiGian, int id) {
        TieuDe = tieuDe;
        NoiDung = noiDung;
        ThoiGian = thoiGian;
        this.id = id;
    }

    public DoiTuong() {
    }
}
