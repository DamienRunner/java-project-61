package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.service.GameProcessService.checkAnswer;
import static hexlet.code.service.GameProcessService.getCounter;
import static hexlet.code.service.GameProcessService.setPlayerName;

public final class Nod implements Game {

    private static final int MAX_RANDOM = 100;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private String playerName;

    @Override
    public void startGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println("Find the greatest common divisor of given numbers.");
        setPlayerName(playerName);
        game();
    }

    @Override
    public void endGame() {
        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private void game() {
        while (getCounter() < END_CORRECT_ANSWERS_THRESHOLD) {
            int number1 = random.nextInt(MAX_RANDOM) + 1;
            int number2 = random.nextInt(MAX_RANDOM) + 1;
            int correctAnswer = getNod(number1, number2);
            System.out.printf("Question: %d %d\n", number1, number2);
            if (checkAnswer(correctAnswer)) {
                break;
            }
        }
        if (getCounter() == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame();
        }
    }

    private int getNod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
