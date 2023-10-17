package com.endasssignment.javaendassignment.Database;

import com.endasssignment.javaendassignment.Model.Order;
import com.endasssignment.javaendassignment.Model.Product;
import com.endasssignment.javaendassignment.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database implements Serializable {
    public Map<String, User> users = new HashMap<>();
    private final List<Order> orders = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();

    public Database() {
        User user1 = new User("SalmanKanj", "password1", LocalDate.of(1996, 9, 2), User.Role.Sales);
        User user2=new User("BasselKanj","password2",LocalDate.of(1996,9,2),User.Role.Manager);
        users.put(user1.getUsername(), user1);
        users.put(user2.getUsername(),user2);
        Product product1 = new Product(10,"Electric guitar","Acoustic Guitar", 499.99, "A guitar that is electric");
        products.add(product1);

    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

}


