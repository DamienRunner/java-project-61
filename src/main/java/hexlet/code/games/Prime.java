package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Prime implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private int counter;
    private String playerName;

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
        int number = random.nextInt(100) + 1;
        boolean correctAnswer = isPrime(number);
        System.out.printf("Question: Is %d a prime number? (yes/no)\n", number);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next().trim().toLowerCase();
        if ((correctAnswer && userAnswer.equals("yes")) || (!correctAnswer && userAnswer.equals("no"))) {
            System.out.println("Correct!");
            counter++;
        } else {
            System.out.printf("Wrong! The correct answer was %s.\n", correctAnswer ? "yes" : "no");
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
