package com.example.studenrmanager.models;

public class Student {
    private String Name;
    private String NgaySinh;
    private String idClass;

    public Student() {
    }

    public Student(String name, String ngaySinh, String idClass) {
        Name = name;
        NgaySinh = ngaySinh;
        this.idClass = idClass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    @Override
    public String toString() {
        return Name + " | "+ NgaySinh + " | " + idClass ;
    }
}
