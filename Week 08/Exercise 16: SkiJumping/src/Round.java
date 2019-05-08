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
