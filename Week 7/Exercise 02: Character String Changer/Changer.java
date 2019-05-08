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
