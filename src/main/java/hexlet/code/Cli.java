package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner scanner = new Scanner(System.in);

    public static String introduceYourself() {
        return scanner.nextLine();
    }

    public static String scanLine() {
        return scanner.nextLine();
    }
}
