package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.service.GameProcessService.*;

public class Calc implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private String playerName;

    private static int calculate(int num1, int num2, char operation) {
        return switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            default -> throw new IllegalArgumentException("Wrong operation: " + operation);
        };
    }

    private static char getRandomOperation(Random random) {
        char[] operations = {'+', '-', '*'};
        return operations[random.nextInt(operations.length)];
    }

    @Override
    public void startGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println("What is the result of the expression?");
        setPlayerName(playerName);
        game();
    }

    @Override
    public void endGame() {
        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private void game() {
        while (counter < END_CORRECT_ANSWERS_THRESHOLD) {
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            char operation = getRandomOperation(random);
            int correctAnswer = calculate(num1, num2, operation);
            System.out.printf("Question: %d %c %d\n", num1, operation, num2);
            if (checkAnswer(correctAnswer)) {
                break;
            }
        }
        if (counter == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame();
        }
    }
}
