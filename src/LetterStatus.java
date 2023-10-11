public enum LetterStatus {
    unchecked,      // user haven't checked yet
    wrong,          // letter not in word
    wrongPosition,  // letter in word, but not in guessed position
    correct,         // letter in word and in right position
    reset
}
