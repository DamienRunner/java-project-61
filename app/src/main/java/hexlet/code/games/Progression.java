package hexlet.code.games;

import static hexlet.code.service.Constants.MAX_ADDITIONAL_LENGTH;
import static hexlet.code.service.Constants.MAX_LENGTH;
import static hexlet.code.service.Constants.MIN_LENGTH;
import static hexlet.code.service.GameProcessService.getRandomInt;

public final class Progression implements Game {

    private static int answer;

    @Override
    public boolean checkGuess(String guess) {
        return answer == Integer.parseInt(guess);
    }

    @Override
    public void printRules() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    public void printQuestionAndCheck() {
        int length = getRandomInt(0, MAX_ADDITIONAL_LENGTH) + MIN_LENGTH;
        int start = getRandomInt(0, MAX_LENGTH);
        int step = getRandomInt(1, MIN_LENGTH);
        int hiddenIndex = getRandomInt(0, length);
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        System.out.print("Question: ");
        for (int i = 0; i < length; i++) {
            if (i == hiddenIndex) {
                System.out.print(".. ");
            } else {
                System.out.print(progression[i] + " ");
            }
        }
        answer = progression[hiddenIndex];
    }

    @Override
    public void printErrorMessage(String playerName, String userGuessString) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%d'.\n", userGuessString, answer);
        System.out.println("Let's try again, " + playerName + "!");
    }
}
