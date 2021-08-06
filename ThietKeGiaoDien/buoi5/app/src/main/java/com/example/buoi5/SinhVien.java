package com.example.buoi5;

public class SinhVien {
    String name;

    public SinhVien() {
    }

    public SinhVien(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
