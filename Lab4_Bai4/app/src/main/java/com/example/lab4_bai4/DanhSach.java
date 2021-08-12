package com.example.lab4_bai4;

public class DanhSach {

    private String Name;
    private  String sddress;
    private  int img = R.mipmap.ic_launcher;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSddress() {
        return sddress;
    }

    public void setSddress(String sddress) {
        this.sddress = sddress;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
