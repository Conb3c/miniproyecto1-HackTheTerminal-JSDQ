package Model;

/**
 * Implementation of IValidateWord that provides word validation and decomposition functionality.
 * This class validates user input against target words and converts words into character arrays.
 *
 * @author HackTheTerminal Team
 * @version 1.0
 */
public class ValidateWord implements IValidateWord{
    /** Flag indicating whether the word is valid (currently unused) */
    private boolean validWord;
    /** Stores the user input (currently unused) */
    String userInput;

    /**
     * Validates if the user's input matches the current word exactly.
     * Performs a case-sensitive comparison.
     *
     * @param currentWord the target word that should be matched
     * @param userInput the input provided by the user
     * @return true if the user input matches the current word exactly, false otherwise
     */
    @Override
    public boolean validateWord(String currentWord, String userInput) {
        return currentWord.equals(userInput);
    }

    /**
     * Decomposes a word into an array of characters.
     * Converts the string into its individual character components.
     *
     * @param wordToValidate the WordBank instance (currently not used in implementation)
     * @param word the word to be decomposed
     * @return an array of characters representing each letter of the word
     */
    @Override
    public char[] decompouseWord(WordBank wordToValidate, String word) {return word.toCharArray();}
}
