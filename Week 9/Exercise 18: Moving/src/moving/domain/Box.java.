package moving.domain;
import java.util.ArrayList;

public class Box implements Thing{    
    private ArrayList<Thing> inTheBox;
    private int maximumCapacity;    
    public Box(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.inTheBox = new ArrayList<Thing>(); 
    }
    
    public boolean addThing(Thing thing){
        if((this.getVolume() + thing.getVolume()) <= this.maximumCapacity){
            this.inTheBox.add(thing);            
            return true;            
        }
        return false;
    }

    @Override
    public int getVolume() {
        int currentCapacity = 0;
        for (Thing t : this.inTheBox){
            currentCapacity += t.getVolume();
        }
        return currentCapacity;
    }
    
    public String toString(){
        String sinTheBox = "";
        for (Thing t: this.inTheBox){
            sinTheBox += t.toString() + "\n";            
        }
        return sinTheBox;
    }
}
