package tools;
import java.util.*;

public class PersonalDuplicateRemover implements DuplicateRemover {    
    private Map<String, Integer> characterList;
    
    public PersonalDuplicateRemover(){
        this.characterList = new HashMap<String, Integer>();
    }
    
    public void add(String characterString){
        while(true){
            if(!this.characterList.containsKey(characterString)){
                this.characterList.put(characterString, 0);
                break;
            }
            if(this.characterList.containsKey(characterString)){
                int numOfDuplicates = this.characterList.get(characterString);
                numOfDuplicates++;
                this.characterList.remove(characterString);
                this.characterList.put(characterString, numOfDuplicates);
                break;
            }
        }        
    }
    
    public int getNumberOfDetectedDuplicates(){
        int numberOfDupes = 0;
        for(String c: this.characterList.keySet()){
            if(this.characterList.get(c) > 0){
                numberOfDupes += this.characterList.get(c);
            }            
        }
        return numberOfDupes;
    }
    
    public Set<String> getUniqueCharacterStrings( ) {
        Set<String> uniqueCharacterStrings = new HashSet<String>();
        for(String c : this.characterList.keySet()){
            uniqueCharacterStrings.add(c);
        }
        return uniqueCharacterStrings;
    }
    
    public void empty(){
        this.characterList.clear();
    }
}
