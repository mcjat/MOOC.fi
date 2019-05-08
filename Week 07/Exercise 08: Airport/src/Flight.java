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
