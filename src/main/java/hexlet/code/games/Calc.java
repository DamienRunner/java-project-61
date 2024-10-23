package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private int counter;
    private String playerName;

    private static int calculate(int num1, int num2, char operation) {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Неизвестная операция: " + operation);
        }
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
        while (counter < 3) {
            game();
        }
        endGame();
    }

    @Override
    public void endGame() {
        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private void game() {
        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);
        char operation = getRandomOperation(random);
        int correctAnswer = calculate(num1, num2, operation);
        System.out.println("What is the result of the expression?");
        System.out.printf("Question: %d %c %d\n", num1, operation, num2);
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();
        try {
            int parseAnswer = Integer.parseInt(userAnswer);
            if (parseAnswer == correctAnswer) {
                System.out.println("Correct!");
                counter++;
            }
        } catch (NumberFormatException e) {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.\n", userAnswer, correctAnswer);
            System.out.printf("Let's try again, %s!\n", playerName);
        }
    }
}
