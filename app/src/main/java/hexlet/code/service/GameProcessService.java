package hexlet.code.service;

import java.util.Scanner;

public class GameProcessService {

    private static final Scanner scanner = new Scanner(System.in);
    private static String playerName;
    public static int counter;

    public static void setPlayerName(String playerName) {
        GameProcessService.playerName = playerName;
    }

    public static boolean checkAnswer(int correctAnswer) {
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();
        try {
            int parseAnswer = Integer.parseInt(userAnswer);
            if (parseAnswer == correctAnswer) {
                System.out.println("Correct!");
                counter++;
            } else {
                processWrongAnswer(userAnswer, correctAnswer);
                return true;
            }
        } catch (NumberFormatException e) {
            processWrongAnswer(userAnswer, correctAnswer);
            return true;
        }
        return false;
    }

    private static void processWrongAnswer(String userAnswer, int correctAnswer) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.\n", userAnswer, correctAnswer);
        System.out.printf("Let's try again, %s!\n", playerName);
    }
}
