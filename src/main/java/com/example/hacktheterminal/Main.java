package com.example.hacktheterminal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class that starts the Hack the Terminal application.
 * Extends JavaFX Application to create the graphical interface.
 *
 * @author HackTheTerminal Team
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Main method that launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start method that configures and initializes the main application window.
     * Loads the main menu scene and sets the window properties.
     *
     * @param primaryStage the primary stage of the application
     * @throws Exception if there is an error loading the FXML file
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));

        Scene scene = new Scene(root, 700 , 500);
        primaryStage.setTitle("Hack the Terminal");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
