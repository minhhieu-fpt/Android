package com.example.mysqlite;

public class SinhVien {

    private String ID;
    private String Ten;
    private String noisinh;
    private String ngaysinh;
    private String IDlop;


    public SinhVien() {

    }

    public SinhVien(String ID, String ten, String noisinh, String ngaysinh, String IDlop) {
        this.ID = ID;
        Ten = ten;
        this.noisinh = noisinh;
        this.ngaysinh = ngaysinh;
        this.IDlop = IDlop;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getIDlop() {
        return IDlop;
    }

    public void setIDlop(String IDlop) {
        this.IDlop = IDlop;
    }
}
