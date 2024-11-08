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
            String userGuess = SCANNER.nextLine().toLowerCase();
            String answer = gameData[1];
            System.out.println("Your answer: " + userGuess);
            if (userGuess.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'" + userGuess + "'" + " is wrong answer ;(. Correct answer was '%s'.\n", answer);
                System.out.println("Let's try again, " + playerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
