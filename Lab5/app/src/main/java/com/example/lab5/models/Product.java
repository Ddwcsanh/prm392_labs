package com.example.lab5.models;

public class Product {
    String name;
    int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    int productID;

    public Product(int productID, String name, int price) {
        this.name = name;
        this.price = price;
        this.productID = productID;
    }
}
