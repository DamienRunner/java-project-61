package hexlet.code.games;

public interface Game {
    int END_CORRECT_ANSWERS_THRESHOLD = 3;
    /**
     * Checking user's answer;
     *
     */
    boolean checkGuess(String guess);
    /**
     * Prints rules of the game.
     *
     */
    void printRules();
    void printQuestionAndCheck();
    void printErrorMessage(String playerName, String userGuessString);
}
