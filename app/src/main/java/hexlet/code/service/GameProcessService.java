package hexlet.code.service;

import java.util.Random;

public class GameProcessService {
    private static final Random RANDOM = new Random();

    public static char getRandomOperation(Random random) {
        char[] operations = {'+', '-', '*'};
        return operations[random.nextInt(operations.length)];
    }

    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt(min, max);
    }
}
