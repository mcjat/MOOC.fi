//main is configured to test whether our weight limits are being correctly enforced
public class Main {
    public static void main(String[] args) {
        
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container){
        int brickWeight = 1;
        
        while(brickWeight <= 100){
            Suitcase tempSuitcase = new Suitcase(100);
            tempSuitcase.addThing(new Thing("Brick",brickWeight));
            container.addSuitcase(tempSuitcase);
            brickWeight++;
        }
    }
}
