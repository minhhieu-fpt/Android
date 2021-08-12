package com.example.thi_cuoi_ki;

public class Thoi_Gian {
    private String noidung;
    private String thoigian;

    public Thoi_Gian() {
    }

    public Thoi_Gian(String noidung, String thoigian) {
        this.noidung = noidung;
        this.thoigian = thoigian;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
}
