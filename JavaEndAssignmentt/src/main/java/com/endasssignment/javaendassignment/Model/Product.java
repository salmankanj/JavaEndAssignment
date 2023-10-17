package com.endasssignment.javaendassignment.Model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int stock;
    private String name;
    private String category;
    private double price;
    private String description;

    public Product(int stock, String name, String category, double price, String description) {
        this.stock = stock;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
