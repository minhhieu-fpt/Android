package com.example.asm.Model;

public class Student {

    private String tenSinhVien;
    private String ngaySinh;
    private String id_lop;

    public Student() {
    }

    public Student(String tenSinhVien, String ngaySinh, String id_lop) {
        this.tenSinhVien = tenSinhVien;
        this.ngaySinh = ngaySinh;
        this.id_lop = id_lop;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getId_lop() {
        return id_lop;
    }

    public void setId_lop(String id_lop) {
        this.id_lop = id_lop;
    }
}
