package com.example.authorizationjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Authorization extends Application {

    Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        Label labelTop = new Label("Authorization");
        root.add(labelTop, 0,0);

        GridPane enterText = new GridPane();
        enterText.setHgap(5);
        enterText.setVgap(5);

        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        enterText.add(nameLabel, 0, 0);
        enterText.add(nameField, 1, 0);

        Label pasLabel = new Label("Password");
        PasswordField pasField = new PasswordField();
        enterText.add(pasLabel, 0, 1);
        enterText.add(pasField, 1, 1);

        Label acceptPasLabel = new Label("Repeat password");
        PasswordField acceptPasField = new PasswordField();
        enterText.add(acceptPasLabel, 0, 2);
        enterText.add(acceptPasField, 1, 2);
        root.add(enterText, 0, 1);

        FlowPane flowPane2 = new FlowPane();
        flowPane2.setAlignment(Pos.CENTER);
        Label bottom = new Label("");
        flowPane2.getChildren().add(bottom);
        root.add(flowPane2, 0,3);

        FlowPane flowPane1 = new FlowPane();
        flowPane1.setAlignment(Pos.CENTER_RIGHT);
        Button signIn = new Button("Sing in");
        signIn.setOnAction(e -> {
            // if UserController.logIn != "" else ...
            bottom.setText("");
            String name = nameField.getText();
            String pass = pasField.getText();
            String acceptPswField = acceptPasField.getText();
            try {
                UserController.checkData(name, pass, acceptPswField);
                bottom.setText("All fields is valid");
            } catch (UserException ex) {
                bottom.setText(ex.getMessage());
            }
        });
        flowPane1.getChildren().add(signIn);
        root.add(flowPane1, 0, 2);




        scene = new Scene(root, 300, 250);
        stage.setTitle("Authorization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}