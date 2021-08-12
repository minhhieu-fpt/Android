package com.example.asm_tkgda_hieutmph10003.Model;

public class Mangement_loaiChi {
    public int _id;
    public String tenLoaiChi;

    public Mangement_loaiChi(String tenLoaiChi) {
        this.tenLoaiChi = tenLoaiChi;
    }

    public Mangement_loaiChi(int _id, String tenLoaiChi) {

        this._id = _id;
        this.tenLoaiChi = tenLoaiChi;
    }
}
