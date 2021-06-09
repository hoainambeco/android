package com.example.lap5;

public class Product {
    private String Id;
    private String Name;
    private double Price;
    private int Image;

    public Product() {
    }

    public Product(String id, String name, double price, int image) {
        Id = id;
        Name = name;
        Price = price;
        Image = image;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
