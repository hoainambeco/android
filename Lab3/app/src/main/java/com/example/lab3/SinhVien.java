package com.example.lab3;

public class SinhVien {
    String id;
    String name;
    String number;

    public SinhVien(String id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public SinhVien() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiem(String diem) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiem() {
        return number;
    }
}
