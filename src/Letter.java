
public class Letter {
    char letter;
    LetterStatus status;
    Colors colors;

    public Letter(char letter, LetterStatus status) {
        this.letter = letter;
        this.status = status;
        this.colors = new Colors();
    }

    public void setStatus(LetterStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if (this.status == LetterStatus.correct) {
            return this.colors.colorsDict.get(LetterStatus.correct) + this.letter + this.colors.colorsDict.get(LetterStatus.reset);
        }
        else if (this.status == LetterStatus.wrong) {
            return this.colors.colorsDict.get(LetterStatus.wrong) + this.letter  + this.colors.colorsDict.get(LetterStatus.reset);
        }
        else if (this.status == LetterStatus.wrongPosition) {
            return this.colors.colorsDict.get(LetterStatus.wrongPosition) + this.letter + this.colors.colorsDict.get(LetterStatus.reset);
        }
        return this.colors.colorsDict.get(LetterStatus.unchecked) + this.letter + this.colors.colorsDict.get(LetterStatus.reset);
    }
}
