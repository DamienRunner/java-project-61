package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Greet;
import hexlet.code.games.Nod;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Game EVEN_GAME = new Even();
    private static final Game CALC_GAME = new Calc();
    private static final Game GREET_GAME = new Greet();
    private static final Game NOD_GAME = new Nod();
    private static final Game PROGRESSION_GAME = new Progression();
    private static final Game IS_PRIME_GAME = new Prime();
    private static final int CALC_GAME_NUM = 3;
    private static final int NOD_GAME_NUM = 4;
    private static final int PROGRESSION_GAME_NUM = 5;
    private static final int IS_PRIME_GAME_NUM = 6;

    public static void startGame(int gameId) {
        switch (gameId) {
            case 0:
                break;
            case 1:
                GREET_GAME.startGame();
                break;
            case 2:
                EVEN_GAME.startGame();
                break;
            case CALC_GAME_NUM:
                CALC_GAME.startGame();
                break;
            case NOD_GAME_NUM:
                NOD_GAME.startGame();
                break;
            case PROGRESSION_GAME_NUM:
                PROGRESSION_GAME.startGame();
                break;
            case IS_PRIME_GAME_NUM:
                IS_PRIME_GAME.startGame();
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
}
