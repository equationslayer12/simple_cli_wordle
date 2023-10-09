public class Keyboard {
    Letter[] letters;
    String alphabet = "qwertyuiopasdfghjklzxcvbnm";
    public Keyboard() {
        this.letters = new Letter[alphabet.length()];

        for (int i = 0; i < alphabet.length(); i++) {
            letters[i] = new Letter(alphabet.charAt(i), LetterStatus.unchecked);
        }
    }
}
