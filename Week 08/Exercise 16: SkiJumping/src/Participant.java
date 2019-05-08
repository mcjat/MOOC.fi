import java.util.ArrayList;

public class Participant implements Comparable<Participant> {
    private String name;
    private int points;
    private ArrayList<Integer> lengths;
    
    public Participant(String name){
        this.name = name;
        this.points = 0;
        this.lengths = new ArrayList<Integer>();
    }
    
    public void addPoints(int howMany){
        this.points += howMany;
    }    

    public String getName(){
        return this.name;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public void addLength(int length){
        this.lengths.add(length);        
    }
    
    public String lengthToString(){
        String length = "";
        int i = 0;
        while (i <=(this.lengths.size()-1)){
            length = length + this.lengths.get(i);
            if(i<(this.lengths.size()-1)){
                length = length +" m, ";
            }
            if(i == (this.lengths.size()-1)){
                length = length + " m";
            }
            i++;
        }
       return length; 
    }
    
    public int compareTo(Participant participant){
        if(this.points == participant.getPoints()){
            return 0;
        }
        if(this.points > participant.getPoints()){
            return 1;
        }
        return -1;
    }
    
    public String toString(){
        return this.name + " (" + this.points + " points)";
    }
}
