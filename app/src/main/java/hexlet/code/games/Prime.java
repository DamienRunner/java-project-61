package hexlet.code.games;

import static hexlet.code.service.GameProcessService.getRandomInt;
import static java.lang.String.format;

public final class Prime implements Game {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 100;
    private static int question;

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getRules() {
        return RULES;
    }

    @Override
    public String getQuestionString() {
        question = getRandomInt(MIN_RANDOM, MAX_RANDOM);
        return format("%d", question);
    }

    @Override
    public String getAnswerString() {
        return isPrime(question) ? "yes" : "no";
    }
}
