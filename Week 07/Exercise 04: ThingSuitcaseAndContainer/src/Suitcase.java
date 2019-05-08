import java.util.ArrayList;

public class Suitcase {    
    private int maxWeight;
    private int suitcaseWeight;
    private ArrayList<Thing> thingsInSuitcase;
    
    public Suitcase(int maxWeight){
        this.maxWeight = maxWeight;
        this.thingsInSuitcase = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing) {
        if ((this.suitcaseWeight + thing.getWeight()) <= this.maxWeight){
            this.thingsInSuitcase.add(thing);
            this.suitcaseWeight += thing.getWeight();
        }        
    }
    
    public void printThings(){
        for(Thing t : this.thingsInSuitcase){
            System.out.println(t.toString());
        }
    }
    
    public int totalWeight(){
        int totalWeight = 0;
        for(Thing t: this.thingsInSuitcase){
            totalWeight += t.getWeight();
        }
        return totalWeight;
    }
    
    public String toString(){
        if (this.thingsInSuitcase.size() == 1){
            return "" + this.thingsInSuitcase.size() + " thing (" + this.suitcaseWeight + " kg)"; 
        }
        if (this.thingsInSuitcase.size() == 0){
            return "empty (" + this.suitcaseWeight + " kg)"; 
        }
        else {
            return "" + this.thingsInSuitcase.size() + " things (" + this.suitcaseWeight + " kg)";
        }
    }
    
    public Thing heaviestThing(){
        if (this.thingsInSuitcase.size() == 0){
            return null;
        }
        Thing heaviestThing = this.thingsInSuitcase.get(0);
        for(Thing t : this.thingsInSuitcase){
            if(t.getWeight() > heaviestThing.getWeight())
                heaviestThing = t;
        }
        return heaviestThing;
    }    
}
