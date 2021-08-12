package com.example.lab_6;

public class Product {

    private String ID;
    private String tenSP;
    private String price;

    public Product() {
    }

    public Product(String ID, String tenSP, String price) {
        this.ID = ID;
        this.tenSP = tenSP;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
