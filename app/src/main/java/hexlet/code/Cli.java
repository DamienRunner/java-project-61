package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void introduceYourself() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String playerName = SCANNER.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }

    public static String scanLine() {
        return SCANNER.nextLine();
    }
}
