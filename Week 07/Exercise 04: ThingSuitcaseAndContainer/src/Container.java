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
