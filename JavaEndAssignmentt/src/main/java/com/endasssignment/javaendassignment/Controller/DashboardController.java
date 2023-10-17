package com.endasssignment.javaendassignment.Controller;

import com.endasssignment.javaendassignment.Database.Database;
import com.endasssignment.javaendassignment.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DashboardController  implements Initializable {
    @FXML
    private Label welcomeUser;
    @FXML
    private Label userRole;
    @FXML
    private Label dateTime;
    private User user;
    private Database database;

    public DashboardController(Database database) {
        this.database = database;
        setUser(user);

    }


    public void setUser(User user) {
        this.user = user;
    }

    private void updateUI() {
        try {
            if(user == null) {
                return;
            }
            welcomeUser.setText("Welcome back " + user.getUsername());
            userRole.setText(user.getUserRole());

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
            String formattedDateTime = now.format(formatter);
            String result = formattedDateTime.replace("AM", "am").replace("PM", "pm");
            dateTime.setText(result);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateUI();
    }
}
