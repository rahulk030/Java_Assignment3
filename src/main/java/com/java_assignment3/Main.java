package com.java_assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file and create a scene
        Parent root = FXMLLoader.load(getClass().getResource("convert_view.fxml"));

        // Set the title of the stage
        primaryStage.setTitle("Conversion App");

        // Set the scene with the loaded FXML file and specify dimensions
        primaryStage.setScene(new Scene(root, 400, 300));

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}

