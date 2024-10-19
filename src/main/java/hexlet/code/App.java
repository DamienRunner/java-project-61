package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

public class App {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Even EVEN_GAME = new Even();
    private static boolean gameFlag = true;

    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = Cli.introduceYourself();
        System.out.println("Hello, " + name);
        selectGame();
    }

    private static void selectGame() {
        if (!gameFlag) {
            return;
        }
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        int gameNumber = 0;
        try {
            gameNumber = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Wrong game number");
            selectGame();
        }
        switch (gameNumber) {
            case 0:
                gameFlag = false;
                break;
            case 2:
                EVEN_GAME.startGame();
                break;
            default:
                System.out.println("Wrong number");
        }
        selectGame();
    }
}
