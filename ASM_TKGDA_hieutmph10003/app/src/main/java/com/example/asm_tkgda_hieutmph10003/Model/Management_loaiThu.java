package com.example.asm_tkgda_hieutmph10003.Model;

public class Management_loaiThu {
    public int _id;
    public String tenLoaiThu;

    public Management_loaiThu(String tenLoaiThu) {
        this.tenLoaiThu = tenLoaiThu;
    }

    public Management_loaiThu(int _id, String tenLoaiThu) {

        this._id = _id;
        this.tenLoaiThu = tenLoaiThu;
    }
}
