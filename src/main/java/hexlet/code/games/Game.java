package hexlet.code.games;

public interface Game {
    int END_CORRECT_ANSWERS_THRESHOLD = 3;

    void startGame();

    void endGame();
}
