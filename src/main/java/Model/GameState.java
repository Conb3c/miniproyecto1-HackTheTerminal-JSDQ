package Model;

import Controlador.GameEventsController;

/**
 * Implementation of IGameState that manages the current state of the game.
 * Tracks the game level, start/end conditions, and handles game progression.
 *
 * @author HackTheTerminal Team
 * @version 1.0
 */
public class GameState implements IGameState{
    /** The current level of the game */
    private int currentLevel;
    /** Flag indicating whether the game has been started */
    private boolean gameStarted;
    /** Flag indicating whether the game is over */
    private boolean gameOver;

    /** Constant representing the playing state with maximum level */
    public static final GameState PLAYING = new GameState(Integer.MAX_VALUE);

    /**
     * Constructs a new GameState with the specified final level.
     * Initializes the game at level 1 with the game not started and not over.
     *
     * @param finalLevel the final level of the game (currently not used in logic)
     */
    public GameState(int finalLevel){
        this.currentLevel = 1;
        this.gameStarted = false;
        this.gameOver = false;

    }

    /**
     * Starts a new game session.
     * Sets the game as started, not over, and resets to level 1.
     */
    @Override
    public void startGame() {
        this.gameStarted = true;
        this.gameOver = false;

        this.currentLevel = 1;
    }

    /**
     * Handles the game loss condition.
     * Marks the game as over and resets to level 1.
     *
     * @return true when the game loss is processed
     */
    @Override
    public boolean gameLose() {
        this.gameOver = true;
        this.currentLevel = 1;
        return true;
    }

    /**
     * Resets the game to its initial state.
     * Resets level to 1, marks game as not started and not over.
     *
     * @return true when the reset is successful
     */
    @Override
    public boolean resetGame() {
        this.currentLevel = 1;
        this.gameStarted = false;
        this.gameOver = false;

        return true;
    }

    /**
     * Processes a round victory.
     * If the input is correct, advances to the next level.
     *
     * @param input the game events controller handling the input
     * @param inputCorrect whether the user's input was correct
     * @return true if the round was won and level advanced, false otherwise
     */
    @Override
    public boolean roundWon(GameEventsController input, boolean inputCorrect) {
        if (inputCorrect) {
            this.currentLevel++;
            return true;
        }
        return false;
    }

    /**
     * Gets the current game level.
     *
     * @return the current level number
     */
    @Override
    public int getCurrentLevel() {
        return this.currentLevel;
    }

    /**
     * Increments the current level by 1.
     * Used to advance to the next level during gameplay.
     */
    public void incrementLevel() {
        this.currentLevel++;
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return this.gameOver;
    }

    /**
     * Checks if the game has been started.
     *
     * @return true if the game has been started, false otherwise
     */
    public boolean isGameStarted() {
        return this.gameStarted;
    }
}
