package hexlet.code.games;

import static hexlet.code.service.GameProcessService.getRandomInt;
import static java.lang.String.valueOf;

public final class Progression implements Game {

    public static final int MAX_ADDITIONAL_LENGTH = 6;
    private static final String RULES = "What number is missing in the progression?";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static int answer;

    @Override
    public String getRules() {
        return RULES;
    }

    @Override
    public String getQuestionString() {
        int length = getRandomInt(0, MAX_ADDITIONAL_LENGTH) + MIN_LENGTH;
        int start = getRandomInt(0, MAX_LENGTH);
        int step = getRandomInt(1, MIN_LENGTH);
        int hiddenIndex = getRandomInt(0, length);
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == hiddenIndex) {
                question.append(".. ");
            } else {
                question.append(progression[i]).append(" ");
            }
        }
        answer = progression[hiddenIndex];
        return question.toString();
    }

    @Override
    public String getAnswerString() {
        return valueOf(answer);
    }
}
