package Controlador;

import Model.GameState;
import Model.GameTimer;
import Model.ValidateWord;
import Model.WordBank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Controller class for the main game scene.
 * Manages game events, user input validation, word display, timer updates, and level progression.
 * Handles the core gameplay loop including visual feedback for typed letters.
 *
 * @author Juan Sebastian Duarte Quintero
 * @version 1.0
 */
public class GameEventsController {
    /** HBox container for displaying the word's letters */
    @FXML
    HBox hBoxWord;
    /** Label displaying the current level */
    @FXML
    Label labelLevel;
    /** Label displaying the remaining time */
    @FXML
    Label labelTime;
    /** Verify button and play button */
    @FXML
    Button buttonVerify, jugarButton;
    /** Text field for user input */
    @FXML
    TextField inputWord;

    /** Stores the user's input word */
    String userInputWord;
    /** Stores the current target word to type */
    String currentWord;
    /** Word bank instance for retrieving random words */
    WordBank wordBank = new WordBank();
    /** Word validator instance for checking input correctness */
    ValidateWord validateWord = new ValidateWord();
    /** Game state instance tracking current level and game status */
    GameState gameState = new GameState(45);
    /** Game timer instance managing countdown timer */
    GameTimer gameTimer = new GameTimer();


    /**
     * Initializes the game controller when the scene is loaded.
     * Sets up the word display, timer callbacks, input listeners, and keyboard handlers.
     * Automatically called by JavaFX after FXML elements are injected.
     */
    @FXML
    public void initialize() {
        loadNewWord();
        updateLabels();

        gameTimer.setOnTimerTickCallback(() -> updateLabels());
        gameTimer.restartTimerForLevel(gameState.getCurrentLevel());
        gameTimer.startTimer();
        inputWord.textProperty().addListener((observable, oldValue, newValue) -> {
            compareLetters();
        });
        inputWord.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                verify(null);
            }
        });
    }

    /**
     * Loads a new word from the word bank based on the current level.
     * Displays the word, clears the input field, and updates UI labels.
     */
    public void loadNewWord() {
        currentWord = wordBank.getRandomWord(GameState.PLAYING, gameState.getCurrentLevel());
        showWords(currentWord);
        inputWord.clear();
        updateLabels();
    }

    /**
     * Verifies if the user's input matches the current word.
     * If correct, advances to the next level or shows the win screen if level 45 is completed.
     * Restarts the timer for the new level and loads a new word.
     *
     * @param event the action event triggered by the verify button or Enter key (can be null)
     * @return true if the word was correct, false otherwise
     */
    public boolean verify(ActionEvent event){
        try {
            userInputWord = inputWord.getText();
            ValidateWord word = new ValidateWord();
            boolean inputCorrect = false;
            boolean validateWord = word.validateWord(currentWord, userInputWord);
            if (validateWord) {
                System.out.println("Word is correct");
                gameState.incrementLevel();
                if (gameState.getCurrentLevel() > 45) {
                    gameTimer.stopTimer();
                    showWinScreen();
                    return true;
                }
                gameTimer.restartTimerForLevel(gameState.getCurrentLevel());
                loadNewWord();
                return inputCorrect = true;
            }
            else {
                System.out.println("Word is incorrect");
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Error");
        }
        return false;
    }

    /**
     * Displays the target word by breaking it into individual letter labels.
     * Each letter is shown in a styled label within the HBox container.
     *
     * @param word the word to display
     */
    public void showWords(String word) {

        hBoxWord.getChildren().clear();
        hBoxWord.setAlignment(Pos.CENTER);

        char[] letras = validateWord.decompouseWord(null, word);

        for (char letra : letras) {
            Label labelLetra = new Label(String.valueOf(letra));
            labelLetra.setStyle("-fx-font-size: 24px; -fx-padding: 8;-fx-background-color: #F0F7EE; -fx-border-radius: 4;");
            hBoxWord.getChildren().add(labelLetra);
        }
    }


    /**
     * Compares the user's typed input with the target word letter by letter.
     * Provides visual feedback by coloring each letter:
     * - Green: correct letter in correct position
     * - Orange: incorrect letter
     * - Light gray: not yet typed
     */
    public void compareLetters() {
        String userText = inputWord.getText();
        char[] letrasCorrectas = validateWord.decompouseWord(null, currentWord);
        for (int i = 0; i < letrasCorrectas.length; i++) {
            Label labelLetra = (Label) hBoxWord.getChildren().get(i);
            if (i < userText.length()) {
                if (userText.charAt(i) == letrasCorrectas[i]) {
                    labelLetra.setStyle("-fx-font-size: 24px; -fx-padding: 8; -fx-background-color: #00F500; -fx-border-radius: 4;");
                } else {
                    labelLetra.setStyle("-fx-font-size: 24px; -fx-padding: 8; -fx-background-color: #FF7F11; -fx-border-radius: 4;");
                }
            } else {
                labelLetra.setStyle("-fx-font-size: 24px; -fx-padding: 8; -fx-background-color: #F0F7EE; -fx-border-radius: 4;");
            }
        }
    }

    /**
     * Updates the level and time labels with current game state information.
     * Called periodically by the timer and when game state changes.
     */
    public void updateLabels() {
        labelLevel.setText("Nivel: " + gameState.getCurrentLevel());
        labelTime.setText("Tiempo: " + gameTimer.getTime() + "s");
    }


    /**
     * Displays the win screen when the player completes all 45 levels.
     * Loads the WinScreen FXML and transitions to the victory scene.
     */
    private void showWinScreen() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/hacktheterminal/WinScreen.fxml"));
            Stage window = (Stage) inputWord.getScene().getWindow();
            window.setScene(new Scene(root, 700, 500));
        } catch (Exception e) {
            System.out.println("Error al cargar la pantalla de victoria: " + e.getMessage());
        }
    }

}
