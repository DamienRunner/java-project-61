package hexlet.code.games;

public interface Game {

    /**
     * Prints game rules.
     *
     */
    String getRules();

    /**
     * Get game question.
     *
     */
    String getQuestionString();

    /**
     * Get game answer.
     *
     */
    String getAnswerString();
}
