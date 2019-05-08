package dungeon;
import java.util.*;

public class Vampires {    
    private int howMany;
    private int length;
    private int height;
    private Collection<Location> vampires;
    
    public Vampires(int howMany, int length, int height){
        this.height = height;
        this.length = length;
        this.howMany = howMany;
        this.vampires = new ArrayList<Location>();
    }
    
    public void spawnVampires(){
        while(this.vampires.size() < this.howMany){
            Location possible = new Location(this.length, this.height);
            possible.randomizeCoords();
            int impossible = 0;
            if(!this.vampires.isEmpty()){
                for(Location l: this.vampires){
                    if(possible.getX() == l.getX() && possible.getY()==l.getY()){
                        impossible = 1;
                    }
                    if(possible.getX() == 0 && possible.getY()==0){
                        impossible = 1;
                    }
                }
                if(impossible == 0){
                    this.vampires.add(possible);
                }
            }
            else{
                this.vampires.add(possible);
            }
        }
    }
    
    //temp holds all of the moves while allowing this.vampires to remain intact
    //add new moves to temp once validated against temp and against this.vampires
    //once validated temp will move into this.vampires
    public void moveVampires(){
        Collection<Location> temp = new ArrayList<Location>();
        Location holdingSpot;
        int cannotMove = 0;
        for(Location l : this.vampires){
            
            //to cover first entry into temp
            holdingSpot = new Location(l.getLength(), l.getHeight());
            holdingSpot.setLocation(l.getX(), l.getY());
            holdingSpot.move();
            if(temp.isEmpty()){
                for(Location m : this.vampires){
                    if(m.getX()==holdingSpot.getX() && m.getY()==holdingSpot.getY()){
                        cannotMove = 1;
                    } 
                }
            }       
            
            //to cover subsequent entries
            if(!temp.isEmpty()){
                for(Location t: temp){
                    if(t.getX() == holdingSpot.getX() && t.getY() == holdingSpot.getY()){
                        cannotMove = 1;
                    }
                }
                for(Location n : this.vampires){
                    if(n.getX() == holdingSpot.getX() && n.getY() == holdingSpot.getY()){
                        cannotMove = 1;
                    }
                }
            }
            if(cannotMove == 1){
                    temp.add(l);
            }
            else if(cannotMove == 0){
                    temp.add(holdingSpot);
            }
        }
        
        //clears out original list, moves temp list into it, then clears out temp
        this.vampires.clear();
        for(Location l : temp){
            this.vampires.add(l);
        }
        temp.clear();
    }
    
    //location is given to method, if any vampire shares that location, vampire turns to dust
    public void dustVampire(int locID){ 
        ArrayList<Location> toBeRemoved = new ArrayList<Location>();
        for(Location l : this.vampires){
            if(l.locID() == locID){
                toBeRemoved.add(l);
            }
        }
        this.vampires.removeAll(toBeRemoved);
    }
    
    //returns true if any vampires are at given location
    public boolean printVampire(int lengthCheck, int heightCheck){
        int givenLocID = (lengthCheck*10) + heightCheck;
        for(Location l : this.vampires){
            if(givenLocID == l.locID()){
                return true;
            }
        }
        return false;
    }
    
    public int howManyVampires(){
        return this.vampires.size();
    }
    
    public String toString(){
        String string = "";
        for(Location l : this.vampires){
                string += "\nv " + l.toString();
        }
        return string;
    }    
}
