package com.example.lab3;

public class SinhVien {
    String id,name,number;

    public SinhVien(String id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public SinhVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
