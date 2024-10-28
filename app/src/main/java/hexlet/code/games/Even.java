package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

public final class Even implements Game {
    private int counter;
    private String playerName;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    @Override
    public void startGame() {
        counter = 0;
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        playerName = Cli.introduceYourself();
        System.out.println("Hello, " + playerName);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        game();
    }

    @Override
    public void endGame() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private void game() {
        while (counter < END_CORRECT_ANSWERS_THRESHOLD) {
            int number = getRandomNumber();
            System.out.println("Question: " + number);
            String userGuessString = Cli.scanLine().toLowerCase();
            boolean userGuess = checkGuess(userGuessString, number % 2 == 0);
            if (userGuess) {
                System.out.println("Correct!");
                counter++;
            } else {
                printErrorMessages(userGuessString);
                break;
            }
        }
        if (counter == END_CORRECT_ANSWERS_THRESHOLD) {
            endGame();
        }
    }

    private boolean checkGuess(String guess, boolean even) {
        System.out.println("Your answer: " + guess);
        if (guess.equals("yes") || guess.equals("no")) {
            boolean answer = guess.equals("yes");
            return answer == even;
        } else {
            return false;
        }
    }

    private void printErrorMessages(String userGuessString) {
        if (userGuessString.equals("yes")) {
            System.out.println("'" + userGuessString + "'" + " is wrong answer ;(. Correct answer was 'no'.");
        } else {
            System.out.println("'" + userGuessString + "'" + " is wrong answer ;(. Correct answer was 'yes'.");
        }
        System.out.println("Let's try again, " + playerName + "!");
    }
}
