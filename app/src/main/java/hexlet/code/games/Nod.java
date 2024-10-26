package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import static hexlet.code.service.GameProcessService.*;

public class Nod implements Game {

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
        while (counter < END_CORRECT_ANSWERS_THRESHOLD) {
            int number1 = random.nextInt(100) + 1;
            int number2 = random.nextInt(100) + 1;
            int correctAnswer = getNod(number1, number2);
            System.out.printf("Question: %d %d\n", number1, number2);
            if (checkAnswer(correctAnswer)) {
                break;
            }
        }
        if (counter == END_CORRECT_ANSWERS_THRESHOLD) {
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
