import java.util.ArrayList;

public class Box implements ToBeStored {
    private double maxWeight;    
    private ArrayList<ToBeStored> thingsInBox;
    
    public Box(double maxWeight){
        this.maxWeight = maxWeight;
        this.thingsInBox = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored toBeStored){
        if ((toBeStored.weight() + this.weight()) <= this.maxWeight){
            this.thingsInBox.add(toBeStored);
        }
    }
    
    public double weight(){
        double weight = 0.0;
        for(ToBeStored obj : this.thingsInBox){
            weight += obj.weight();
        }
        return weight;
    }
    
    public String toString(){
        return "Box: " + this.thingsInBox.size() + " things, total weight " 
                + this.weight() + " kg";
    }
}
