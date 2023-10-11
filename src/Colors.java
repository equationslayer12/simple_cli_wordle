import java.util.HashMap;
import java.util.Map;

class Colors {
    Map<LetterStatus, String> colorsDict;
    public Colors() {
        this.colorsDict = InitializeColorDict();
        
        // System.out.println(colorsDict.get("RED") +  "THIS SHOULD BE RED " + colorsDict.get("RESET"));
    }

    
    private Map<LetterStatus, String> InitializeColorDict() {
        Map<LetterStatus, String> colorsDict = new HashMap<LetterStatus, String>();
        colorsDict.put(LetterStatus.unchecked, "\u001B[37m"); // unchecked
        colorsDict.put(LetterStatus.wrong, "\u001B[31m");// wrong red
        colorsDict.put(LetterStatus.correct, "\u001B[32m");// green
        colorsDict.put(LetterStatus.wrongPosition, 	"\u001B[33m"); //yellow
        colorsDict.put(LetterStatus.reset, 	"\u001B[0m"); //yellow

        return colorsDict;
    }
}


