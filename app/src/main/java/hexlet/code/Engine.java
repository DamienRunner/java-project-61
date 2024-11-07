package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;


public final class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int END_CORRECT_ANSWERS_THRESHOLD = 3;

    public static void startGame(Game currentGame) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String playerName = SCANNER.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(currentGame.getRules());
        for (int counter = 0; counter < END_CORRECT_ANSWERS_THRESHOLD; counter++) {
            String[] gameData = currentGame.getGameData();
            System.out.println("Question: " + gameData[0]);
            String userGuessString = SCANNER.nextLine().toLowerCase();
            String answer = gameData[1];
            System.out.println("Your answer: " + userGuessString);
            if (userGuessString.equals(answer)) {
                System.out.println("Correct!");
                if (counter == 2) {
                    System.out.println("Congratulations, " + playerName + "!");
                }
            } else {
                printErrorMessage(playerName, userGuessString, answer);
                break;
            }
        }
    }

    public static void printErrorMessage(String playerName, String userGuessString, String answer) {
        System.out.printf("'" + userGuessString + "'" + " is wrong answer ;(. Correct answer was '%s'.\n", answer);
        System.out.println("Let's try again, " + playerName + "!");
    }
}
