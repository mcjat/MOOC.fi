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

public class Airplane {
    
    private String planeID;
    private int planeCapacity;
    
    public Airplane(String ID, int capacity){
        this.planeID = ID;
        this.planeCapacity = capacity;        
    }  
    
    public String toString(){        
        return this.planeID + " (" + this.planeCapacity + " ppl)";
    }
    
   
}


public class Flight {
    
    private Airplane plane;
    private String depCode;
    private String arrvCode;
    
    public Flight(Airplane plane, String depCode, String arrvCode){
        this.plane = plane;
        this.depCode = depCode;
        this.arrvCode = arrvCode;
    }
    
    public String toString(){
        return this.plane.toString() + " (" + this.depCode + "-" + this.arrvCode +")";
    }
}

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class AirportPanel {
    private Scanner reader;
    private int flightID;
    
    private HashMap<String, Airplane> allPlanes;
    private HashMap<Integer, Flight> allFlights;
    
    
    public AirportPanel(Scanner reader){
        this.reader = reader;
        this.flightID = 0;
        this.allPlanes = new HashMap<String, Airplane>();
        this.allFlights = new HashMap<Integer, Flight>();
    }
    
    public void start(){
        
        System.out.println("Airport panel"
                + "\n--------------------\n");

        while(true){
            System.out.print("Choose operation:\n[1] Add airplane"
                    + "\n[2] Add flight"
                    + "\n[x] Exit"
                    + "\n> ");
            String command = this.reader.nextLine();
            if (command.equals("x")){
                break;
            }
            if(command.equals("1")){
                this.addPlane();
            }
            if(command.equals("2")){
                this.addFlight();
            }
            
        }
    }
    
    public void addPlane(){
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(this.reader.nextLine());
        this.allPlanes.put(planeID, new Airplane(planeID, planeCapacity));
    }
    
    public void addFlight(){
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give departure airport code: ");
        String depCode = this.reader.nextLine();
        System.out.print("Give destination airport code: ");
        String arrvCode = this.reader.nextLine();
        
        Airplane aPlane = this.allPlanes.get(planeID);
        this.allFlights.put(flightID, new Flight(aPlane, depCode, arrvCode));        
        this.flightID++;
    }
    
    public void printPlanes(){
        for(String key : this.allPlanes.keySet()){
            Airplane plane = this.allPlanes.get(key);
            System.out.println(plane.toString());
        }
    }
    
    public void printFlights(){
        for(int key : this.allFlights.keySet()){
            Flight flight = this.allFlights.get(key);
            System.out.println(flight.toString());
        }
    }
    
    public void findPlane(){
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.println(this.allPlanes.get(planeID).toString());
    }
    
}


import java.util.Scanner;
public class FlightServicePanel {
    private Scanner reader;
    private AirportPanel airportPanel;
    
    public FlightServicePanel(Scanner reader, AirportPanel airportPanel){
        this.reader = reader;
        this.airportPanel = airportPanel;
        
    }
    
    public void start(){
        System.out.println("\nFlight service"
                + "\n------------\n");
        while(true){
            System.out.print("Choose operation: "
                    + "\n[1] Print planes"
                    + "\n[2] Print flights"
                    + "\n[3] Print plane info"
                    + "\n[x] Quit"
                    + "\n> ");
            
            String command = reader.nextLine();            
            if(command.equals("x")){
                break;
            }
            if(command.equals("1")){
                this.airportPanel.printPlanes();
            }
            if(command.equals("2")){
                this.airportPanel.printFlights();
            }            
            if(command.equals("3")){
                this.airportPanel.findPlane();
            }            
        }
        
        
    }
}
