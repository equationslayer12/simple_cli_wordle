public class Cli {
    Guess[] guesses;
    Keyboard keyboard;
    Colors colors;


    public Cli(Guess[] guesses, Keyboard keyboard){
        this.guesses = guesses;
        this.keyboard = keyboard;
        this.colors = new Colors();
    
    }
    public void render(){
        int guessSpaces = 16;
        int firstLineKB = guessSpaces -5;
        int secondLineKB = firstLineKB +1;
        int thirdLineKB = guessSpaces -2;
        

        // for guesses 
         // for adding spaces before :)
        for(int guessIndex = 0; guessIndex < this.guesses.length; guessIndex ++) {
            printGuessesSpaces(guessSpaces);
            if (this.guesses[guessIndex] != null) {
                for(int letter = 0; letter < this.guesses[guessIndex].letters.length; letter ++) {
                    Letter letterS = this.guesses[guessIndex].letters[letter];
                    System.out.print(letterS.toString() + " ");
                }
            }

            else {
                for(int letter = 0; letter < 5; letter ++) {
                    System.out.print("_ ");
                }
            }

             // for adding spaces before :)
            System.out.print("\n"); // for skip the guess #TODO pls fix the comments
        }

        System.out.println();
        // System.out.print("asdfdf");
        printGuessesSpaces(firstLineKB);
        for (int keyboardIndex = 0; keyboardIndex < this.keyboard.letters.length; keyboardIndex ++) {
            
            if (this.keyboard.letters[keyboardIndex] != null) {
                String letterS = this.keyboard.letters[keyboardIndex].toString();
                    System.out.print(letterS + " ");
            }

            if (keyboardIndex == 9) {
                System.out.print("\n");
                printGuessesSpaces(secondLineKB);
            }
            else if(keyboardIndex == 18) {
                System.out.print("\n");
                printGuessesSpaces(thirdLineKB);
            }
            else if(keyboardIndex == 25) {
                System.out.println();
            }

        }   
    }

    private void printGuessesSpaces(int numSpaces){
        for (int i = 0; i < numSpaces; i ++) {
            System.out.print(" ");
        }
    }
}
