//airport interface which allows a user to add plans, define their capacity, and add flights associated to those planes

import java.util.Scanner;

public class Main {    
    public static void main(String[] args) {
        
        // Write your main program here. Implementing your own classes will be useful.
        Scanner reader = new Scanner(System.in);
        AirportPanel aPanel = new AirportPanel(reader);
        aPanel.start();
        FlightServicePanel aFlightPanel = new FlightServicePanel(reader, aPanel);
        aFlightPanel.start();
    }
}
