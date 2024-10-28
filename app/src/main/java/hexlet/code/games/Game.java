package hexlet.code.games;

public interface Game {
    int END_CORRECT_ANSWERS_THRESHOLD = 3;
    /**
     * Starts the game by welcoming the player and asking for their name.
     *
     */
    void startGame();
    /**
     * Ends the game.
     *
     */
    void endGame();
}
