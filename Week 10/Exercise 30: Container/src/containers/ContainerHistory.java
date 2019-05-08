package containers;
import java.util.*;

public class ContainerHistory {
    private List<Double> situationHistory;
    public ContainerHistory(){
        this.situationHistory = new ArrayList<Double>();
    }
    
    public void add(double situation){
        this.situationHistory.add(situation);
    }
    
    public void reset(){
        this.situationHistory.clear();
    }
    
    public double maxValue(){
        if(this.situationHistory.isEmpty()){
            return 0;
        }
        double maxValue = 0.0;
        for(double d : this.situationHistory){
            if(d > maxValue){
                maxValue = d;
            }
        }
        return maxValue;
    }
    
    public double minValue(){
        if(this.situationHistory.isEmpty()){
            return 0;
        }
        double minValue = 9999999999.0;
        for(double d : this.situationHistory){
            if(d < minValue){
                minValue = d;
            }
        }
        return minValue;
    }
    
    public double average(){
        if(this.situationHistory.isEmpty()){
            return 0;
        }
        double average = 0.0;
        for(double d:this.situationHistory){
            average += d;
        }
    return (average/this.situationHistory.size());        
    }
    
    public double greatestFluctuation(){
        if(this.situationHistory.isEmpty()){
            return 0.0;
        }                
        double lastValue = this.situationHistory.get(0);
        double fluctuation = 0.0;
        for(double d : this.situationHistory){
            if(Math.abs(d-lastValue) > fluctuation){
                fluctuation = Math.abs(d-lastValue);
            }
            lastValue = d;
        }
        return fluctuation;
    }
    
    public double variance(){
        if(this.situationHistory.isEmpty()){
            return 0;
        }
        double variance = 0.0;
        for(double d: this.situationHistory){
            variance +=((d-this.average())*(d-this.average()));
        }
        return (variance/(this.situationHistory.size()-1));
    }    
    
    @Override
    public String toString(){
        String string = this.situationHistory.toString();
        return string;
    }
}
