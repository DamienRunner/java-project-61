package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Game EVEN_GAME = new Even();
    private static final Game CALC_GAME = new Calc();
    private static final Game GREET_GAME = new Greet();
    private static final Game NOD_GAME = new Nod();

    public void startGame(int gameId) {
        switch (gameId) {
            case 0:
                break;
            case 1:
                GREET_GAME.startGame();
                break;
            case 2:
                EVEN_GAME.startGame();
                break;
            case 3:
                CALC_GAME.startGame();
                break;
            case 4:
                NOD_GAME.startGame();
                break;
            default:
                System.out.println("Wrong number");
        }
    }

    public void startPlayground() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        int gameNumber = 0;
        try {
            gameNumber = Integer.parseInt(SCANNER.nextLine());
            if (gameNumber == 0) {
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong game number");
            startPlayground();
        }
        startGame(gameNumber);
        startPlayground();
    }
}
