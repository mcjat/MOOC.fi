public class Bird  {
    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    public int hashCode(){
        return this.ringingYear;
    }
    
    public String getLatinName(){
        return this.latinName;
    }
    
    public boolean equals(Object bird){
        Bird aBird = (Bird)bird;
        if(this.getLatinName().equals(aBird.getLatinName()) && this.hashCode() == bird.hashCode()){
            return true;
        }
        return false;
    }
}


