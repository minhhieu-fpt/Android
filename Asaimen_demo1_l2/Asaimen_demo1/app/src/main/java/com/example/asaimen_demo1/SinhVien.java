package com.example.asaimen_demo1;

public class SinhVien {
    public String idSV ;
    public String tenSV;
    public String noiSinh;
    public String ngaySinh;
    public String idLop;

    public SinhVien() {
    }

    public SinhVien(String idSV, String tenSV, String noiSinh, String ngaySinh, String idLop) {
        this.idSV = idSV;
        this.tenSV = tenSV;
        this.noiSinh = noiSinh;
        this.ngaySinh = ngaySinh;
        this.idLop = idLop;
    }

    public String getIdSV() {
        return idSV;
    }

    public void setIdSV(String idSV) {
        this.idSV = idSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }
}

