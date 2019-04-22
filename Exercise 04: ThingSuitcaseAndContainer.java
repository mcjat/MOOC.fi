//main is configured to test whether our weight limits are being correctly enforced
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container){
        int brickWeight = 1;
        while(brickWeight <= 100){
            Suitcase tempSuitcase = new Suitcase(100);
            tempSuitcase.addThing(new Thing("Brick",brickWeight));
            container.addSuitcase(tempSuitcase);
            brickWeight++;
        }
    }

}

//things go into Suitcases
public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName(){
        return this.name;
    }

    public int getWeight(){
        return this.weight;
    }

    public String toString(){
        return this.name + " (" + this.weight + " kg)";
    }

}

//suitcases can only hold so many things, suitcases go into containers
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

//containers can only hold so much weight
import java.util.ArrayList;
public class Container {
    
    private ArrayList<Suitcase> allSuitcases;
    private int maxWeightLimit;
    private int suitcasesWeight;
    
    public Container(int maxWeightLimit){
        this.maxWeightLimit = maxWeightLimit;
        this.allSuitcases = new ArrayList<Suitcase>();
        this.suitcasesWeight = 0;
    }
    
    public void addSuitcase(Suitcase suitcase){
        int weightTest = 0;
        for (Suitcase s : this.allSuitcases){
            weightTest += s.totalWeight();
        }
        if ((weightTest + suitcase.totalWeight()) <= this.maxWeightLimit){
        this.allSuitcases.add(suitcase);         
        this.suitcasesWeight += suitcase.totalWeight();
        }
    }
    
        
    public String toString(){
        return "" + this.allSuitcases.size() + " suitcases (" + this.suitcasesWeight + " kg)";
    }
    
    public void printThings(){
        for (Suitcase s : this.allSuitcases){
            s.printThings();
        }
    }
    
}
