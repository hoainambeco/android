package com.example.myapplicationoto.dto;

public class OTo {
    String id_oto, ma_oto, gia_oto;

    public OTo(String id_oto, String ma_oto, String gia_oto) {
        this.id_oto = id_oto;
        this.ma_oto = ma_oto;
        this.gia_oto = gia_oto;
    }

    public OTo(String ma_oto, String gia_oto) {
        this.ma_oto = ma_oto;
        this.gia_oto = gia_oto;
    }

    public String getId_oto() {
        return id_oto;
    }

    public void setId_oto(String id_oto) {
        this.id_oto = id_oto;
    }

    public String getMa_oto() {
        return ma_oto;
    }

    public void setMa_oto(String ma_oto) {
        this.ma_oto = ma_oto;
    }

    public String getGia_oto() {
        return gia_oto;
    }

    public void setGia_oto(String gia_oto) {
        this.gia_oto = gia_oto;
    }
}
