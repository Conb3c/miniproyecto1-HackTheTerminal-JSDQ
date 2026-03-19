package Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller class for the main menu scene.
 * Handles user interactions in the menu and manages scene transitions to the game.
 *
 * @author Juan Sebastian Duarte Quintero
 * @version 1.0
 */
public class MenuController {
    /** Button to start playing the game */
    @FXML
    Button playButton;

    /** Alternative button to start playing (jugar means "play" in Spanish) */
    @FXML
    private Button jugarButton;

    /**
     * Switches from the menu scene to the game scene.
     * Loads the game FXML file and transitions to the game view.
     *
     * @param event the action event triggered by clicking the play button
     * @throws Exception if there is an error loading the game FXML file
     */
    @FXML
    private void switchGameScene(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/hacktheterminal/Game.fxml"));

        Stage window = (Stage) playButton.getScene().getWindow();
        window.setScene(new Scene(root, 700 , 500));
    }
}
