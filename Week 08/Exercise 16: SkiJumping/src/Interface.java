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
