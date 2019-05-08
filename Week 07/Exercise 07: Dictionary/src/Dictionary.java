import java.util.HashMap;
import java.util.ArrayList;
public class Dictionary {
    
    private HashMap<String, String> translations;
    public Dictionary(){
        this.translations = new HashMap<String, String>();
    }
    
    public void add(String word, String translation){
       this.translations.put(word, translation);
    }
    
    public String translate(String word){
        if(this.translations.containsKey(word)){
            return this.translations.get(word);
        }
        return null;
    }
    
    public int amountOfWords(){
        return this.translations.size();
    }
    
    public ArrayList<String> translationList(){        
        ArrayList<String> translationList = new ArrayList<String>();
        for(String key: this.translations.keySet()){
            translationList.add(key +" = " + this.translations.get(key));
        }
        return translationList;
    }
}
