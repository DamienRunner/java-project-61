package hexlet.code.games;

public interface Game {
    int END_CORRECT_ANSWERS_THRESHOLD = 3;

    /**
     * Checking users guess.
     *
     * @param guess is the users guess.
     * @return returns boolean guessing result.
     */
    boolean checkGuess(String guess);

    /**
     * Prints game rules.
     *
     */
    void printRules();

    /**
     * Prints games question.
     *
     */
    void printQuestionAndCheck();

    /**
     * Prints error message.
     *
     * @param playerName players name.
     * @param userGuessString users guess.
     */
    void printErrorMessage(String playerName, String userGuessString);
}
