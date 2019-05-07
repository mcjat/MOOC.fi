
package dictionary;
import java.util.*;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{    
    private Map<String, Set<String>> words;        
    
    public PersonalMultipleEntryDictionary(){
        this.words = new HashMap<String, Set<String>>();        
    }
    
    public void add(String word, String entry){
        if(!this.words.containsKey(word)){
            this.words.put(word, new HashSet<String>());            
        }        
        Set<String> definition = this.words.get(word);
        definition.add(entry);        
    }
    
    public Set<String> translate(String word){
        if(!this.words.containsKey(word)){
            return null;
        }
        return this.words.get(word);
    }
    
    public void remove(String word){
        this.words.remove(word);
    }
    
}
