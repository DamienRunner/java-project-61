package hexlet.code.games;

import hexlet.code.service.GameProcessService;

import static hexlet.code.service.Constants.MIN_RANDOM;

public final class Even implements Game {

    private static final int MAX_RANDOM = 100;
    private static String answer;
    private static boolean booleanAnswer;

    public void printQuestionAndCheck() {
        int number = GameProcessService.getRandomInt(MIN_RANDOM, MAX_RANDOM);
        System.out.println("Question: " + number);
        booleanAnswer = number % 2 == 0;
        answer = booleanAnswer ? "yes" : "no";
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

    public void printRules() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public boolean checkGuess(String guess) {
        System.out.println("Your answer: " + guess);
        if (guess.equals("yes") || guess.equals("no")) {
            boolean checkAnswer = guess.equals("yes");
            return checkAnswer == booleanAnswer;
        } else {
            return false;
        }
    }
}
