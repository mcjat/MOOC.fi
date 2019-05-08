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
