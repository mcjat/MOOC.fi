package farmsimulator;

import java.util.*;
public class Barn {    
    private MilkingRobot robot;
    private BulkTank tank;
    
    //barn has preinstalled tank, which the MilkingRobot is trained to use
    public Barn(BulkTank tank){
        this.tank = tank;
    }
    
    public BulkTank getBulkTank(){
        return this.tank;
    }    
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.robot = new MilkingRobot();
        this.robot.setBulkTank(tank);   
    }
    
    //only works if we have properly installed robot
    public void takeCareOf(Cow cow){
        if(this.robot == null){
            throw new IllegalStateException("MilkingRobot not installed");
        }
        this.robot.milk(cow);
    }
    
    //for caring for herd of cows
    public void takeCareOf(Collection<Cow> cows){
        if(this.robot == null){
            throw new IllegalStateException("MilkingRobot not installed");
        }
        for(Cow c : cows){
            this.robot.milk(c);
        }
    }
    
    public String toString(){
        return this.tank.toString();
    }
}
