package com.example.hieutmph10003_asm_tkgda.model;

public class Loai_Thu {

    private int idLoaiThu;
    private String tenLoaiThu;

    public Loai_Thu() {
    }

    public Loai_Thu(int idLoaiThu, String tenLoaiThu) {
        this.idLoaiThu = idLoaiThu;
        this.tenLoaiThu = tenLoaiThu;
    }

    public int getIdLoaiThu() {
        return idLoaiThu;
    }

    public void setIdLoaiThu(int idLoaiThu) {
        this.idLoaiThu = idLoaiThu;
    }

    public String getTenLoaiThu() {
        return tenLoaiThu;
    }

    public void setTenLoaiThu(String tenLoaiThu) {
        this.tenLoaiThu = tenLoaiThu;
    }
}
