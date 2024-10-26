package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.service.GameProcessService.setPlayerName;

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
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        setPlayerName(playerName);
        game();
    }

    @Override
    public void endGame() {
        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private void game() {
        while (counter < END_CORRECT_ANSWERS_THRESHOLD) {
            int number = random.nextInt(100) + 1;
            boolean correctAnswer = isPrime(number);
            System.out.printf("Question: %d", number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next().trim().toLowerCase();
            if ((correctAnswer && userAnswer.equals("yes")) || (!correctAnswer && userAnswer.equals("no"))) {
                System.out.println("Correct!");
                counter++;
            } else {
                System.out.printf("Wrong! The correct answer was %s.\n", correctAnswer ? "yes" : "no");
            }
        }
        if (counter == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame();
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
