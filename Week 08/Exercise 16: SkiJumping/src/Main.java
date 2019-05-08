//game which allows user to enter names, then randomly generates a tournament involving the participants they set

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        Scanner reader = new Scanner(System.in);
        Interface jumpGame = new Interface(reader);
        jumpGame.startNaming();
        jumpGame.startTourney();
        jumpGame.endTourney(); 
    }
}      
