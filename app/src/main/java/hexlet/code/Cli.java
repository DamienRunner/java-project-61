package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String introduceYourself() {
        return SCANNER.nextLine();
    }

    public static String scanLine() {
        return SCANNER.nextLine();
    }
}
