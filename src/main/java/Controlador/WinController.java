package Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller class for the win screen scene.
 * Handles user interactions when the player successfully completes the game.
 * Provides options to start a new game or return to the main menu.
 *
 * @author HackTheTerminal Team
 * @version 1.0
 */
public class WinController {
    /** Button to start a new game */
    @FXML
    Button newGameButton;

    /** Button to return to the main menu */
    @FXML
    Button menuButton;

    /**
     * Switches from the win screen to the game scene to start a new game.
     * Loads the game FXML file and transitions to the game view.
     *
     * @param event the action event triggered by clicking the new game button
     * @throws Exception if there is an error loading the game FXML file
     */
    @FXML
    private void switchGameScene(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/hacktheterminal/Game.fxml"));
        Stage window = (Stage) newGameButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    /**
     * Switches from the win screen to the main menu scene.
     * Loads the menu FXML file and transitions to the menu view.
     *
     * @param event the action event triggered by clicking the menu button
     * @throws Exception if there is an error loading the menu FXML file
     */
    @FXML
    private void switchMenuScene(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/hacktheterminal/Menu.fxml"));
        Stage window = (Stage) menuButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }
}
