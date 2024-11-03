package hexlet.code.games;

import static hexlet.code.service.Constants.MAX_RANDOM;
import static hexlet.code.service.Constants.MIN_RANDOM;
import static hexlet.code.service.GameProcessService.getRandomInt;

public final class Prime implements Game {

    private static String answer;
    private static boolean booleanAnswer;

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
    public boolean checkGuess(String guess) {
        return (booleanAnswer && guess.equals("yes")) || (!booleanAnswer && guess.equals("no"));
    }

    @Override
    public void printRules() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    public void printQuestionAndCheck() {
        int number = getRandomInt(MIN_RANDOM, MAX_RANDOM);
        booleanAnswer = isPrime(number);
        answer = booleanAnswer ? "yes" : "no";
        System.out.printf("Question: %d\n", number);
    }

    @Override
    public void printErrorMessage(String playerName, String userGuessString) {
        if (userGuessString.equals("yes")) {
            System.out.printf("'" + userGuessString + "'" + " is wrong answer ;(. Correct answer was '%s'.\n", answer);
        } else {
            System.out.printf("'" + userGuessString + "'" + " is wrong answer ;(. Correct answer was '%s'.\n", answer);
        }
        System.out.println("Let's try again, " + playerName + "!");
    }
}
