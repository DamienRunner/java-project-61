package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.Greet;

import java.util.Scanner;


public final class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int END_CORRECT_ANSWERS_THRESHOLD = 3;
    private static int counter;

    public static void introducePlayerAndStartGame(Game game) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String playerName = SCANNER.nextLine();
        System.out.println("Hello, " + playerName + "!");
        if (game instanceof Greet) {
            return;
        }
        startGame(game, playerName);
    }

    public static void endGame(String playerName) {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private static void startGame(Game currentGame, String playerName) {
        System.out.println(currentGame.getRules());
        while (counter < END_CORRECT_ANSWERS_THRESHOLD) {
            System.out.println("Question: " + currentGame.getQuestionString());
            System.out.print("Your answer: ");
            String userGuessString = SCANNER.nextLine().toLowerCase();
            String answer = currentGame.getAnswerString();
            if (checkGuess(userGuessString, answer)) {
                System.out.println("Correct!");
                counter++;
            } else {
                printErrorMessage(playerName, userGuessString, answer);
                break;
            }
        }
        if (counter == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame(playerName);
        }
    }

    public static void printErrorMessage(String playerName, String userGuessString, String answer) {
        System.out.printf("'" + userGuessString + "'" + " is wrong answer ;(. Correct answer was '%s'.\n", answer);
        System.out.println("Let's try again, " + playerName + "!");
    }

    public static boolean checkGuess(String guess, String answer) {
        System.out.println("Your answer: " + guess);
        return guess.equals(answer);
    }
}
