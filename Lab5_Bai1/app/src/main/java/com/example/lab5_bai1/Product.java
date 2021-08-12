package com.example.lab5_bai1;

public class Product {
    private String ID;
    private String Name;
    private String price;
    private int img = R.drawable.ic_launcher_foreground;

    public Product() {
    }

    public Product(String ID, String name, String price) {
        this.ID = ID;
        Name = name;
        this.price = price;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
