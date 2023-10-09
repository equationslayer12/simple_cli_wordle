public class Letter {
    char letter;
    LetterStatus status;

    public Letter(char letter, LetterStatus status) {
        this.letter = letter;
        this.status = status;
    }

    public void setStatus(LetterStatus status) {
        this.status = status;
    }
}
