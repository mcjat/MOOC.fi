//exercise for understanding basics of interfaces
public class Main {
    public static void main(String[] args) {
        MilitaryService SgtJacob = new MilitaryService(1200);
        CivilService AdminJacob = new CivilService();
        
        SgtJacob.work();
        SgtJacob.work();
        SgtJacob.work();
        SgtJacob.work();
        SgtJacob.work();
        AdminJacob.work();
        AdminJacob.work();
        System.out.println("Jacob has " + SgtJacob.getDaysLeft()
                + " days of military service and " + AdminJacob.getDaysLeft()
                + " days of civil sercice remaining.");
        
        SgtJacob.work();
        SgtJacob.work();
        SgtJacob.work();
        SgtJacob.work();
        SgtJacob.work();
        AdminJacob.work();
        AdminJacob.work();
        System.out.println("Jacob has " + SgtJacob.getDaysLeft()
                + " days of military service and " + AdminJacob.getDaysLeft()
                + " days of civil sercice remaining.");
        
      
    }
}


public interface NationalService {
    int getDaysLeft();
    void work();
}

public class CivilService implements NationalService {
    private int daysLeft;
    
    public CivilService(){
        this.daysLeft = 362;
    }
    public int getDaysLeft(){
        return this.daysLeft;
    }
    
    public void work(){
        if(this.daysLeft !=0){
            this.daysLeft -= 1;
        }
    }
    
    
}


public class MilitaryService implements NationalService{
    private int daysLeft;
    
    public MilitaryService(int daysLeft){
        this.daysLeft = daysLeft;
    }
    
    public int getDaysLeft(){
        return this.daysLeft;
    }
    
    public void work(){
        if(this.daysLeft != 0){
            this.daysLeft -= 1;
        }
    }
    
}
