package com.example.hieutmph10003_asm_tkgda.model;

public class Khoan_Thu {
    private int id;
    private String tenKhoanThu;
    private int soTienThu;
    private String loaiThu;
    private String ngayThu;
    private int idLoaiThu;

    public Khoan_Thu() {
    }

    public Khoan_Thu(int id, String tenKhoanThu, int soTienThu, String loaiThu, String ngayThu, int idLoaiThu) {
        this.id = id;
        this.tenKhoanThu = tenKhoanThu;
        this.soTienThu = soTienThu;
        this.loaiThu = loaiThu;
        this.ngayThu = ngayThu;
        this.idLoaiThu = idLoaiThu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public String getLoaiThu() {
        return loaiThu;
    }

    public void setLoaiThu(String loaiThu) {
        this.loaiThu = loaiThu;
    }

    public String getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(String ngayThu) {
        this.ngayThu = ngayThu;
    }

    public int getIdLoaiThu() {
        return idLoaiThu;
    }

    public void setIdLoaiThu(int idLoaiThu) {
        this.idLoaiThu = idLoaiThu;
    }

    public int getSoTienThu() {
        return soTienThu;
    }

    public void setSoTienThu(int soTienThu) {
        this.soTienThu = soTienThu;
    }
}
