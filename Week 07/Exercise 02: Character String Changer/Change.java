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
