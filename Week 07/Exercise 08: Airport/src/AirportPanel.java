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
