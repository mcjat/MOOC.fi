package farmsimulator;
import java.util.*;

public class Cow implements Milkable, Alive{    
    private double capacity;
    private double available;
    private String cowName;

    //cows may be named by user, if not a random string will be assigned
    public Cow(){
        this.generateName();
        this.generateCapacity();        
    }

    public Cow(String name){
        this.cowName = name;
        this.generateCapacity();
    } 
    
    //creates a random name between 3 and 5 characters for cow
    public void generateName(){
        String randChars = "abcdefghijklmnoprstuv";
        Random rand = new Random();
        StringBuilder randName = new StringBuilder();
        int i = rand.nextInt(3)+2;
        while(randName.length() <= i){
            randName.append(randChars.charAt(rand.nextInt(randChars.length())));
        }
        this.cowName = randName.toString();
    }

    //sets udder capacity for cow
    public void generateCapacity(){
        this.available = 0.0;
        Random rand = new Random();
        this.capacity = rand.nextInt(25)+15;
    }


    public String getName(){
        return this.cowName;
    }
        
    public double getCapacity(){
        return this.capacity;
    }  
    
    public double getAmount(){
        return this.available;
    }
        
    //all milk a cow has produced should be returned when milked
    @Override
    public double milk() {
        double milked = this.available;
        this.available = 0.0;
        return milked;
    }
    
    //each hour a cow lives it produces between .7 and 2 litres of milk
    //assumes cows stop milk production once udders are full
    @Override
    public void liveHour() {
        Random rand = new Random();
        double produced = (rand.nextInt(13) + 7)/10.0;
        if((this.available + produced) >= this.capacity){
            this.available = this.capacity;
        }
        else{
            this.available += produced;
        }
    }
      
    @Override
    public String toString(){
        return this.getName() + " " + Math.ceil(this.getAmount()) + "/" +
                Math.ceil(this.getCapacity());
    }
}
