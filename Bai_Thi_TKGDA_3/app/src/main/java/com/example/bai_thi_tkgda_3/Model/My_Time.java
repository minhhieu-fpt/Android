package com.example.bai_thi_tkgda_3.Model;

public class My_Time {
    private String noidung;
    private String time;

    public My_Time() {
    }

    public My_Time(String noidung, String time) {
        this.noidung = noidung;
        this.time = time;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
