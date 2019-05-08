package farmsimulator;

//milking robot will milk cows and carefully fill up its tank
public class MilkingRobot {    
    private BulkTank bulkTank;
    
    public MilkingRobot(){
    }
    
    public BulkTank getBulkTank(){
        return this.bulkTank;
    }
    
    public void setBulkTank(BulkTank tank){
        this.bulkTank = tank;
    }
    
    //MilkingRobot has to have a tank to be fully installed
    public void milk(Milkable milkable){
        if(this.getBulkTank() == null){
            throw new IllegalStateException("This MilkingRobot hasn't been installed");
        }
        double milk = milkable.milk();
        this.bulkTank.addToTank(milk);
    }
}
