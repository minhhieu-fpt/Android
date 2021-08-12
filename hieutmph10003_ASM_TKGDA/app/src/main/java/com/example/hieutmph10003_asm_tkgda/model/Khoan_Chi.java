package com.example.hieutmph10003_asm_tkgda.model;

public class Khoan_Chi {

    private int idKhoanChi;
    private String tenKhoanChi;
    private int soTienChi;
    private String noiDung;
    private String ngayChi;
    private int idLoaiChi;

    public Khoan_Chi() {
    }

    public Khoan_Chi(int idKhoanChi, String tenKhoanChi, int soTienChi, String noiDung, String ngayChi, int idLoaiChi) {
        this.idKhoanChi = idKhoanChi;
        this.tenKhoanChi = tenKhoanChi;
        this.soTienChi = soTienChi;
        this.noiDung = noiDung;
        this.ngayChi = ngayChi;
        this.idLoaiChi = idLoaiChi;
    }

    public int getIdKhoanChi() {
        return idKhoanChi;
    }

    public void setIdKhoanChi(int idKhoanChi) {
        this.idKhoanChi = idKhoanChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
    }

    public int getIdLoaiChi() {
        return idLoaiChi;
    }

    public void setIdLoaiChi(int idLoaiChi) {
        this.idLoaiChi = idLoaiChi;
    }

    public int getSoTienChi() {
        return soTienChi;
    }

    public void setSoTienChi(int soTienChi) {
        this.soTienChi = soTienChi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
