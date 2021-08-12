package com.example.asaimen_demo1;

public class SinhVien {
    public String TenSV;
    public String NgaySinh;
    public String Idlop;

    public SinhVien() {

    }

    public SinhVien(String tenSV, String ngaySinh, String idlop) {
        TenSV = tenSV;
        NgaySinh = ngaySinh;
        Idlop = idlop;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String tenSV) {
        TenSV = tenSV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getIdlop() {
        return Idlop;
    }

    public void setIdlop(String idlop) {
        Idlop = idlop;
    }
}
