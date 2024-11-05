package hexlet.code.games;

import static hexlet.code.service.GameProcessService.getRandomInt;
import static java.lang.String.format;
import static java.lang.String.valueOf;

public final class Nod implements Game {

    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final int MAX_RANDOM = 100;
    private static int number1;
    private static int number2;

    private int getNod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String getRules() {
        return RULES;
    }

    @Override
    public String getQuestionString() {
        number1 = getRandomInt(0, MAX_RANDOM);
        number2 = getRandomInt(0, MAX_RANDOM);
        return format("%d %d", number1, number2);
    }

    @Override
    public String getAnswerString() {
        int answer = getNod(number1, number2);
        return valueOf(answer);
    }
}
