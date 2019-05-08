package farmsimulator;
import java.util.*;

public class BulkTank {    
    private double volume;
    private double capacity;
    
    //standard tank capacity is 2000 litres, user may also assign capacity
    //volume is assumed to be zero when tank is generated
    public BulkTank(){
        this.capacity = 2000.0;
        this.volume = 0.0;
    }
    
    public BulkTank(double capacity){
        this.capacity = capacity;
        this.volume = 0.0;
    }
    
    public double getCapacity(){
        return this.capacity;
    }
    
    public double getVolume(){
        return this.volume;
    }
    
    public double howMuchFreeSpace(){
        return (this.getCapacity() - this.getVolume());
    }
    
    //can only add milk until capacity is reached; no overflow concerns
    //farm workers are very precise
    public void addToTank(double amount){
        if((amount + this.getVolume()) >= this.getCapacity()){
            this.volume = this.capacity;
        }
        else{
            this.volume += amount;
        }
    }
    
    //cannot return more milk than is available
    public double getFromTank(double amount){
        if(amount >= this.getVolume()){
            amount = this.getVolume();
            this.volume = 0;
            return amount;
        }
        else{
            this.volume -= amount;
            return amount;
        }
    }
    
    @Override
    public String toString(){
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
