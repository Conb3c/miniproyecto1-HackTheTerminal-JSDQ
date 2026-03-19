package Model;

/**
 * Interface that defines the contract for managing game time and timer operations.
 * Provides methods to control the countdown timer and calculate time limits per level.
 *
 * @author Juan Sebastian Duarte Quintero
 * @version 1.0
 */
public interface IGameTime {
    /**
     * Gets the remaining time for the current level.
     *
     * @return the time left in seconds
     */
    int getTime();

    /**
     * Calculates the time limit for a specific level.
     * Higher levels have reduced time limits to increase difficulty.
     *
     * @param level the game level
     * @return the calculated time limit in seconds for the given level
     */
    int calculateTimeForLevel(int level);

    /**
     * Restarts the timer to its initial value.
     * Stops any running timer and resets to the default starting time.
     */
    void restartTimer();

    /**
     * Stops the currently running timer.
     * Halts the countdown without resetting the time value.
     */
    void stopTimer();

    /**
     * Starts the countdown timer.
     * Begins counting down from the current time value.
     */
    void startTimer();
}
