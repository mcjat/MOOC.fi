package farmsimulator;
import java.util.*;

public class Farm implements Alive{    
    //three things every farm has
    private String owner;
    private Barn barn;
    private Collection<Cow> herd;
    
    public Farm(String name, Barn barn){
        this.owner = name;
        this.barn = barn;
        this.herd = new LinkedList<Cow>();
    }
    
    public String getOwner(){
        return this.owner;
    }
    
    public void addCow(Cow cow){
        this.herd.add(cow);
    }
    
    @Override
    public void liveHour(){
        for(Cow c : this.herd){
            c.liveHour();
        }
    }
    public void manageCows(){
        this.barn.takeCareOf(this.herd);
    }
    
    public void installMilkingRobot(MilkingRobot robot){
        this.barn.installMilkingRobot(robot);
    }
    
    public String toString(){
        String string = "Farm owner: " + this.getOwner() + "\nBarn bulk tank: " +
                this.barn.toString() + "\n";
        if(this.herd.isEmpty()){
            return string + "No cows.";
        }
        else{
            String cows = "";
            for(Cow c : this.herd){
                cows += "\n       " + c.toString();
            }
            return string + "Animals: " + cows;
        }
    }    
}
