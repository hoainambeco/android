package com.example.lab8;

public class Muc {
    private int hinh;
    private String Chuoi;

    public Muc() {
    }

    public Muc(int hinh, String chuoi) {
        this.hinh = hinh;
        Chuoi = chuoi;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getChuoi() {
        return Chuoi;
    }

    public void setChuoi(String chuoi) {
        Chuoi = chuoi;
    }
}
