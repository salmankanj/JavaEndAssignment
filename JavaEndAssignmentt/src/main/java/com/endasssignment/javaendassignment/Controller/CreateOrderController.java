package com.endasssignment.javaendassignment.Controller;
import com.endasssignment.javaendassignment.Database.Database;
import com.endasssignment.javaendassignment.MainApp;
import com.endasssignment.javaendassignment.Model.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateOrderController implements Initializable {

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField email;

    @FXML
    private TextField phonenumber;

    private Database database;

    private ObservableList<Product> products;

    public CreateOrderController(Database database) {
        this.database = database;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    public void onAddProductClick(ActionEvent event) {
       try{
              FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("ProductDialogue.fxml"));
              fxmlLoader.setController(new ProductDialogueController(database));
              Scene scene = new Scene(fxmlLoader.load());
              Stage stage = new Stage();
              stage.setScene(scene);
              stage.show();
       } catch (IOException e) {
           throw new RuntimeException(e);

       }
    }


    @FXML
    public void onDeleteProductClick(ActionEvent event) {

    }

    @FXML
    public void onCreateOrder(ActionEvent event) {

    }








}
