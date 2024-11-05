package hexlet.code.games;

import java.util.Random;

import static hexlet.code.service.GameProcessService.getRandomInt;
import static hexlet.code.service.GameProcessService.getRandomOperation;
import static java.lang.String.format;
import static java.lang.String.valueOf;

public final class Calc implements Game {

    private static final String RULES = "What is the result of the expression?";
    private static final int MAX_RANDOM = 100;
    private static int num1;
    private static int num2;
    private static char operation;
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

    public String getQuestionString() {
        num1 = getRandomInt(0, MAX_RANDOM);
        num2 = getRandomInt(0, MAX_RANDOM);
        operation = getRandomOperation(random);
        return format("%d %c %d", num1, operation, num2);
    }

    @Override
    public String getAnswerString() {
        return valueOf(calculate(num1, num2, operation));
    }
}
