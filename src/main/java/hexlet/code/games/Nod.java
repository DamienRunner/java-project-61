package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Nod implements Game {

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
        int number1 = random.nextInt(100) + 1;
        int number2 = random.nextInt(100) + 1;
        int correctAnswer = getNod(number1, number2);
        System.out.printf("Question: %d %d\n", number1, number2);
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

    private int getNod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void processWrongAnswer(String userAnswer, int correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.\n", userAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", playerName);
    }
}
