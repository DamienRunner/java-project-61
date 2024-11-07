package hexlet.code.games;

import hexlet.code.service.GameProcessService;

public final class Even implements Game {

    public static final int MIN_RANDOM = -100;
    private static final int MAX_RANDOM = 100;
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public String[] getGameData() {
        int number = GameProcessService.getRandomInt(MIN_RANDOM, MAX_RANDOM);
        return new String[]{String.valueOf(number), number % 2 == 0 ? "yes" : "no"};
    }

    public String getRules() {
        return RULES;
    }
}
