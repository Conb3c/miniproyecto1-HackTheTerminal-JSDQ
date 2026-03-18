package Model;

/**
 * Interface that defines the contract for the game's word bank.
 * Provides methods to obtain random words based on the game level.
 *
 * @author HackTheTerminal Team
 * @version 1.0
 */
public interface IWordBank {
    /**
     * Obtains a random word from the bank based on the current game level.
     *
     * @param level the game state
     * @param currentLevel the current game level
     * @return a random word corresponding to the level
     */
    String getRandomWord(GameState level, int currentLevel);
}
