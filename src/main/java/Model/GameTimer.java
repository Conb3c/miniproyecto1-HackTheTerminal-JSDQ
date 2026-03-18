package Model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Implementation of IGameTime that manages the countdown timer for each game level.
 * Uses JavaFX Timeline for creating a countdown that decreases every second.
 * Time limits decrease as levels increase to raise difficulty.
 *
 * @author HackTheTerminal Team
 * @version 1.0
 */
public class GameTimer implements IGameTime{
    /** Initial time limit in seconds for level 1 */
    private static final int INITIAL_TIME = 20;
    /** Minimum time limit in seconds (enforced at higher levels) */
    private static final int MIN_TIME = 2;
    /** Current time remaining for the active level in seconds */
    private int timeLeftperlevel;

    /** JavaFX Timeline object controlling the countdown */
    Timeline timer;
    /** Callback executed when time runs out */
    private Runnable onTimeoutCallback;
    /** Callback executed on each timer tick (every second) */
    private Runnable onTimerTickCallback;

    /**
     * Constructs a GameTimer with the initial time limit.
     * Initializes the timer to the starting time value.
     */
    public GameTimer(){
        this.timeLeftperlevel = INITIAL_TIME;
    }

    /**
     * Starts the countdown timer.
     * Creates a Timeline that decrements the time every second.
     * Calls the tick callback on each second and the timeout callback when time reaches zero.
     */
    @Override
    public void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeLeftperlevel--;
            if (onTimerTickCallback != null) {
                onTimerTickCallback.run();
            }
            if (timeLeftperlevel <= 0) {
                stopTimer();
                if (onTimeoutCallback != null) {
                    onTimeoutCallback.run();
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    /**
     * Gets the remaining time for the current level.
     *
     * @return the time left in seconds
     */
    @Override
    public int getTime() {
        return this.timeLeftperlevel;
    }



    /**
     * Calculates the time limit for a specific level.
     * Time decreases by 2 seconds for every 5 levels completed.
     * Minimum time is enforced to prevent timer from becoming too short.
     *
     * @param level the game level
     * @return the calculated time limit in seconds for the given level
     */
    public int calculateTimeForLevel(int level) {
        int timeReduction = ((level - 1) / 5) * 2;
        int time = INITIAL_TIME - timeReduction;
        return Math.max(time, MIN_TIME);
    }

    /**
     * Restarts the timer to its initial value.
     * Stops any running timer and resets to the default starting time (20 seconds).
     */
    @Override
    public void restartTimer() {
        stopTimer();
        this.timeLeftperlevel = INITIAL_TIME;
    }


    /**
     * Restarts the timer with the calculated time for a specific level.
     * Stops any running timer and sets the time based on level difficulty.
     *
     * @param level the level for which to calculate and set the time limit
     */
    public void restartTimerForLevel(int level) {
        stopTimer();
        this.timeLeftperlevel = calculateTimeForLevel(level);
    }

    /**
     * Stops the currently running timer.
     * Halts the countdown without resetting the time value.
     */
    @Override
    public void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    /**
     * Sets the callback to be executed when the timer runs out.
     *
     * @param callback the Runnable to execute on timeout
     */
    public void setOnTimeoutCallback(Runnable callback) {
        this.onTimeoutCallback = callback;
    }


    /**
     * Sets the callback to be executed on each timer tick (every second).
     *
     * @param callback the Runnable to execute on each tick
     */
    public void setOnTimerTickCallback(Runnable callback) {
        this.onTimerTickCallback = callback;
    }
}
