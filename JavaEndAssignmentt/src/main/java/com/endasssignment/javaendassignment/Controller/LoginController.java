package com.endasssignment.javaendassignment.Controller;
import com.endasssignment.javaendassignment.Database.Database;
import com.endasssignment.javaendassignment.MainApp;
import com.endasssignment.javaendassignment.Model.Exceptions;
import com.endasssignment.javaendassignment.Model.User;
import com.endasssignment.javaendassignment.Service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML
    public Button loginBtn;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label outputMessage;

    private final Database database;
    private final UserService userService;

    public LoginController() {
        database = new Database();
        userService = new UserService(database);

    }

    @FXML
    private void authentication(String username, String password, ActionEvent event) {
        try {
            if (userService.authenticate(username, password)) {
                User user = userService.getUserByUsername(username);
                loadMainScene(user);
            } else {
                outputMessage.setText("Login failed. Please try again.");
            }
        } catch (Exceptions.UserNotFoundException e) {
            outputMessage.setText("Invalid username");
        } catch (Exceptions.InvalidPasswordException e) {
            outputMessage.setText("Invalid password");
        }
    }

    public void loginClick(ActionEvent actionEvent) {
        authentication(username.getText(), password.getText(), actionEvent);
    }

    private void loadMainScene(User authenticatedUser) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Main.fxml"));
            HBox mainRoot = fxmlLoader.load();

            MainController mainController = fxmlLoader.getController();
            mainController.setUser(authenticatedUser);

            Stage currentStage = (Stage) loginBtn.getScene().getWindow();
            currentStage.setWidth(900);
            currentStage.setHeight(550);
            mainController.setStage(currentStage);

            if (currentStage.getScene() == null) {
                Scene scene = new Scene(mainRoot);

                currentStage.setScene(scene);
            } else {
                currentStage.getScene().setRoot(mainRoot);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
