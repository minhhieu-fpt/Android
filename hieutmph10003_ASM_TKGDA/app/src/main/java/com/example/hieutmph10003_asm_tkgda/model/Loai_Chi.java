package com.example.hieutmph10003_asm_tkgda.model;

public class Loai_Chi {

    private int idLoaiChi;
    private String tenLoaiChi;

    public Loai_Chi() {
    }

    public Loai_Chi(int idLoaiChi, String tenLoaiChi) {
        this.idLoaiChi = idLoaiChi;
        this.tenLoaiChi = tenLoaiChi;
    }

    public int getIdLoaiChi() {
        return idLoaiChi;
    }

    public void setIdLoaiChi(int idLoaiChi) {
        this.idLoaiChi = idLoaiChi;
    }

    public String getTenLoaiChi() {
        return tenLoaiChi;
    }

    public void setTenLoaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }
}
