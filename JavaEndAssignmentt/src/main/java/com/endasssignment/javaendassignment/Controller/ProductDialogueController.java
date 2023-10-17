package com.endasssignment.javaendassignment.Controller;

import com.endasssignment.javaendassignment.Database.Database;
import com.endasssignment.javaendassignment.MainApp;
import com.endasssignment.javaendassignment.Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProductDialogueController implements Initializable {

    @FXML
    private Button addToOrderClick;
    @FXML
    private Button cancelClick;
    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, Integer> stockColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> categoryColumn;
    @FXML
    private TableColumn<Product, Double> priceColumn;
    @FXML
    private TableColumn<Product, String> descriptionColumn;

    private Database database;
    private ObservableList<Product> products;

    public ProductDialogueController(Database database) {
        this.database = database;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        products = FXCollections.observableArrayList();
        products.addAll(database.getAllProducts());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productTableView.setItems(products);
    }

    @FXML
    public void addToOrderClick() {
        System.out.println("Add to order clicked");
    }



    @FXML
    public void onCancelButton(javafx.event.ActionEvent event) {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) cancelClick.getScene().getWindow();
        stage.close();
    }

    public Product getProduct() {
        return productTableView.getSelectionModel().getSelectedItem();
    }
}


