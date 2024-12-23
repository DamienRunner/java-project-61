package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Game;
import hexlet.code.games.Nod;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int CALC_GAME_NUM = 3;
    private static final int NOD_GAME_NUM = 4;
    private static final int PROGRESSION_GAME_NUM = 5;
    private static final int IS_PRIME_GAME_NUM = 6;

    public static void main(String[] args) {
        App.startPlayground();
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
                if (gameNumber == 1) {
                    Cli.introduceYourself();
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong game number");
                continue;
            }
            Engine.startGame(selectGame(gameNumber));
            break;
        }
    }

    public static Game selectGame(int gameId) {
        switch (gameId) {
            case 2:
                return new Even();
            case CALC_GAME_NUM:
                return new Calc();
            case NOD_GAME_NUM:
                return new Nod();
            case PROGRESSION_GAME_NUM:
                return new Progression();
            case IS_PRIME_GAME_NUM:
                return new Prime();
            default:
                System.out.println("Wrong number");
        }
        return null;
    }
}
