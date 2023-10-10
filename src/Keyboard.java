public class Keyboard {
    Letter[] letters;
    String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
    public Keyboard() {
        this.letters = new Letter[alphabet.length()];

        for (int i = 0; i < alphabet.length(); i++) {
            letters[i] = new Letter(alphabet.charAt(i), LetterStatus.unchecked);
        }
    }

    public void updateLetter(char letter, LetterStatus letterStatus) {
        for (Letter keyboardLetter : this.letters) {
            if (keyboardLetter.letter == letter)
                keyboardLetter.status = letterStatus;
        }
    }
}
