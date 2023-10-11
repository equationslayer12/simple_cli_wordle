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

        for (int guessIndex = 0; guessIndex < numberOfGuesses; guessIndex++) {
            cli.render();
            String input = "";
            while (input.length() != 5) {
                input = scan.nextLine().toUpperCase();
            }
            Guess guess = new Guess(new Letter[input.length()]);
            for (int letterIndex = 0; letterIndex < input.length(); letterIndex++) {
                char letter = input.charAt(letterIndex);
                LetterStatus letterStatus = getLetterStatus(letter, targetWord);
                guess.letters[letterIndex] = new Letter(letter, letterStatus);
                keyboard.updateLetter(letter, letterStatus);
            }
            this.guesses[guessIndex] = guess; 
        }
    }

    private LetterStatus getLetterStatus(char letter, String targetWord) {
        if (letterIsWrong(letter, targetWord))
            return LetterStatus.wrong;

        else if (letterIsCorrect(letter, targetWord))
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

    private boolean letterIsCorrect(char letter, String targetWord) {
        for (int letterIndex = 0; letterIndex < targetWord.length(); letterIndex++) {
            if (letter == targetWord.charAt(letterIndex))
                return true;
        }
        return false;
    }


    private String chooseRandomWord() {
        return "SONIC";
    }
}

