package com.endasssignment.javaendassignment;

import com.endasssignment.javaendassignment.Controller.MainController;
import com.endasssignment.javaendassignment.Model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(loader.load(), 300, 300);
        primaryStage.setTitle("Salman's Mixtape");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
