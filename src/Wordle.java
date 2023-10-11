import java.util.Locale;
import java.util.Scanner;

public class Wordle {
    Keyboard keyboard;
    Guess[] guesses;

    static int numberOfGuesses = 6;

    public void play() {
        String targetWord = chooseRandomWord();

        this.keyboard = new Keyboard();
        this.guesses = new Guess[numberOfGuesses];

        Cli cli = new Cli(guesses, keyboard);
        Scanner scan = new Scanner(System.in);
        boolean hasWon = false;
        for (int guessIndex = 0; guessIndex < numberOfGuesses; guessIndex++) {
            if (hasWon)
                break;
            cli.render();
            String input = "";
            while (input.length() != 5) {
                input = scan.nextLine().toUpperCase();
            }
            Guess guess = new Guess(new Letter[input.length()]);
            for (int letterIndex = 0; letterIndex < input.length(); letterIndex++) {
                char letter = input.charAt(letterIndex);
                LetterStatus letterStatus = getLetterStatus(letter, letterIndex, targetWord);
                switch (letterStatus) {
                    case correct -> guess.correctCount++;
                    case wrong -> guess.wrongCount++;
                    case wrongPosition -> guess.wrongPositionCount++;
                }

                guess.letters[letterIndex] = new Letter(letter, letterStatus);
                keyboard.updateLetter(letter, letterStatus);
                if (guess.correctCount == input.length())
                    hasWon = true;
            }

            // correct all the wrong positions by looping backwards. makes sense right?
            for (int letterIndex = input.length() - 1; letterIndex >= 0; letterIndex--) {
                Letter letter = guess.letters[letterIndex];
                if (letter.status != LetterStatus.wrongPosition)
                    continue;
                if (countLetterOccurances(letter.letter, targetWord)
                        - (countLetterWrongPosition(letter.letter, guess) - 1)  // -1 because we're not including ourselves
                        - countLetterCorrect(letter.letter, guess) <= 0) {
                    letter.status = LetterStatus.wrong;
                    guess.wrongCount++;
                    guess.wrongPositionCount--;
                }
            }
            this.guesses[guessIndex] = guess;
        }

        cli.render();
        if (hasWon)
            System.out.println("Formal congratulations.");
    }

    private int countLetterWrong(char letter, Guess guess) {
        int count = 0;
        for (Letter guessLetter : guess.letters) {
            if (guessLetter.status == LetterStatus.wrong && letter == guessLetter.letter)
                count++;
        }
        return count;
    }

    private int countLetterCorrect(char letter, Guess guess) {
        int count = 0;
        for (Letter guessLetter : guess.letters) {
            if (guessLetter.status == LetterStatus.correct && letter == guessLetter.letter)
                count++;
        }
        return count;
    }


    private int countLetterWrongPosition(char letter, Guess guess) {
        int count = 0;
        for (Letter guessLetter : guess.letters) {
            if (guessLetter.status == LetterStatus.wrongPosition && letter == guessLetter.letter)
                count++;
        }
        return count;
    }

    private int countLetterOccurances(char letter, String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == letter)
                count++;
        }
        return count;
    }

    private LetterStatus getLetterStatus(char letter, int letterIndex, String targetWord) {
        if (letterIsWrong(letter, targetWord))
            return LetterStatus.wrong;

        else if (letterIsCorrect(letter, letterIndex, targetWord))
            return LetterStatus.correct;

        else
            return LetterStatus.wrongPosition;

    }

    private boolean letterIsWrong(char letter, String targetWord) {
        for (int letterIndex = 0; letterIndex < targetWord.length(); letterIndex++) {
            if (letter == targetWord.charAt(letterIndex))
                return false;
        }
        return true;
    }

    private boolean letterIsCorrect(char letter, int letterIndex, String targetWord) {
        return letter == targetWord.charAt(letterIndex);
    }


    private String chooseRandomWord() {
        return "SONIC";
    }
}

