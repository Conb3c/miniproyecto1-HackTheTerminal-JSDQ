package Model;

import Controlador.GameEventsController;

/**
 * Interface that defines the contract for managing game state.
 * Provides methods to control game flow, track levels, and determine game outcomes.
 *
 * @author Juan Sebastian Duarte Quintero
 * @version 1.0
 */
public interface IGameState {
    /**
     * Starts a new game session.
     * Initializes the game state and sets the level to 1.
     */
    void startGame();

    /**
     * Handles the game loss condition.
     * Resets the game state when the player loses.
     *
     * @return true when the game loss is processed
     */
    boolean gameLose();

    /**
     * Resets the game to its initial state.
     * Clears all progress and returns the game to the starting conditions.
     *
     * @return true when the reset is successful
     */
    boolean resetGame();

    /**
     * Processes a round victory.
     * Advances the game level if the input is correct.
     *
     * @param input the game events controller handling the input
     * @param inputCorrect whether the user's input was correct
     * @return true if the round was won and level advanced, false otherwise
     */
    boolean roundWon(GameEventsController input, boolean inputCorrect);

    /**
     * Gets the current game level.
     *
     * @return the current level number
     */
    int getCurrentLevel();
}
