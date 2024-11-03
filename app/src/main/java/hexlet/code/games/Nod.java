package hexlet.code.games;

import static hexlet.code.service.Constants.MAX_RANDOM;
import static hexlet.code.service.GameProcessService.getRandomInt;

public final class Nod implements Game {

    private static int answer;

    private int getNod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public boolean checkGuess(String guess) {
        try {
            int parseAnswer = Integer.parseInt(guess);
            return parseAnswer == answer;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void printRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    public void printQuestionAndCheck() {
        int number1 = getRandomInt(0, MAX_RANDOM);
        int number2 = getRandomInt(0, MAX_RANDOM);
        answer = getNod(number1, number2);
        System.out.printf("Question: %d %d\n", number1, number2);
    }

    @Override
    public void printErrorMessage(String playerName, String userGuessString) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.\n", userGuessString, answer);
        System.out.println("Let's try again, " + playerName + "!");
    }
}
