package com.endasssignment.javaendassignment.Controller;
import com.endasssignment.javaendassignment.Database.Database;
import com.endasssignment.javaendassignment.MainApp;
import com.endasssignment.javaendassignment.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable {


    Database database;
    @FXML
    HBox layout;

    private  Stage stage;



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private User currentUser ;

    public void setUser(User user) {
        this.currentUser = user;
        DashboardController dashboardController = new DashboardController(database);
        dashboardController.setUser(user);
        loadScene("Dashboard.fxml", dashboardController);
    }


    public void loadScene(String name, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(name));
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load());
            if (layout.getChildren().size() > 1)
                layout.getChildren().remove(1);
            layout.getChildren().add(scene.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database=new Database();
        loadScene("Dashboard.fxml",new DashboardController(database));
    }

    public void onDashboardClick(ActionEvent actionEvent) {
        setUser(currentUser);

    }

    public void OnCreateOrderClick(ActionEvent actionEvent) {
         loadScene("CreateOrder.fxml",new CreateOrderController(database));

    }

    public void onProductInventoryClick(ActionEvent actionEvent) {
        if(currentUser.getUserRole().equals("Manager")) {
            loadScene("ProductInventory.fxml", new ProductInventoryController(database));
        }
        else {
            return;
        }

    }


    public void onOrderHistoryClick(ActionEvent actionEvent) {
    }
}