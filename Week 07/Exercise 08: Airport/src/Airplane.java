public class Airplane {    
    private String planeID;
    private int planeCapacity;
    
    public Airplane(String ID, int capacity){
        this.planeID = ID;
        this.planeCapacity = capacity;        
    }  
    
    public String toString(){        
        return this.planeID + " (" + this.planeCapacity + " ppl)";
    }
}
