package hexlet.code.games;

import java.util.Random;

import static hexlet.code.service.GameProcessService.getRandomInt;
import static hexlet.code.service.GameProcessService.getRandomOperation;
import static java.lang.String.format;
import static java.lang.String.valueOf;

public final class Calc implements Game {

    private static final String RULES = "What is the result of the expression?";
    private static final int MAX_RANDOM = 100;
    private final Random random = new Random();

    private static int calculate(int number1, int number2, char mathOperation) {
        return switch (mathOperation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> throw new IllegalArgumentException("Wrong operation: " + mathOperation);
        };
    }

    public String getRules() {
        return RULES;
    }

    public String[] getGameData() {
        int num1 = getRandomInt(0, MAX_RANDOM);
        int num2 = getRandomInt(0, MAX_RANDOM);
        char operation = getRandomOperation(random);
        return new String[]{format("%d %c %d", num1, operation, num2), valueOf(calculate(num1, num2, operation))};
    }
}
