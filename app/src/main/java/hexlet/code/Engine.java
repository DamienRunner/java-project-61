package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Nod;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

import static hexlet.code.games.Game.END_CORRECT_ANSWERS_THRESHOLD;
import static hexlet.code.service.GameProcessService.getCounter;
import static hexlet.code.service.GameProcessService.incCounter;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Even EVEN_GAME = new Even();
    private static final Game CALC_GAME = new Calc();
    private static final Game NOD_GAME = new Nod();
    private static final Game PROGRESSION_GAME = new Progression();
    private static final Game IS_PRIME_GAME = new Prime();
    private static final int CALC_GAME_NUM = 3;
    private static final int NOD_GAME_NUM = 4;
    private static final int PROGRESSION_GAME_NUM = 5;
    private static final int IS_PRIME_GAME_NUM = 6;
    private static String playerName;

    public static void startGame(int gameId) {
        switch (gameId) {
            case 0:
                break;
            case 1:
                startGame();
                break;
            case 2:
                startGame();
                game(EVEN_GAME);
                break;
            case CALC_GAME_NUM:
                startGame();
                game(CALC_GAME);
                break;
            case NOD_GAME_NUM:
                startGame();
                game(NOD_GAME);
                break;
            case PROGRESSION_GAME_NUM:
                startGame();
                game(PROGRESSION_GAME);
                break;
            case IS_PRIME_GAME_NUM:
                startGame();
                game(IS_PRIME_GAME);
                break;
            default:
                System.out.println("Wrong number");
        }
    }

    public static void startPlayground() {
        while (true) {
            System.out.println("Please enter the game number and press Enter.");
            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("0 - Exit");
            int gameNumber;
            try {
                gameNumber = Integer.parseInt(SCANNER.nextLine());
                if (gameNumber == 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong game number");
                continue;
            }
            startGame(gameNumber);
            break;
        }
    }

    public static void startGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        playerName = SCANNER.nextLine();
        System.out.println("Hello, " + playerName);
    }

    public static void endGame() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private static void game(Game currentGame) {
        currentGame.printRules();
        while (getCounter() < END_CORRECT_ANSWERS_THRESHOLD) {
            currentGame.printQuestionAndCheck();
            System.out.print("Your answer: ");
            String userGuessString = SCANNER.nextLine().toLowerCase();
            boolean userGuess = currentGame.checkGuess(userGuessString);
            if (userGuess) {
                System.out.println("Correct!");
                incCounter();
            } else {
                currentGame.printErrorMessage(playerName, userGuessString);
                break;
            }
        }
        if (getCounter() == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame();
        }
    }
}
