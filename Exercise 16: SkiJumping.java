//game which allows user to enter names, then randomly generates a tournament involving the participants they set

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        Scanner reader = new Scanner(System.in);
        Interface jumpGame = new Interface(reader);
        //naming phase allows user to input names
        jumpGame.startNaming();
        //during tourney phase, user asks program to execute jumps, once they stop, it ends tournament and prints results
        jumpGame.startTourney();
        jumpGame.endTourney(); 
    }
}


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
    
    //generates a string which displays the length of all jumps a participant has executed
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


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Interface {
    private Scanner reader;
    private ArrayList<Participant> jumpers;
    public Interface(Scanner reader){
        this.reader = reader;
        this.jumpers = new ArrayList<Participant>();
    }
    
    public void startNaming(){
        System.out.println("Kumpula ski jumping week\n\n"
                + "Write the names of the participants one at a time;"
                + " an empty string brings you to the jumping phase.");
        int i = 0;
        while(true){            
            System.out.print("  Participant name: ");
            String command = this.reader.nextLine();
            if(command.equals("")){
                break;
            }
            this.jumpers.add(new Participant(command));
            i++;
        }  
              
        
    }
    
    public void startTourney(){
        System.out.println("\nThe tournament begins!");
        int i = 1;
        while(true){
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            if(!command.equals("jump")){
                break;                
            }         
            this.startRound(i);
            i++;                       
        }
    }
    
    //each time a user asks for a jump we generate a new round which shows the jump order printed
    //in reverse point order, then displays the length of the jump and the judge's tallies
    public void startRound(int i){
        System.out.println("\nRound " + i);
        Round round = new Round(this.jumpers, i);
        round.printJumpOrder();
        
        System.out.println("\nResults of round " + i);
        round.results();
        
    }
    
    public void endTourney(){
        System.out.println("\nThanks!"
                + "\n\nTournament results:"
                + "\nPosition    Name");
        Collections.sort(this.jumpers);
        Collections.reverse(this.jumpers);
        int i = 1;
        for(Participant p : this.jumpers){
            System.out.println(""+ i + "           " + p.toString());
            System.out.println("            jump lengths: " + p.lengthToString());
            i++;
        }
        
    }
    
}


import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
public class Round {
    private int[] judgeScores;
    private ArrayList<Participant> jumpers;
    private int whichRound;

    
    public  Round(ArrayList jumpers, int whichRound){
        this.jumpers = jumpers;
        this.whichRound = whichRound;
        this.judgeScores = new int[5];
        Collections.sort(this.jumpers);        
    }    
    
    public void printJumpOrder(){
        int i = 1;        
        System.out.println("\nJumping order: ");
        for(Participant p : this.jumpers){
            System.out.print("  " + i + ". " + p.toString()
                    + "\n");  
            i++;
        }        
    }
    
   public void results(){
       Random random = new Random();
       int length = 0;       
       for(Participant p : this.jumpers){
           //determine the length of the jump and add that info to participant
           //display length
           length = random.nextInt(60)+60;
           p.addLength(length);
           System.out.println("  "+ p.getName()+ "\n"
                   + "    length: " + length);
           //set points, add to participant, display
           int points = this.calculatePoints(length, p);
           p.addPoints(points);           
           System.out.println("    judge votes: " + Arrays.toString(this.judgeScores));          
       }      
   
   }
   
   public int calculatePoints(int length, Participant participant){
        Random random = new Random();         
        int i = 5;
        int lowScore = 100;
        int highScore = 0;
        //generate scores (not dissimilar to real life?)
        while(i>0){
           this.judgeScores[i-1] = ((random.nextInt(10)+10));
           i--;
        }
        //set high and low scores, begin tallying total score
        int totalScore = 0;
        i = 4;
        while (i>=0){
            totalScore+= this.judgeScores[i];       
            if(this.judgeScores[i]<lowScore){
                lowScore = this.judgeScores[i];
            }
            if(this.judgeScores[i]>highScore){
                highScore = this.judgeScores[i];
            }
            i--;
        } 
        //calculate total score
       return (totalScore + length - lowScore - highScore);
       
   }
    
}
