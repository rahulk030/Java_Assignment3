package com.java_assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("convert_view.fxml"));
        primaryStage.setTitle("Conversion App"); // Custom title
        primaryStage.setScene(new Scene(root, 400, 300)); // Set width and height
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
