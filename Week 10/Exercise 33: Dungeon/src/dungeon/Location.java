package dungeon;
import java.util.*;

public class Location {    
    private int xCoord;
    private int yCoord;
    private int length;
    private int height; 
    
    public Location(int length, int height){
        this.length = length;
        this.height = height;
        this.xCoord = 0;
        this.yCoord = 0;
    }
    
    public void randomizeCoords(){
        Random random = new Random();
        this.xCoord = random.nextInt(this.length);
        this.yCoord = random.nextInt(this.height);
    }
    
    /* Direction rules:
    *   w = up = y axis
    *   s = down = y axis
    *   a = left = x axis
    *   d = right = x axis
    *   moves must be legal to be executed
    */
    public void move(String direction){
        if(direction.equals("w")){
            if((this.yCoord - 1) >=0 ){
                this.yCoord--;
            }
        }
        
        if(direction.equals("s")){
           if((this.yCoord +1) < this.height){
               this.yCoord++;
           }
        }
        
        if(direction.equals("a")){
            if((this.xCoord-1) >= 0){
                this.xCoord--;
            }
        }
        
        if(direction.equals("d")){
            if((this.xCoord+1) < this.length){
                this.xCoord++;
            }
        }
    }
    
    public void setLocation(int x, int y){
        this.xCoord = x;
        this.yCoord =  y;
    }
    
    //for random moves
    public void move(){
        Random random = new Random();
        int coinFlipAxis = random.nextInt(2);
        int coinFlipSign = random.nextInt(2);
        // Axis 0 = x, Axis 1 = y
        //Sign 0 = positive, Sign 1 = negative
        if(coinFlipAxis ==0 && coinFlipSign == 0){
            if((this.xCoord+1) < this.length){
                this.xCoord++;
            }
        }
        
        if(coinFlipAxis == 0 && coinFlipSign ==1){
            if((this.xCoord-1)>=0){
                this.xCoord--;
            }
        }
        
        if(coinFlipAxis ==1 && coinFlipSign == 0){
            if((this.yCoord+1) < this.height){
                this.yCoord++;

            }
        }
        
        if(coinFlipAxis == 1 && coinFlipSign ==1){
            if((this.yCoord-1)>=0){
                this.yCoord--;
            }
        }        
    }
    
    public boolean printLocation(int lengthCheck, int heightCheck){
        int givenLocID = (lengthCheck*10) + heightCheck;
        if(givenLocID == this.locID()){
                return true;
            }
        return false;        
    }
    
    public String toString(){
        return this.getX() + " " + this.getY();
    }
    
    public int locID(){
        return ((this.xCoord*10) + this.yCoord);
    }
    
    public int getX(){
        return this.xCoord;
    }
    
    public int getY(){
        return this.yCoord;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public int getHeight(){
        return this.height;
    }
}
