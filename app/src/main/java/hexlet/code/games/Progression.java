package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.service.GameProcessService.checkAnswer;
import static hexlet.code.service.GameProcessService.getCounter;
import static hexlet.code.service.GameProcessService.setPlayerName;

public class Progression implements Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private String playerName;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_ADDITIONAL_LENGTH = 6;

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
        while (getCounter() < END_CORRECT_ANSWERS_THRESHOLD) {
            int length = random.nextInt(MAX_ADDITIONAL_LENGTH) + MIN_LENGTH;
            int start = random.nextInt(MAX_LENGTH);
            int step = random.nextInt(MIN_LENGTH) + 1;
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
        if (getCounter() == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame();
        }
    }
}
