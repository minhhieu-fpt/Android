package com.example.mysqlite;

public class Lop {
    
    private String idlop;
    private String tenlop;
    private String nghanh;

    public Lop() {
    }

    public Lop(String idlop, String tenlop, String nghanh) {
        this.idlop = idlop;
        this.tenlop = tenlop;
        this.nghanh = nghanh;
    }

    public String getIdlop() {
        return idlop;
    }

    public void setIdlop(String idlop) {
        this.idlop = idlop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getNghanh() {
        return nghanh;
    }

    public void setNghanh(String nghanh) {
        this.nghanh = nghanh;
    }
}
