package dungeon;
import java.util.*;

public class Dungeon {    
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Vampires allVampires;
    private Location player;
    private int swordSwings;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.allVampires = new Vampires(this.vampires, this.length, this.height);
        this.player = new Location(this.length, this.height);
        this.swordSwings = 7;
    }
    
    public void run(){
        Scanner reader = new Scanner(System.in);
        this.allVampires.spawnVampires();
        
        //introduction
        System.out.println("You (@) emerge into the lair of the vampires (v)."
                + "\n\nArmed with nothing but your trusty lantern and your "
                + "ancestral sword,"
                + "\nyou must face them. Stir your courage."
                + "\n\nTrusty lantern has " + this.moves + " charges left."
                        + "\nAttack in the dark: use wsad to navigate"
                        + " the void,"
                        + "\nthen use trusty lantern to see what you hit. (Hit enter)."
                        + "\n\nBe strategic, plan your attacks."
                        + "\n\nIt is only safe to make " + this.swordSwings 
                        + " moves at a time."
                        + "\n(Enter as many commands as you choose, only first " 
                        + this.swordSwings + " will register).\n");
        this.display();
        
        while(this.moves >0){
            this.moves--;
            String commands = this.read(reader);
            if (commands.equals("quit")){
                break;
            }
            //
            this.playerMoves(commands);
            this.display();
            if(this.checkVictory()){
                System.out.println("YOU WIN"
                        + "\nSword slices rushing leaves"
                        + "\nVampire autumn has arrived"
                        + "\nTrusty lantern rests");
                break;
            }
            if(this.checkLoss()){
                System.out.println("YOU LOSE"
                        + "\nVoid envelops me"
                        + "\nVampires drink, blood flows, heart slows"
                        + "\nLantern, where are you?");
                break;
            }
        }
    }
    
    public void playerMoves(String commands){
        int commandLength = commands.length();
        int i = 0;
        while (i < commandLength && i < this.swordSwings){
            if(commands.charAt(i) == 'w'){
                this.player.move("w");
            }
            if(commands.charAt(i) == 's'){
                this.player.move("s");
            }
            if(commands.charAt(i) == 'a'){
                this.player.move("a");
            }
            if(commands.charAt(i) == 'd'){
                this.player.move("d");
            }
            this.allVampires.dustVampire(this.player.locID());
            if(this.vampiresMove){
                this.allVampires.moveVampires();
                this.allVampires.dustVampire(this.player.locID());
            }
            i++;
        }
    }
    
    public String read(Scanner reader){
        String commands = reader.nextLine();
        return commands;
    }
    
    public void moveVampires(){
        this.allVampires.moveVampires();
        this.display();
    }
    
    public boolean checkVictory(){
        if(this.allVampires.howManyVampires() == 0){
            return true;
        }
        return false;
    }
    
    public boolean checkLoss(){
        if(this.moves == 0 && this.allVampires.howManyVampires() >0){
            return true;
        }
        return false;
    }
    
    public void display(){
        int h = 0;
        System.out.println("Lantern Charges: " + this.moves);
        System.out.println();
        System.out.print("@ " + this.player.toString());
        System.out.println(this.allVampires.toString());
        System.out.println();
        
        while(h < this.height){
            int l = 0;
            while (l < this.length){
                if(this.player.printLocation(l, h)){
                    System.out.print("@");
                }
                if(this.allVampires.printVampire(l, h)){
                    System.out.print("v");
                }
                else if (!this.allVampires.printVampire(l, h) && 
                        !this.player.printLocation(l, h)){
                    System.out.print(".");
                }
                l++;
            }
            System.out.println();
            h++;
        }
        System.out.println();
        System.out.println();
    }
}
