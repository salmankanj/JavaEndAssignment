package com.endasssignment.javaendassignment.Controller;

import com.endasssignment.javaendassignment.Database.Database;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductInventoryController implements Initializable {
    private Database database;
    public ProductInventoryController(Database database) {
        this.database = database;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
