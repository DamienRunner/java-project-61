package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Progression implements Game {

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
        while (counter < END_CORRECT_ANSWERS_THRESHOLD) {
            game();
        }
        endGame();
    }

    @Override
    public void endGame() {
        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private void game() {
        int length = random.nextInt(6) + 5;
        int start = random.nextInt(10);
        int step = random.nextInt(5) + 1;
        int hiddenIndex = random.nextInt(length);
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        System.out.print("Question: ");
        for (int i = 0; i < length; i++) {
            if (i == hiddenIndex) {
                System.out.print(".. ");
            } else {
                System.out.print(progression[i] + " ");
            }
        }
        int correctAnswer = progression[hiddenIndex];
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();
        try {
            int parseAnswer = Integer.parseInt(userAnswer);
            if (parseAnswer == correctAnswer) {
                System.out.println("Correct!");
                counter++;
            } else {
                processWrongAnswer(userAnswer, correctAnswer);
            }
        } catch (NumberFormatException e) {
            processWrongAnswer(userAnswer, correctAnswer);
        }
    }

    private void processWrongAnswer(String userAnswer, int correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.\n", userAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", playerName);
    }
}
