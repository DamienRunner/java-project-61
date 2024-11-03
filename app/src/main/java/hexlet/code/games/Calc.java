package hexlet.code.games;

import java.util.Random;

import static hexlet.code.service.Constants.MAX_RANDOM;
import static hexlet.code.service.GameProcessService.getRandomInt;
import static hexlet.code.service.GameProcessService.getRandomOperation;

public final class Calc implements Game {

    private static int answer;
    private final Random random = new Random();

    private static int calculate(int num1, int num2, char operation) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Wrong operation: " + operation);
        };
    }

    public boolean checkGuess(String guess) {
        try {
            int parseAnswer = Integer.parseInt(guess);
            return parseAnswer == answer;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void printRules() {
        System.out.println("What is the result of the expression?");
    }

    public void printQuestionAndCheck() {
        int num1 = getRandomInt(0, MAX_RANDOM);
        int num2 = getRandomInt(0, MAX_RANDOM);
        char operation = getRandomOperation(random);
        answer = calculate(num1, num2, operation);
        System.out.printf("Question: %d %c %d\n", num1, operation, num2);
    }

    @Override
    public void printErrorMessage(String playerName, String userGuessString) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.\n", userGuessString, answer);
        System.out.println("Let's try again, " + playerName + "!");
    }
}
