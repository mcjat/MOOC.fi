/*  Takes inputted String and replaces pre-determined characters with 
*   new characters then prints new string. Example: for changes R,r & a,o & n,w
*   Randy becomes rowdy
*/
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Test your program here
    ArrayList<Change> changes = new ArrayList<Change>();

    changes.add( new Change('a', 'b') );
    changes.add( new Change('k', 'x') );
    changes.add( new Change('o', 'å') );

    String word = "carrot";

    for (Change Change : changes) {
        word = Change.change(word);
    }

    System.out.println(word);  // print cbrråt
        
        
    }
}

public class Change {
    private char fromChar;
    private char toChar;
           
    public Change(char fromCharacter, char toCharacter){
        this.fromChar = fromCharacter;
        this.toChar = toCharacter;
    }
    
    public String change(String characterString){
        char[] characterStringArray = characterString.toCharArray();
        for(int i = 0; i!= characterString.length(); i++ ) {
            char holder = characterString.charAt(i);
            if (holder == this.fromChar){
                characterStringArray[i] = this.toChar;
            }
        }
        return String.valueOf(characterStringArray);
    }
        
}

import java.util.ArrayList;
public class Changer {
    private ArrayList<Change> listOfChange = new ArrayList<Change>();    
    public Changer(){
        
    }
    
    public void addChange (Change change) {
        this.listOfChange.add(change);
    }
    
    public String change(String characterString){
        for(Change change : this.listOfChange){
            characterString = change.change(characterString);
        }
        return characterString;
    }
    
}
