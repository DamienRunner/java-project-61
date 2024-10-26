package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.service.GameProcessService.*;

public class Progression implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private String playerName;

    @Override
    public void startGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println("What number is missing in the progression?");
        setPlayerName(playerName);
        game();
    }

    @Override
    public void endGame() {
        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private void game() {
        while (counter < END_CORRECT_ANSWERS_THRESHOLD) {
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
            if (checkAnswer(correctAnswer)) {
                break;
            }
        }
        if (counter == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame();
        }
    }
}
