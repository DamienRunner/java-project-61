package hexlet.code.games;

public interface Game {

    /**
     * Prints game rules.
     *
     * @return rules string.
     */
    String getRules();

    /**
     * Get game question.
     *
     * @return question string.
     */
    String[] getGameData();
}
