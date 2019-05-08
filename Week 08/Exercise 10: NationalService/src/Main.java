//exercise for understanding basics of interfaces

public class Main {
    public static void main(String[] args) {
        // Test your code here!
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
