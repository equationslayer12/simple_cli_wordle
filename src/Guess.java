public class Guess {
    Letter[] letters;
    int correctCount;
    int wrongCount;
    int wrongPositionCount;

    public Guess(Letter[] letters) {
        this.letters = letters;
        this.correctCount = 0;
        this.wrongCount = 0;
        this.wrongPositionCount = 0;
    }
}
