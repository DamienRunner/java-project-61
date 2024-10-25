package hexlet.code.games;

import java.util.Scanner;

public class Greet implements Game {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void startGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        endGame();
    }

    @Override
    public void endGame() {

    }
}
