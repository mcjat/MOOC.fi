package boxes;
import java.util.*;

public class MaxWeightBox extends Box{
    private Collection<Thing> boxes;
    private int maxWeight;
    
    public MaxWeightBox(int maxWeight){        
        this.maxWeight = maxWeight;
        this.boxes = new ArrayList<Thing>();
    }
    
    public int boxWeight(){
        int weight = 0;
        for(Thing t: this.boxes){
            weight += t.getWeight();
        }
        return weight;
    }
    
    @Override
    public void add(Thing thing) {
        if((thing.getWeight() + this.boxWeight()) <= this.maxWeight){            
            this.boxes.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        for(Thing t : this.boxes){
            if(t.equals(thing)){
                return true;
            }
        }
        return false;
    }
}
